package cl.usach.fingesoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.fingesoft.data.Area;
import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.model.Vivienda;
import cl.usach.fingesoft.repository.RepositoryComuna;
import cl.usach.fingesoft.repository.RepositoryHogar;
import cl.usach.fingesoft.repository.RepositoryPersona;
import cl.usach.fingesoft.repository.RepositoryVivienda;

@Service
public class ServiceAlcalde {

	/**@Autowired
	private RepositoryPersona repoPersona;
	**/
	@Autowired
	private RepositoryVivienda repoVivienda;
	
	@Autowired
	private RepositoryHogar repoHogar;
	
	@Autowired
	private RepositoryComuna repoComuna;
	
	@Autowired
	private TipologiaHogar tipoHogar;
	
	@Autowired
	private Area area;
	
	
	public Comuna getComunaByNombre(String nombre) {
		Comuna nueva = repoComuna.findDatos(nombre);
		nueva = repoComuna.findLocalidades(nueva);
		return nueva;
	}
	
	public Comuna getComunaByCodigo(int codigo) {
		Comuna nueva = repoComuna.findComunaByCodigo(codigo);
		nueva = repoComuna.findLocalidades(nueva);
		return nueva;
	}
	
	public TipologiaHogar obtenerTipología(String comuna) {
		List<Hogar> hogares = repoHogar.findByComuna(comuna);
		return tipoHogar.calcularTipologia(hogares);
	}
	
	public TipologiaHogar obtenerTipologiaXsector(String comuna, String localidad) {
		List<Hogar> hogares = repoHogar.findByLocalidad(comuna, localidad);
		return tipoHogar.calcularTipologia(hogares);
	}
	
	
	//Test//
	//Para prueba de métodos Repository. Eliminar posteriormente
	
	public List<Hogar> getHogaresByComuna(String nombre){
		return repoHogar.findByComuna(nombre);
	}
	
	public List<Hogar> getHogaresByProvincia(String nombre){
		return repoHogar.findByProvincia(nombre);
	}
	
	public List<Hogar> getHogaresByLocalidad(String comuna, String localidad){
		return repoHogar.findByLocalidad(comuna, localidad);
	}
	
	public TipologiaHogar getTipologias() {
		return tipoHogar.calcularTipologia(repoHogar.findAll());
	}
	
	
	public List<Vivienda> getViviendasByComuna(String nombre){
		return repoVivienda.findByComuna(nombre);
	}
	
	public List<Vivienda> getViviendasByProvincia(String nombre){
		return repoVivienda.findByProvincia(nombre);
	}
	
	public List<Vivienda> getViviendasByLocalidad(String comuna, String localidad){
		return repoVivienda.findByLocalidad(comuna, localidad);
	}
	
	public List<Vivienda> getViviendaByRegion(String region){
		return repoVivienda.findByRegion(region);
	}
		
	public Area getAreas() {
		return area.calcularArea(repoHogar.findAll());
	}
}
