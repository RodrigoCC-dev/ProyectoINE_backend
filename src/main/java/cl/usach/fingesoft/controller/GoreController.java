package cl.usach.fingesoft.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.fingesoft.data.Area;
import cl.usach.fingesoft.data.Escolaridad;
import cl.usach.fingesoft.data.GrupoEtario;
import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.model.Region;
import cl.usach.fingesoft.service.ServiceGore;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class GoreController {

	@Autowired
	ServiceGore serviceGore;
	
	
	@PostMapping("/datos/provincia")
	public Provincia getDatosProvincia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Provincia");
		return serviceGore.getProvinciaByNombre(nombre);
	}
	
	@PostMapping("/datos/region")
	public Region getDatosRegion(@RequestBody Map<String,String> body) {
		String nombre = body.get("Region");
		return serviceGore.getRegionByNombre(nombre);
	}
	
	@PostMapping("/tipologia/region")
	public TipologiaHogar obtenerTipologia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Region");
		return serviceGore.obtenerTipologia(nombre);
	}
	
	@PostMapping("/tipologia/provincia")
	public TipologiaHogar obtenerTipologiaXprovincia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Provincia");
		return serviceGore.obtenerTipologiaXprovincia(nombre);
	}
	
	@PostMapping("/area/region")
	public Area obtenerAreas(@RequestBody Map<String,String> body) {
		String nombre = body.get("Region");
		return serviceGore.obtenerAreas(nombre);
	}
	
	@PostMapping("/area/provincia")
	public Area obtenerAreasXprovincia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Provincia");
		return serviceGore.obtenerAreasXprovincia(nombre);
	}
	
	@PostMapping("/grupos/region")
	public GrupoEtario obtenerGrupos(@RequestBody Map<String,String> body) {
		String nombre = body.get("Region");
		return serviceGore.obtenerGrupos(nombre);
	}
	
	@PostMapping("/grupos/provincia")
	public GrupoEtario obtenerGruposXprovincia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Provincia");
		return serviceGore.obtenerGruposXprovincia(nombre);
	}
	
	@PostMapping("/escolaridad/region")
	public Escolaridad obtenerEscolaridad(@RequestBody Map<String,String> body) {
		String nombre = body.get("Region");
		return serviceGore.obtenerEscolaridad(nombre);
	}
	
	@PostMapping("/escolaridad/provincia")
	public Escolaridad obtenerEscolaridadXprovincia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Provincia");
		return serviceGore.obtenerEscolaridadXprovincia(nombre);
	}
}
