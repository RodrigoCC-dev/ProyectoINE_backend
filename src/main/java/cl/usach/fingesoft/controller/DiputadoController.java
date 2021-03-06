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
import cl.usach.fingesoft.data.PaisProcedencia;
import cl.usach.fingesoft.data.PiramidePoblacional;
import cl.usach.fingesoft.data.PuebloOriginario;
import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Distrito;
import cl.usach.fingesoft.service.ServiceDiputado;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class DiputadoController {

	@Autowired
	ServiceDiputado serviceDiputado;
	
	
	@PostMapping("/datos/distrito")
	public Distrito getDatosDistrito(@RequestBody Map<String,String> body) {
		String numero = body.get("Distrito");
		return serviceDiputado.getDistrito(Integer.parseInt(numero));
	}
	
	@GetMapping("/listar/distritos")
	public List<Distrito> getDistritos(){
		return serviceDiputado.getDistritos();
	}
	
	@PostMapping("/tipologia/distrito")
	public TipologiaHogar obtenerTipologia(@RequestBody Map<String,String> body) {
		String numero = body.get("Distrito");
		return serviceDiputado.obtenerTipologia(Integer.parseInt(numero));
	}
	
	@PostMapping("/area/distrito")
	public Area obtenerAreas(@RequestBody Map<String,String> body) {
		String numero = body.get("Distrito");
		return serviceDiputado.obtenerAreas(Integer.parseInt(numero));
	}
	
	@PostMapping("/pueblos/distrito")
	public PuebloOriginario obtenerPueblos(@RequestBody Map<String,String> body) {
		String numero = body.get("Distrito");
		return serviceDiputado.obtenerPueblos(Integer.parseInt(numero));
	}
	
	@PostMapping("/grupos/distrito")
	public GrupoEtario obtenerGrupos(@RequestBody Map<String,String> body) {
		String numero = body.get("Distrito");
		return serviceDiputado.obtenerGrupos(Integer.parseInt(numero));
	}
	
	@PostMapping("/paises/distrito")
	public PaisProcedencia obtenerPaises(@RequestBody Map<String,String> body) {
		String numero = body.get("Distrito");
		return serviceDiputado.obtenerPaises(Integer.parseInt(numero));
	}
	
	@PostMapping("/escolaridad/distrito")
	public Escolaridad obtenerEscolaridad(@RequestBody Map<String,String> body) {
		String numero = body.get("Distrito");
		return serviceDiputado.obtenerEscolaridad(Integer.parseInt(numero));
	}
	
	@PostMapping("/piramide/distrito")
	public PiramidePoblacional obtenerPiramide(@RequestBody Map<String,String> body) {
		String numero = body.get("Distrito");
		return serviceDiputado.obtenerPiramide(Integer.parseInt(numero));
	}
}
