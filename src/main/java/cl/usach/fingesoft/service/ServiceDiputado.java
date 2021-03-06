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
import cl.usach.fingesoft.model.Distrito;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.repository.RepositoryDistrito;
import cl.usach.fingesoft.repository.RepositoryHogar;

@Service
public class ServiceDiputado {

	@Autowired
	private RepositoryHogar repoHogar;
	
	@Autowired
	private RepositoryDistrito repoDistrito;
	
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
	
	
	public Distrito getDistrito(int numero) {
		return repoDistrito.findDistrito(numero);
	}
	
	public List<Distrito> getDistritos(){
		return repoDistrito.findAll();
	}
	
	public TipologiaHogar obtenerTipologia(int distrito) {
		List<Hogar> hogares = repoHogar.findByDistrito(distrito);
		return tipoHogar.calcularTipologia(hogares);
	}
	
	public Area obtenerAreas(int distrito) {
		Distrito nuevoDist = repoDistrito.findDistrito(distrito);
		return area.calcularAreaPorComunas(nuevoDist.getListaComunas());
	}
	
	public PuebloOriginario obtenerPueblos(int distrito) {
		Distrito nuevoDist = repoDistrito.findDistrito(distrito);
		return pueblo.calcularPueblosPorComunas(nuevoDist.getListaComunas());
	}
	
	public GrupoEtario obtenerGrupos(int distrito) {
		Distrito nuevoDist = repoDistrito.findDistrito(distrito);
		return grupo.calcularGruposPorComunas(nuevoDist.getListaComunas());
	}
	
	public PaisProcedencia obtenerPaises(int distrito) {
		Distrito nuevoDist = repoDistrito.findDistrito(distrito);
		return pais.calcularPaisPorComunas(nuevoDist.getListaComunas());
	}
	
	public Escolaridad obtenerEscolaridad(int distrito) {
		Distrito nuevoDist = repoDistrito.findDistrito(distrito);
		return escolaridad.calcuarEscolaridadPorComunas(nuevoDist.getListaComunas());
	}
	
	public PiramidePoblacional obtenerPiramide(int distrito) {
		Distrito nuevoDist = repoDistrito.findDistrito(distrito);
		return piramide.calcularPiramidePorComunas(nuevoDist.getListaComunas());
	}
}
