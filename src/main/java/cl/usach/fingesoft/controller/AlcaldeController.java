package cl.usach.fingesoft.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.fingesoft.data.Area;
import cl.usach.fingesoft.data.Escolaridad;
import cl.usach.fingesoft.data.GrupoEtario;
import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.model.Vivienda;
import cl.usach.fingesoft.service.ServiceAlcalde;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class AlcaldeController {

	@Autowired
	ServiceAlcalde serviceAlcalde;
	

	@PostMapping("/datos/comuna")
	public Comuna getDatos(@RequestBody Map<String,String> body) {
		String nombre = body.get("Comuna");
		return serviceAlcalde.getComunaByNombre(nombre);
	}
	
	@PostMapping("/codigo/comuna")
	public Comuna getComunaByCodigo(@RequestBody Map<String,String> body) {
		int codigo = Integer.parseInt(body.get("Codigo"));
		return serviceAlcalde.getComunaByCodigo(codigo);
	}
	
	@PostMapping("/tipologia/comuna")
	public TipologiaHogar obtenerTipologia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Comuna");
		return serviceAlcalde.obtenerTipología(nombre);
	}
	
	@PostMapping("/tipologia/localidad")
	public TipologiaHogar obtenerTipologiaXsector(@RequestBody Map<String,String> body) {
		String comuna = body.get("Comuna");
		String localidad = body.get("Localidad");
		return serviceAlcalde.obtenerTipologiaXsector(comuna, localidad);
	}
	
	@PostMapping("/area/comuna")
	public Area obtenerAreas(@RequestBody Map<String,String> body) {
		String comuna = body.get("Comuna");
		return serviceAlcalde.obtenerAreas(comuna);
	}
	
	@PostMapping("/area/localidad")
	public Area obtenerAreasXsector(@RequestBody Map<String,String> body) {
		String comuna = body.get("Comuna");
		String localidad = body.get("Localidad");
		return serviceAlcalde.obtenerAreasXsector(comuna, localidad);
	}
	
	@PostMapping("/grupos/comuna")
	public GrupoEtario obtenerGrupos(@RequestBody Map<String,String> body) {
		String comuna = body.get("Comuna");
		return serviceAlcalde.obtenerGrupos(comuna);
	}
	
	@PostMapping("/grupos/localidad")
	public GrupoEtario obtenerGruposXsector(@RequestBody Map<String,String> body) {
		String comuna = body.get("Comuna");
		String localidad = body.get("Localidad");
		return serviceAlcalde.obtenerGruposXsector(comuna, localidad);
	}
	
	@PostMapping("/escolaridad/comuna")
	public Escolaridad obtenerEscolaridad(@RequestBody Map<String,String> body) {
		String comuna = body.get("Comuna");
		return serviceAlcalde.obtenerEscolaridad(comuna);
	}
	
	@PostMapping("/escolaridad/localidad")
	public Escolaridad obtenerEscolaridadXsector(@RequestBody Map<String,String> body) {
		String comuna = body.get("Comuna");
		String localidad = body.get("Localidad");
		return serviceAlcalde.obtenerEscolaridadXsector(comuna, localidad);
	}
	
	//Test//
	@PostMapping("/test/hogares_comuna")
	public List<Hogar> getHogaresByComuna(@RequestBody Map<String,String> body){
		String nombre = body.get("Comuna");
		return serviceAlcalde.getHogaresByComuna(nombre);
	}
	
	@PostMapping("/test/hogares_provincia")
	public List<Hogar> getHogaresByProvincia(@RequestBody Map<String,String> body){
		String nombre = body.get("Provincia");
		return serviceAlcalde.getHogaresByProvincia(nombre);
	}
	
	@PostMapping("/test/hogares_localidad")
	public List<Hogar> getHogaresByLocalidad(@RequestBody Map<String,String> body){
		String comuna = body.get("Comuna");
		String localidad = body.get("Localidad");
		return serviceAlcalde.getHogaresByLocalidad(comuna, localidad);
	}
	
	@GetMapping("/test/tipologiasHogares")
	public TipologiaHogar getTipologias() {
		return serviceAlcalde.getTipologias();
	}
	
	
	@PostMapping("/test/viviendas_comuna")
	public List<Vivienda> getViviendasByComuna(@RequestBody Map<String,String> body){
		String nombre = body.get("Comuna");
		return serviceAlcalde.getViviendasByComuna(nombre);
	}
	
	@PostMapping("/test/viviendas_provincia")
	public List<Vivienda> getViviendasByProvincia(@RequestBody Map<String,String> body){
		String nombre = body.get("Provincia");
		return serviceAlcalde.getViviendasByProvincia(nombre);
	}
	
	@PostMapping("/test/viviendas_localidad")
	public List<Vivienda> getViviendasByLocalidad(@RequestBody Map<String,String> body){
		String comuna = body.get("Comuna");
		String localidad = body.get("Localidad");
		return serviceAlcalde.getViviendasByLocalidad(comuna, localidad);
	}
	
	@PostMapping("/test/viviendas_region")
	public List<Vivienda> getViviendasByRegion(@RequestBody Map<String,String> body){
		String region = body.get("Region");
		return serviceAlcalde.getViviendaByRegion(region);
	}
	
	@PostMapping("/test/areas_comuna")
	public Area getAreasPorComuna(@RequestBody Map<String,String> body) {
		String comuna = body.get("Comuna");
		return serviceAlcalde.getAreasPorComuna(comuna);
	}
	
	@PostMapping("/test/areas_localidad")
	public Area getAreaPorLocalidad(@RequestBody Map<String,String> body) {
		String comuna = body.get("Comuna");
		String localidad = body.get("Localidad");
		return serviceAlcalde.getAreasPorLocalidad(comuna, localidad);
	}
}

