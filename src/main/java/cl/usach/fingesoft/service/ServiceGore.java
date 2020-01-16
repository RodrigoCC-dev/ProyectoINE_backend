package cl.usach.fingesoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.fingesoft.data.Area;
import cl.usach.fingesoft.data.Escolaridad;
import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.model.Region;
import cl.usach.fingesoft.repository.RepositoryHogar;
import cl.usach.fingesoft.repository.RepositoryProvincia;
import cl.usach.fingesoft.repository.RepositoryRegion;

@Service
public class ServiceGore {
	
	@Autowired
	private RepositoryRegion repoRegion;
	
	@Autowired
	private RepositoryProvincia repoProvincia;
	
	@Autowired
	private RepositoryHogar repoHogar;
	
	@Autowired
	private TipologiaHogar tipoHogar;
	
	@Autowired
	private Area area;
	
	@Autowired
	private Escolaridad escolaridad;
	
	
	public Provincia getProvinciaByNombre(String nombre) {
		Provincia nueva = repoProvincia.findDatos(nombre);
		nueva = repoProvincia.findComunas(nueva);
		return nueva;
	}

	public Region getRegionByNombre(String nombre) {
		Region nueva = repoRegion.findDatos(nombre);
		nueva = repoRegion.findProvincias(nueva);
		return nueva;
	}
	
	public TipologiaHogar obtenerTipologia(String region) {
		List<Hogar> hogares = repoHogar.findByRegion(region);
		return tipoHogar.calcularTipologia(hogares);
	}
	
	public TipologiaHogar obtenerTipologiaXprovincia(String provincia) {
		List<Hogar> hogares = repoHogar.findByProvincia(provincia);
		return tipoHogar.calcularTipologia(hogares);
	}
	
	public Area obtenerAreas(String region) {
		Region nuevaReg = repoRegion.findDatos(region);
		nuevaReg = repoRegion.findProvincias(nuevaReg);
		return area.calcularAreaPorProvincias(nuevaReg.getListaProvincias());
	}
	
	public Area obtenerAreasXprovincia(String provincia) {
		Provincia nuevaProv = repoProvincia.findDatos(provincia);
		nuevaProv = repoProvincia.findComunas(nuevaProv);
		return area.calcularAreaPorComunas(nuevaProv.getListaComunas());
	}
	
	public Escolaridad obtenerEscolaridad(String region) {
		Region nuevaReg = repoRegion.findDatos(region);
		nuevaReg = repoRegion.findProvincias(nuevaReg);
		return escolaridad.calcularEscolaridadPorProvincias(nuevaReg.getListaProvincias());
	}
	
	public Escolaridad obtenerEscolaridadXsector(String provincia) {
		Provincia nuevaProv = repoProvincia.findDatos(provincia);
		nuevaProv = repoProvincia.findComunas(nuevaProv);
		return escolaridad.calcuarEscolaridadPorComunas(nuevaProv.getListaComunas());
	}
	
}
