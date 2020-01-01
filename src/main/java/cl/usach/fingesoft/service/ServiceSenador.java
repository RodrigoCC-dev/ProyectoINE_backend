package cl.usach.fingesoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.fingesoft.data.TipologiaHogar;
import cl.usach.fingesoft.model.Circunscripcion;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.repository.RepositoryCircunscripcion;
import cl.usach.fingesoft.repository.RepositoryHogar;
import cl.usach.fingesoft.repository.RepositoryPersona;
import cl.usach.fingesoft.repository.RepositoryVivienda;

@Service
public class ServiceSenador {

	/**
	@Autowired
	private RepositoryPersona repoPersona;
	
	@Autowired
	private RepositoryVivienda repoVivienda;
	**/
	@Autowired
	private RepositoryHogar repoHogar;
	
	@Autowired
	private RepositoryCircunscripcion repoCircunscripcion;
	
	@Autowired
	private TipologiaHogar tipoHogar;
	
	
	public Circunscripcion getCircunscripcion(int numero) {
		return repoCircunscripcion.findCircunscripcion(numero);
	}
	
	public TipologiaHogar obtenerTipologia(int numero) {
		List<Hogar> hogares = repoHogar.findByCircunscripcion(numero);
		return tipoHogar.calcularTipologia(hogares);
	}
	
	
}
