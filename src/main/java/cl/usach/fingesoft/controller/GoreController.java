package cl.usach.fingesoft.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.fingesoft.data.Area;
import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.model.Region;
import cl.usach.fingesoft.service.ServiceGore;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class GoreController {

	@Autowired
	ServiceGore serviceGore;
	
	
	@PostMapping("/datos_provincia")
	public Provincia getDatosProvincia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Provincia");
		return serviceGore.getProvinciaByNombre(nombre);
	}
	
	@PostMapping("/datos_region")
	public Region getDatosRegion(@RequestBody Map<String,String> body) {
		String nombre = body.get("Region");
		return serviceGore.getRegionByNombre(nombre);
	}
	
	@PostMapping("/tipologia_region")
	public TipologiaHogar obtenerTipologia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Region");
		return serviceGore.obtenerTipologia(nombre);
	}
	
	@PostMapping("/tipologia_provincia")
	public TipologiaHogar obtenerTipologiaXprovincia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Provincia");
		return serviceGore.obtenerTipologiaXprovincia(nombre);
	}
	
	@PostMapping("/area_region")
	public Area obtenerAreas(@RequestBody Map<String,String> body) {
		String nombre = body.get("Region");
		return serviceGore.obtenerAreas(nombre);
	}
	
	@PostMapping("/area_provincia")
	public Area obtenerAreasXprovincia(@RequestBody Map<String,String> body) {
		String nombre = body.get("Provincia");
		return serviceGore.obtenerAreasXprovincia(nombre);
	}
}
