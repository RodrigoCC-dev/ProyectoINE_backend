package cl.usach.fingesoft.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Persona;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.model.Region;
import cl.usach.fingesoft.repository.RepositoryPersona;

@Component
public class Escolaridad {

	private double masDe5;
	private double masDe15;
	private double masDe19;
	private double masDe25;
	
	@Autowired
	private RepositoryPersona repoPersona;
	
	public double getMasDe5() {
		return masDe5;
	}
	public void setMasDe5(double masDe5) {
		this.masDe5 = masDe5;
	}
	public double getMasDe15() {
		return masDe15;
	}
	public void setMasDe15(double masDe15) {
		this.masDe15 = masDe15;
	}
	public double getMasDe19() {
		return masDe19;
	}
	public void setMasDe19(double masDe19) {
		this.masDe19 = masDe19;
	}
	public double getMasDe25() {
		return masDe25;
	}
	public void setMasDe25(double masDe25) {
		this.masDe25 = masDe25;
	}
	
	
	
	public List<Double> registrosPorLista(List<Persona> listaPersonas){
		List<Double> valores = new ArrayList<>();
		double cincoOmas = 0;
		double quinceOmas = 0;
		double diecinueveOmas = 0;
		double veinticincoOmas = 0;
		double total = 0;
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getEscolaridad() >= 25 && listaPersonas.get(i).getEscolaridad() < 30) {
				veinticincoOmas++;
				total++;
			}
			else if(listaPersonas.get(i).getEscolaridad() >= 19 && listaPersonas.get(i).getEscolaridad() < 25) {
				diecinueveOmas++;
				total++;
			}
			else if(listaPersonas.get(i).getEscolaridad() >= 15 && listaPersonas.get(i).getEscolaridad() < 19) {
				quinceOmas++;
				total++;
			}
			else if(listaPersonas.get(i).getEscolaridad() >= 5 && listaPersonas.get(i).getEscolaridad() < 15) {
				cincoOmas++;
				total++;
			}
			else {
				total++;
			}
		}
		valores.add(cincoOmas);
		valores.add(quinceOmas);
		valores.add(diecinueveOmas);
		valores.add(veinticincoOmas);
		valores.add(total);
		return valores;
	}
	
	
	public List<Double> registrosPorComuna(String nombre){
		return this.registrosPorLista(repoPersona.findByComuna(nombre));
	}
	
	
	public List<Double> registrosPorLocalidad(String comuna, String localidad){
		return this.registrosPorLista(repoPersona.findByLocalidad(comuna, localidad));
	}
	
	
	public Escolaridad calcularEscolaridadPorLocalidad(String comuna, String localidad) {
		List<Double> totales = this.registrosPorLista(repoPersona.findByLocalidad(comuna, localidad));
		Escolaridad datos = new Escolaridad();
		datos.setMasDe5((totales.get(0) / totales.get(4)) * 100);
		datos.setMasDe15((totales.get(1) / totales.get(4)) * 100);
		datos.setMasDe19((totales.get(2) / totales.get(4)) * 100);
		datos.setMasDe25((totales.get(3) / totales.get(4)) * 100);
		return datos;
	}
	
	
	public Escolaridad calcularEscolaridadPorComuna(String comuna) {
		List<Double> totales = this.registrosPorLista(repoPersona.findByComuna(comuna));
		Escolaridad datos = new Escolaridad();
		datos.setMasDe5((totales.get(0) / totales.get(4)) * 100);
		datos.setMasDe15((totales.get(1) / totales.get(4)) * 100);
		datos.setMasDe19((totales.get(2) / totales.get(4)) * 100);
		datos.setMasDe25((totales.get(3) / totales.get(4)) * 100);
		return datos;
	}
	
	
	public Escolaridad calcuarEscolaridadPorComunas(List<Comuna> listaComunas) {
		List<Double> totales = new ArrayList<>();
		List<Double> parciales;
		Escolaridad datos = new Escolaridad();
		double cincoOmas = 0;
		double quinceOmas = 0;
		double diecinueveOmas = 0;
		double veinticincoOmas = 0;
		double total = 0;
		totales.add(cincoOmas);
		totales.add(quinceOmas);
		totales.add(diecinueveOmas);
		totales.add(veinticincoOmas);
		totales.add(total);
		for(int i = 0; i < listaComunas.size(); i++) {
			parciales = this.registrosPorComuna(listaComunas.get(i).getNombre());
			totales.set(0, totales.get(0) + parciales.get(0));
			totales.set(1, totales.get(1) + parciales.get(1));
			totales.set(2, totales.get(2) + parciales.get(2));
			totales.set(3, totales.get(3) + parciales.get(3));
			totales.set(4, totales.get(4) + parciales.get(4));
		}
		datos.setMasDe5((totales.get(0) / totales.get(4)) * 100);
		datos.setMasDe15((totales.get(1) / totales.get(4)) * 100);
		datos.setMasDe19((totales.get(2) / totales.get(4)) * 100);
		datos.setMasDe25((totales.get(3) / totales.get(4)) * 100);
		return datos;
	}
	
	
	public Escolaridad calcularEscolaridadPorProvincias(List<Provincia> listaProvincias) {
		List<Double> totales = new ArrayList<>();
		List<Double> parciales;
		Escolaridad datos = new Escolaridad();
		double cincoOmas = 0;
		double quinceOmas = 0;
		double diecinueveOmas = 0;
		double veinticincoOmas = 0;
		double total = 0;
		totales.add(cincoOmas);
		totales.add(quinceOmas);
		totales.add(diecinueveOmas);
		totales.add(veinticincoOmas);
		totales.add(total);
		for(int j = 0; j < listaProvincias.size(); j++) {
			for(int i = 0; i < listaProvincias.get(j).getListaComunas().size(); i++) {
				parciales = this.registrosPorComuna(listaProvincias.get(j).getListaComunas().get(i).getNombre());
				totales.set(0, totales.get(0) + parciales.get(0));
				totales.set(1, totales.get(1) + parciales.get(1));
				totales.set(2, totales.get(2) + parciales.get(2));
				totales.set(3, totales.get(3) + parciales.get(3));
				totales.set(4, totales.get(4) + parciales.get(4));
			}
		}
		datos.setMasDe5((totales.get(0) / totales.get(4)) * 100);
		datos.setMasDe15((totales.get(1) / totales.get(4)) * 100);
		datos.setMasDe19((totales.get(2) / totales.get(4)) * 100);
		datos.setMasDe25((totales.get(3) / totales.get(4)) * 100);
		return datos;
	}
	
	
	public Escolaridad calcularEscolaridadPorRegiones(List<Region> listaRegiones) {
		List<Double> parciales;
		Escolaridad datos = new Escolaridad();
		double cincoOmas = 0;
		double quinceOmas = 0;
		double diecinueveOmas = 0;
		double veinticincoOmas = 0;
		double total = 0;
		for(int i = 0; i < listaRegiones.size(); i++) {
			for(int j = 0; j < listaRegiones.get(i).getListaProvincias().size(); j++) {
				for(int k = 0; k < listaRegiones.get(i).getListaProvincias().get(j).getListaComunas().size(); k++) {
					parciales = this.registrosPorComuna(listaRegiones.get(i).getListaProvincias().get(j).getListaComunas().get(k).getNombre());
					cincoOmas = cincoOmas + parciales.get(0);
					quinceOmas = quinceOmas + parciales.get(1);
					diecinueveOmas = diecinueveOmas + parciales.get(2);
					veinticincoOmas = veinticincoOmas + parciales.get(3);
					total = total + parciales.get(4);
				}
			}
		}
		datos.setMasDe5((cincoOmas / total) * 100);
		datos.setMasDe15((quinceOmas / total) * 100);
		datos.setMasDe19((diecinueveOmas / total) * 100);
		datos.setMasDe25((veinticincoOmas / total) * 100);
		return datos;
	}
}
