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
public class PaisProcedencia {

	private double peru;
	private double colombia;
	private double argentina;
	private double bolivia;
	private double venezuela;
	private double haiti;
	private double ecuador;
	private double otro;
	private double ignorado;
	
	@Autowired
	private RepositoryPersona repoPersona;
	
	
	public double getPeru() {
		return peru;
	}
	public void setPeru(double peru) {
		this.peru = peru;
	}
	public double getColombia() {
		return colombia;
	}
	public void setColombia(double colombia) {
		this.colombia = colombia;
	}
	public double getArgentina() {
		return argentina;
	}
	public void setArgentina(double argentina) {
		this.argentina = argentina;
	}
	public double getBolivia() {
		return bolivia;
	}
	public void setBolivia(double bolivia) {
		this.bolivia = bolivia;
	}
	public double getVenezuela() {
		return venezuela;
	}
	public void setVenezuela(double venezuela) {
		this.venezuela = venezuela;
	}
	public double getHaiti() {
		return haiti;
	}
	public void setHaiti(double haiti) {
		this.haiti = haiti;
	}
	public double getEcuador() {
		return ecuador;
	}
	public void setEcuador(double ecuador) {
		this.ecuador = ecuador;
	}
	public double getOtro() {
		return otro;
	}
	public void setOtro(double otro) {
		this.otro = otro;
	}
	public double getIgnorado() {
		return ignorado;
	}
	public void setIgnorado(double ignorado) {
		this.ignorado = ignorado;
	}
	
	
	
