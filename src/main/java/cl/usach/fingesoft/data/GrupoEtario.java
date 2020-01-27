package cl.usach.fingesoft.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Persona;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.repository.RepositoryPersona;

@Component
public class GrupoEtario {

	private double menoresA15;
	private double entre15y65;
	private double masDe65;
	
	@Autowired
	private RepositoryPersona repoPersona;
	
	public double getMenoresA15() {
		return menoresA15;
	}
	public void setMenoresA15(double menoresA15) {
		this.menoresA15 = menoresA15;
	}
	public double getEntre15y65() {
		return entre15y65;
	}
	public void setEntre15y65(double entre15y65) {
		this.entre15y65 = entre15y65;
	}
	public double getMasDe65() {
		return masDe65;
	}
	public void setMasDe65(double masDe65) {
		this.masDe65 = masDe65;
	}
	
	
	
	public List<Double> registrosPorListaPersonas(List<Persona> listaPersonas){
		List<Double> subtotales = new ArrayList<>();
		double menoresA15 = 0;
		double entre15y65 = 0;
		double masDe65 = 0;
		double total = 0;
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getP09() < 15) {
				menoresA15++;
				total++;
			}
			else if(listaPersonas.get(i).getP09() >= 15 && listaPersonas.get(i).getP09() <= 65) {
				entre15y65++;
				total++;
			}
			else if(listaPersonas.get(i).getP09() > 65) {
				masDe65++;
				total++;
			}
		}
		subtotales.add(menoresA15);
		subtotales.add(entre15y65);
		subtotales.add(masDe65);
		subtotales.add(total);
		return subtotales;
	}
	
	
	public List<Double> registrosPorComuna(String comuna){
		return this.registrosPorListaPersonas(repoPersona.findByComuna(comuna));
	}
	
	public List<Double> registrosPorLocalidad(String comuna, String localidad){
		return this.registrosPorListaPersonas(repoPersona.findByLocalidad(comuna, localidad));
	}
	
	public GrupoEtario calcularGruposPorComuna(String comuna) {
		List<Double> totales = this.registrosPorComuna(comuna);
		GrupoEtario grupo = new GrupoEtario();
		grupo.setMenoresA15((totales.get(0) / totales.get(3)) * 100);
		grupo.setEntre15y65((totales.get(1) / totales.get(3)) * 100);
		grupo.setMasDe65((totales.get(2) / totales.get(3)) * 100);
		return grupo;
	}
	
	public GrupoEtario calcularGruposPorLocalidad(String comuna, String localidad) {
		List<Double> totales = this.registrosPorLocalidad(comuna, localidad);
		GrupoEtario grupo = new GrupoEtario();
		grupo.setMenoresA15((totales.get(0) / totales.get(3)) * 100);
		grupo.setEntre15y65((totales.get(1) / totales.get(3)) * 100);
		grupo.setMasDe65((totales.get(2) / totales.get(3)) * 100);
		return grupo;
	}
	
	public GrupoEtario calcularGruposPorComunas(List<Comuna> listaComunas) {
		GrupoEtario grupo = new GrupoEtario();
		List<Double> parciales;
		double menoresA15 = 0;
		double entre15y65 = 0;
		double masDe65 = 0;
		double total = 0;
		for(int i = 0; i < listaComunas.size(); i++) {
			parciales = this.registrosPorComuna(listaComunas.get(i).getNombre());
			menoresA15 = menoresA15 + parciales.get(0);
			entre15y65 = entre15y65 + parciales.get(1);
			masDe65 = masDe65 + parciales.get(2);
			total = total + parciales.get(3);
		}
		grupo.setMenoresA15((menoresA15 / total) * 100);
		grupo.setEntre15y65((entre15y65 / total) * 100);
		grupo.setMasDe65((masDe65 / total) * 100);
		return grupo;
	}
	
	public GrupoEtario calcularGruposPorProvincias(List<Provincia> listaProvincias) {
		GrupoEtario grupo = new GrupoEtario();
		List<Double> parciales;
		double menoresA15 = 0;
		double entre15y65 = 0;
		double masDe65 = 0;
		double total = 0;
		for(int j = 0; j < listaProvincias.size(); j++) {
			for(int i = 0; i < listaProvincias.get(j).getListaComunas().size(); i++) {
				parciales = this.registrosPorComuna(listaProvincias.get(j).getListaComunas().get(i).getNombre());
				menoresA15 = menoresA15 + parciales.get(0);
				entre15y65 = entre15y65 + parciales.get(1);
				masDe65 = masDe65 + parciales.get(2);
				total = total + parciales.get(3);
			}
		}
		grupo.setMenoresA15((menoresA15 / total) * 100);
		grupo.setEntre15y65((entre15y65 / total) * 100);
		grupo.setMasDe65((masDe65 / total) * 100);
		return grupo;
	}

}
