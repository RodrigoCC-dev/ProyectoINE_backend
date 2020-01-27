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
import cl.usach.fingesoft.data.PuebloOriginario;
import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Circunscripcion;
import cl.usach.fingesoft.service.ServiceSenador;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class SenadorController {
	
	@Autowired
	ServiceSenador serviceSenador;
	
	
	@PostMapping("/datos/circunscripcion")
	public Circunscripcion getDatosCircunscricpion(@RequestBody Map<String,String> body) {
		String numero = body.get("Circunscripcion");
		return serviceSenador.getCircunscripcion(Integer.parseInt(numero));
	}
	
	@PostMapping("/tipologia/circunscripcion")
	public TipologiaHogar obtenerTipologia(@RequestBody Map<String,String> body) {
		String numero = body.get("Circunscripcion");
		return serviceSenador.obtenerTipologia(Integer.parseInt(numero));
	}
	
	@PostMapping("/area/circunscripcion")
	public Area obtenerAreas(@RequestBody Map<String,String> body) {
		String numero = body.get("Circunscripcion");
		return serviceSenador.obtenerAreas(Integer.parseInt(numero));
	}
	
	@PostMapping("/pueblos/circunscripcion")
	public PuebloOriginario obtenerPueblos(@RequestBody Map<String,String> body) {
		String numero = body.get("Circunscripcion");
		return serviceSenador.obtenerPueblos(Integer.parseInt(numero));
	}
	
	@PostMapping("/grupos/circunscripcion")
	public GrupoEtario obtenerGrupos(@RequestBody Map<String,String> body) {
		String numero = body.get("Circunscripcion");
		return serviceSenador.obtenerGrupos(Integer.parseInt(numero));
	}
	
	@PostMapping("/escolaridad/circunscripcion")
	public Escolaridad obtenerEscolaridad(@RequestBody Map<String,String> body) {
		String numero = body.get("Circunscripcion");
		return serviceSenador.obtenerEscolaridad(Integer.parseInt(numero));
	}
}
