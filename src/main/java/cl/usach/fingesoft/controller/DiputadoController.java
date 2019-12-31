package cl.usach.fingesoft.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.fingesoft.model.Distrito;
import cl.usach.fingesoft.service.ServiceDiputado;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class DiputadoController {

	@Autowired
	ServiceDiputado serviceDiputado;
	
	
	@PostMapping("/test/distrito")
	public Distrito getDatosDistrito(@RequestBody Map<String,String> body) {
		String numero = body.get("Distrito");
		return serviceDiputado.getDistrito(Integer.parseInt(numero));
	}
}
