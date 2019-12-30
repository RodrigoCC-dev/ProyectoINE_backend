package cl.usach.fingesoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.repository.RepositoryHogar;
import cl.usach.fingesoft.repository.RepositoryPersona;
import cl.usach.fingesoft.repository.RepositoryProvincia;
import cl.usach.fingesoft.repository.RepositoryRegion;
import cl.usach.fingesoft.repository.RepositoryVivienda;

@Service
public class ServiceGore {
	
	/**
	@Autowired
	private RepositoryPersona repoPersona;
	
	@Autowired
	private RepositoryVivienda repoVivienda;
	
	@Autowired
	private RepositoryHogar repoHogar;
	
	@Autowired
	private RepositoryRegion repoRegion;
	**/
	@Autowired
	private RepositoryProvincia repoProvincia;
	
	public Provincia getProvinciaByNombre(String nombre) {
		Provincia nueva = repoProvincia.findDatos(nombre);
		nueva = repoProvincia.findComunas(nueva);
		return nueva;
	}

}
