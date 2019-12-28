package cl.usach.fingesoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.fingesoft.repository.RepositoryComuna;
import cl.usach.fingesoft.repository.RepositoryHogar;
import cl.usach.fingesoft.repository.RepositoryPersona;
import cl.usach.fingesoft.repository.RepositoryVivienda;

@Service
public class ServiceAlcalde {

	@Autowired
	private RepositoryPersona repoPersona;
	
	@Autowired
	private RepositoryVivienda repoVivienda;
	
	@Autowired
	private RepositoryHogar repoHogar;
	
	@Autowired
	private RepositoryComuna repoComuna;
}
