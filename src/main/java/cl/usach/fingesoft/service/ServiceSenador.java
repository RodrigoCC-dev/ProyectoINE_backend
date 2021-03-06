package cl.usach.fingesoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.fingesoft.data.Area;
import cl.usach.fingesoft.data.Escolaridad;
import cl.usach.fingesoft.data.GrupoEtario;
import cl.usach.fingesoft.data.PaisProcedencia;
import cl.usach.fingesoft.data.PiramidePoblacional;
import cl.usach.fingesoft.data.PuebloOriginario;
import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Circunscripcion;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.repository.RepositoryCircunscripcion;
import cl.usach.fingesoft.repository.RepositoryHogar;

@Service
public class ServiceSenador {

	@Autowired
	private RepositoryHogar repoHogar;
	
	@Autowired
	private RepositoryCircunscripcion repoCircunscripcion;
	
	@Autowired
	private TipologiaHogar tipoHogar;
	
	@Autowired
	private Area area;
	
	@Autowired
	private PuebloOriginario pueblo;
	
	@Autowired
	private GrupoEtario grupo;
	
	@Autowired
	private PaisProcedencia pais;
	
	@Autowired
	private Escolaridad escolaridad;
	
	@Autowired
	private PiramidePoblacional piramide;
	
	
	public Circunscripcion getCircunscripcion(int numero) {
		return repoCircunscripcion.findCircunscripcion(numero);
	}
	
	public List<Circunscripcion> getCircunscripciones(){
		return repoCircunscripcion.findAll();
	}
	
	public TipologiaHogar obtenerTipologia(int numero) {
		List<Hogar> hogares = repoHogar.findByCircunscripcion(numero);
		return tipoHogar.calcularTipologia(hogares);
	}
	
	public Area obtenerAreas(int numero) {
		Circunscripcion nuevaCircuns = repoCircunscripcion.findCircunscripcion(numero);
		return area.calcularAreaPorComunas(nuevaCircuns.getListaComunas());
	}
	
	public PuebloOriginario obtenerPueblos(int numero) {
		Circunscripcion nuevaCircuns = repoCircunscripcion.findCircunscripcion(numero);
		return pueblo.calcularPueblosPorComunas(nuevaCircuns.getListaComunas());
	}
	
	public GrupoEtario obtenerGrupos(int numero) {
		Circunscripcion nuevaCircuns = repoCircunscripcion.findCircunscripcion(numero);
		return grupo.calcularGruposPorComunas(nuevaCircuns.getListaComunas());
	}
	
	public PaisProcedencia obtenerPaises(int numero) {
		Circunscripcion nuevaCircuns = repoCircunscripcion.findCircunscripcion(numero);
		return pais.calcularPaisPorComunas(nuevaCircuns.getListaComunas());
	}
	
	public Escolaridad obtenerEscolaridad(int numero) {
		Circunscripcion nuevaCircuns = repoCircunscripcion.findCircunscripcion(numero);
		return escolaridad.calcuarEscolaridadPorComunas(nuevaCircuns.getListaComunas());
	}
	
	public PiramidePoblacional obtenerPiramide(int numero) {
		Circunscripcion nuevaCircuns = repoCircunscripcion.findCircunscripcion(numero);
		return piramide.calcularPiramidePorComunas(nuevaCircuns.getListaComunas());
	}
}
