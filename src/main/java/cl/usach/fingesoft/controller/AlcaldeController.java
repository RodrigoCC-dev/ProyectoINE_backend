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

import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.service.ServiceAlcalde;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class AlcaldeController {

	@Autowired
	ServiceAlcalde serviceAlcalde;
	
	// Test lectura de archivos //
	@PostMapping("/test/datos_comuna")
	public Comuna getDatos(@RequestBody Map<String,String> body) {
		String nombre = body.get("comuna");
		return serviceAlcalde.getComunaByNombre(nombre);
	}
	
	@PostMapping("/test/codigo_comuna")
	public Comuna getComunaByCodigo(@RequestBody Map<String,String> body) {
		int codigo = Integer.parseInt(body.get("codigo"));
		return serviceAlcalde.getComunaByCodigo(codigo);
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
}

