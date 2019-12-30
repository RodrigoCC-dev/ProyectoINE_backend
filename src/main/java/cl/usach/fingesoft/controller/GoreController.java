package cl.usach.fingesoft.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.service.ServiceGore;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class GoreController {

	@Autowired
	ServiceGore serviceGore;
	
	//Test lectura de archivos//
	@PostMapping("/test/datos_provincia")
	public Provincia getDatos(@RequestBody Map<String,String> body) {
		String nombre = body.get("Provincia");
		return serviceGore.getProvinciaByNombre(nombre);
	}
}
