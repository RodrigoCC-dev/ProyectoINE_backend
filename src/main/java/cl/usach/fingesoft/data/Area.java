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
public class Area {

	private double rural;
	private double urbana;
	
	@Autowired
	private RepositoryPersona repoPersona;
	
	
	public double getRural() {
		return rural;
	}
	public void setRural(double rural) {
		this.rural = rural;
	}
	public double getUrbana() {
		return urbana;
	}
	public void setUrbana(double urbana) {
		this.urbana = urbana;
	}
	
	
	public List<Double> registrosPorListaPersonas(List<Persona> listaPersonas){
		List<Double> valores = new ArrayList<>();
		double total = 0;
		double urbano = 0;
		double rural = 0;
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getArea() == 1) {
				urbano++;
				total++;
			}
			else if (listaPersonas.get(i).getArea() == 2) {
				rural++;
				total++;
			}
		}
		valores.add(urbano);
		valores.add(rural);
		valores.add(total);
		return valores;
	}
	
	public List<Double> registrosPorComuna(String comuna){
		return this.registrosPorListaPersonas(repoPersona.findByComuna(comuna));
	}
	
	
	public List<Double> registrosPorLocalidad(String comuna, String localidad){
		return this.registrosPorListaPersonas(repoPersona.findByLocalidad(comuna, localidad));
	}
	
	
	public Area calcularAreaPorLocalidad(String comuna, String localidad) {
		List<Double> totales = this.registrosPorLocalidad(comuna, localidad);
		Area distribucion = new Area();
		distribucion.setUrbana((totales.get(0) / totales.get(2)) * 100);
		distribucion.setRural((totales.get(1) / totales.get(2)) * 100);
		return distribucion;
	}
	
	
	public Area calcularAreaPorComuna(String comuna) {
		List<Double> totales = this.registrosPorComuna(comuna);
		Area distribucion = new Area();
		distribucion.setUrbana((totales.get(0) / totales.get(2)) * 100);
		distribucion.setRural((totales.get(1) / totales.get(2)) * 100);
		return distribucion;
	}
	
	
	public Area calcularAreaPorComunas(List<Comuna> comunas) {
		Area distribucion = new Area();
		List<Double> parciales;
		double total = 0;
		double urbano = 0;
		double rural = 0;
		for(int i = 0; i < comunas.size(); i++) {
			parciales = this.registrosPorComuna(comunas.get(i).getNombre());
			urbano = urbano + parciales.get(0);
			rural = rural + parciales.get(1);
			total = total + parciales.get(2);
		}
		distribucion.setUrbana((urbano / total) * 100);
		distribucion.setRural((rural / total) * 100);
		return distribucion;
	}
	
	public Area calcularAreaPorProvincias(List<Provincia> provincias) {
		Area distribucion = new Area();
		List<Double> parciales;
		double total = 0;
		double urbano = 0;
		double rural = 0;
		for(int i = 0; i < provincias.size(); i++) {
			for(int j = 0; j < provincias.get(i).getListaComunas().size(); j++) {
				parciales = this.registrosPorComuna(provincias.get(i).getListaComunas().get(j).getNombre());
				urbano = urbano + parciales.get(0);
				rural = rural + parciales.get(1);
				total = total + parciales.get(2);
			}
		}
		distribucion.setUrbana((urbano / total) * 100);
		distribucion.setRural((rural / total) * 100);
		return distribucion;
	}
	
	public Area calcularAreaPorRegiones(List<Region> regiones) {
		Area distribucion = new Area();
		List<Double> parciales;
		double total = 0;
		double urbano = 0;
		double rural = 0;
		for(int i = 0; i < regiones.size(); i++) {
			for(int j = 0; j < regiones.get(i).getListaProvincias().size(); j++) {
				for(int k = 0; k < regiones.get(i).getListaProvincias().get(j).getListaComunas().size(); k++) {
					parciales = this.registrosPorComuna(regiones.get(i).getListaProvincias().get(j).getListaComunas().get(k).getNombre());
					urbano = urbano + parciales.get(0);
					rural = rural + parciales.get(1);
					total = total + parciales.get(2);
				}
			}
		}
		distribucion.setUrbana((urbano / total) * 100);
		distribucion.setRural((rural / total) * 100);
		return distribucion;
	}
}
