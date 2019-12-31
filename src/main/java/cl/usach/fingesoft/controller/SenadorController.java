package cl.usach.fingesoft.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.fingesoft.model.Circunscripcion;
import cl.usach.fingesoft.service.ServiceSenador;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class SenadorController {
	
	@Autowired
	ServiceSenador serviceSenador;
	
	
	@PostMapping("/test/circunscripcion")
	public Circunscripcion getDatosCircunscricpion(@RequestBody Map<String,String> body) {
		String numero = body.get("Circunscripcion");
		return serviceSenador.getCircunscripcion(Integer.parseInt(numero));
	}
}