	public List<Double> registrosPorListaPersonas(List<Persona> listaPersonas){
		List<Double> subtotales = new ArrayList<>();
		double peru = 0;
		double colombia = 0;
		double argentina = 0;
		double bolivia = 0;
		double venezuela = 0;
		double haiti = 0;
		double ecuador = 0;
		double otro = 0;
		double ignorado = 0;
		double total = 0;
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getP12() == 3 || listaPersonas.get(i).getP12Pais() == 604) {
				peru++;
				total++;
			}
			else if(listaPersonas.get(i).getP12() == 4 || listaPersonas.get(i).getP12Pais() == 32) { 
				argentina++;
				total++;
			}
			else if(listaPersonas.get(i).getP12() == 5 || listaPersonas.get(i).getP12Pais() == 68) {
				bolivia++;
				total++;
			}
			else if(listaPersonas.get(i).getP12() == 6 || listaPersonas.get(i).getP12Pais() == 218) {
				ecuador++;
				total++;
			}
			else if(listaPersonas.get(i).getP12() == 7 || listaPersonas.get(i).getP12Pais() == 170) {
				colombia++;
				total++;
			}
			else if(listaPersonas.get(i).getP12() == 8 && listaPersonas.get(i).getP12Pais() == 862) {
				venezuela++;
				total++;
			}
			else if(listaPersonas.get(i).getP12() == 8 && listaPersonas.get(i).getP12Pais() == 332) {
				haiti++;
				total++;
			}
			else if(listaPersonas.get(i).getP12() == 8 && listaPersonas.get(i).getP12Pais() != 997 && listaPersonas.get(i).getP12Pais() != 998 && listaPersonas.get(i).getP12Pais() != 999) {
				otro++;
				total++;
			}
			else if(listaPersonas.get(i).getP12() == 8 && listaPersonas.get(i).getP12Pais() == 997) {
				ignorado++;
				total++;
			}
		}
		subtotales.add(peru);
		subtotales.add(colombia);
		subtotales.add(argentina);
		subtotales.add(bolivia);
		subtotales.add(venezuela);
		subtotales.add(haiti);
		subtotales.add(ecuador);
		subtotales.add(otro);
		subtotales.add(ignorado);
		subtotales.add(total);
		return subtotales;
	}
	
	
	public List<Double> registrosPorComuna(String comuna) {
		return this.registrosPorListaPersonas(repoPersona.findByComuna(comuna));
	}
	
	public List<Double> registrosPorLocalidad(String comuna, String localidad) {
		return this.registrosPorListaPersonas(repoPersona.findByLocalidad(comuna, localidad));
	}
	
	
	public PaisProcedencia calcularPaisPorComuna(String comuna) {
		List<Double> totales = this.registrosPorComuna(comuna);
		PaisProcedencia pais = new PaisProcedencia();
		pais.setPeru((totales.get(0) / totales.get(9)) * 100);
		pais.setColombia((totales.get(1) / totales.get(9)) * 100);
		pais.setArgentina((totales.get(2) / totales.get(9)) * 100);
		pais.setBolivia((totales.get(3) / totales.get(9)) * 100);
		pais.setVenezuela((totales.get(4) / totales.get(9)) * 100);
		pais.setHaiti((totales.get(5) / totales.get(9)) * 100);
		pais.setEcuador((totales.get(6) / totales.get(9)) * 100);
		pais.setOtro((totales.get(7) / totales.get(9)) * 100);
		pais.setIgnorado((totales.get(8) / totales.get(9)) * 100);
		return pais;
	}
	
	public PaisProcedencia calcularPaisPorLocalidad(String comuna, String localidad) {
		List<Double> totales = this.registrosPorLocalidad(comuna, localidad);
		PaisProcedencia pais = new PaisProcedencia();
		pais.setPeru((totales.get(0) / totales.get(9)) * 100);
		pais.setColombia((totales.get(1) / totales.get(9)) * 100);
		pais.setArgentina((totales.get(2) / totales.get(9)) * 100);
		pais.setBolivia((totales.get(3) / totales.get(9)) * 100);
		pais.setVenezuela((totales.get(4) / totales.get(9)) * 100);
		pais.setHaiti((totales.get(5) / totales.get(9)) * 100);
		pais.setEcuador((totales.get(6) / totales.get(9)) * 100);
		pais.setOtro((totales.get(7) / totales.get(9)) * 100);
		pais.setIgnorado((totales.get(8) / totales.get(9)) * 100);
		return pais;
	}
	
	public PaisProcedencia calcularPaisPorComunas(List<Comuna> listaComunas) {
		PaisProcedencia pais = new PaisProcedencia();
		List<Double> parciales;
		double peru = 0;
		double colombia = 0;
		double argentina = 0;
		double bolivia = 0;
		double venezuela = 0;
		double haiti = 0;
		double ecuador = 0;
		double otro = 0;
		double ignorado = 0;
		double total = 0;
		for(int i = 0; i < listaComunas.size(); i++) {
			parciales = this.registrosPorComuna(listaComunas.get(i).getNombre());
			peru = peru + parciales.get(0);
			colombia = colombia + parciales.get(1);
			argentina = argentina + parciales.get(2);
			bolivia = bolivia + parciales.get(3);
			venezuela = venezuela + parciales.get(4);
			haiti = haiti + parciales.get(5);
			ecuador = ecuador + parciales.get(6);
			otro = otro + parciales.get(7);
			ignorado = ignorado + parciales.get(8);
			total = total + parciales.get(9);
		}
		pais.setPeru((peru / total) * 100);
		pais.setColombia((colombia / total) * 100);
		pais.setArgentina((argentina / total) * 100);
		pais.setBolivia((bolivia / total) * 100);
		pais.setVenezuela((venezuela / total) * 100);
		pais.setHaiti((haiti / total) * 100);
		pais.setEcuador((ecuador / total) * 100);
		pais.setOtro((otro / total) * 100);
		pais.setIgnorado((ignorado / total) * 100);
		return pais;
	}
	
	public PaisProcedencia calcularPaisPorProvincias(List<Provincia> listaProvincias) { 
		PaisProcedencia pais = new PaisProcedencia();
		List<Double> parciales;
		double peru = 0;
		double colombia = 0;
		double argentina = 0;
		double bolivia = 0;
		double venezuela = 0;
		double haiti = 0;
		double ecuador = 0;
		double otro = 0;
		double ignorado = 0;
		double total = 0;
		for(int i = 0; i < listaProvincias.size(); i++) {
			for(int j = 0; j < listaProvincias.get(i).getListaComunas().size(); j++) {
				parciales = this.registrosPorComuna(listaProvincias.get(i).getListaComunas().get(j).getNombre());
				peru = peru + parciales.get(0);
				colombia = colombia + parciales.get(1);
				argentina = argentina + parciales.get(2);
				bolivia = bolivia + parciales.get(3);
				venezuela = venezuela + parciales.get(4);
				haiti = haiti + parciales.get(5);
				ecuador = ecuador + parciales.get(6);
				otro = otro + parciales.get(7);
				ignorado = ignorado + parciales.get(8);
				total = total + parciales.get(9);
			}
		}
		pais.setPeru((peru / total) * 100);
		pais.setColombia((colombia / total) * 100);
		pais.setArgentina((argentina / total) * 100);
		pais.setBolivia((bolivia / total) * 100);
		pais.setVenezuela((venezuela / total) * 100);
		pais.setHaiti((haiti / total) * 100);
		pais.setEcuador((ecuador / total) * 100);
		pais.setOtro((otro / total) * 100);
		pais.setIgnorado((ignorado / total) * 100);
		return pais;
	}
}
