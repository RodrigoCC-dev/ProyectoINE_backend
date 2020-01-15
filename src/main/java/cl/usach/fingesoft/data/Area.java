package cl.usach.fingesoft.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Circunscripcion;
import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Distrito;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.model.Persona;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.model.Region;
import cl.usach.fingesoft.repository.RepositoryCircunscripcion;
import cl.usach.fingesoft.repository.RepositoryDistrito;
import cl.usach.fingesoft.repository.RepositoryPersona;
import cl.usach.fingesoft.repository.RepositoryProvincia;
import cl.usach.fingesoft.repository.RepositoryRegion;

@Component
public class Area {

	private double rural;
	private double urbana;
	
	@Autowired
	private RepositoryProvincia repoProvincia;
	
	@Autowired
	private RepositoryRegion repoRegion;
	
	@Autowired
	private RepositoryDistrito repoDistrito;
	
	@Autowired
	private RepositoryCircunscripcion repoCircunscripcion;
	
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
	
	
	public Area calcularArea(List<Persona> listaPersonas) {
		double total = 0;
		double urbano = 0;
		double rural = 0;
		Area distribucion = new Area();
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getArea() == 1) {
				urbano++;
				total++;
			}
			else if(listaPersonas.get(i).getArea() == 2) {
				rural++;
				total++;
			}
		}
		distribucion.setUrbana((urbano / total) * 100);
		distribucion.setRural((rural / total) * 100);
		return distribucion;
	}
	
	
	public List<Double> registrosPorComuna(String comuna){
		List<Double> valores = new ArrayList<>();
		double total = 0;
		double urbano = 0;
		double rural = 0;
		List<Persona> listaPersonas = repoPersona.findByComuna(comuna);
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
	
	
	public List<Double> registrosPorLocalidad(String comuna, String localidad){
		List<Double> valores = new ArrayList<>();
		double total = 0;
		double urbano = 0;
		double rural = 0;
		List<Persona> listaPersonas = repoPersona.findByLocalidad(comuna, localidad);
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getArea() == 1) {
				urbano++;
				total++;
			}
			else if(listaPersonas.get(i).getArea() == 2) {
				rural++;
				total++;
			}
		}
		valores.add(urbano);
		valores.add(rural);
		valores.add(total);
		return valores;
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
		List<Double> totales = new ArrayList<>();
		List<Double> parciales;
		Area distribucion = new Area();
		double total = 0;
		double urbano = 0;
		double rural = 0;
		totales.add(urbano);
		totales.add(rural);
		totales.add(total);
		for(int i = 0; i < comunas.size(); i++) {
			parciales = this.registrosPorComuna(comunas.get(i).getNombre());
			totales.set(0, totales.get(0) + parciales.get(0));
			totales.set(1, totales.get(1) + parciales.get(1));
			totales.set(2, totales.get(2) + parciales.get(2));
		}
		distribucion.setUrbana((totales.get(0) / totales.get(2)) * 100);
		distribucion.setRural((totales.get(1) / totales.get(2)) * 100);
		return distribucion;
	}
	
	public Area calcularAreaPorProvincias(List<Provincia> provincias) {
		List<Double> totales = new ArrayList<>();
		List<Double> parciales;
		Area distribucion = new Area();
		double total = 0;
		double urbano = 0;
		double rural = 0;
		totales.add(urbano);
		totales.add(rural);
		totales.add(total);
		for(int i = 0; i < provincias.size(); i++) {
			for(int j = 0; j < provincias.get(i).getListaComunas().size(); j++) {
				parciales = this.registrosPorComuna(provincias.get(i).getListaComunas().get(j).getNombre());
				totales.set(0, totales.get(0) + parciales.get(0));
				totales.set(1, totales.get(1) + parciales.get(1));
				totales.set(2, totales.get(2) + parciales.get(2));
			}
		}
		distribucion.setUrbana((totales.get(0) / totales.get(2)) * 100);
		distribucion.setRural((totales.get(1) / totales.get(2)) * 100);
		return distribucion;
	}
}
