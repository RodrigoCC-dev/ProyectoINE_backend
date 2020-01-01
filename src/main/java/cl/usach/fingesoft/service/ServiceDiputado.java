package cl.usach.fingesoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Distrito;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.repository.RepositoryDistrito;
import cl.usach.fingesoft.repository.RepositoryHogar;
import cl.usach.fingesoft.repository.RepositoryPersona;
import cl.usach.fingesoft.repository.RepositoryVivienda;

@Service
public class ServiceDiputado {

	/**
	@Autowired
	private RepositoryPersona repoPersona;
	
	@Autowired
	private RepositoryVivienda repoVivienda;
	**/
	@Autowired
	private RepositoryHogar repoHogar;
	
	@Autowired
	private RepositoryDistrito repoDistrito;
	
	@Autowired
	private TipologiaHogar tipoHogar;
	
	
	public Distrito getDistrito(int numero) {
		return repoDistrito.findDistrito(numero);
	}
	
	public TipologiaHogar obtenerTipologia(int distrito) {
		List<Hogar> hogares = repoHogar.findByDistrito(distrito);
		return tipoHogar.calcularTipologia(hogares);
	}
}
