package cl.usach.fingesoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.repository.RepositoryComuna;
import cl.usach.fingesoft.repository.RepositoryHogar;
import cl.usach.fingesoft.repository.RepositoryPersona;
import cl.usach.fingesoft.repository.RepositoryVivienda;

@Service
public class ServiceAlcalde {

	/**@Autowired
	private RepositoryPersona repoPersona;
	
	@Autowired
	private RepositoryVivienda repoVivienda;
	**/
	@Autowired
	private RepositoryHogar repoHogar;
	
	@Autowired
	private RepositoryComuna repoComuna;
	
	
	public Comuna getComunaByNombre(String nombre) {
		Comuna nueva = repoComuna.findDatos(nombre);
		nueva = repoComuna.findLocalidades(nueva);
		return nueva;
	}
	
	public Comuna getComunaByCodigo(int codigo) {
		Comuna nueva = repoComuna.findComunaByCodigo(codigo);
		nueva = repoComuna.findLocalidades(nueva);
		return nueva;
	}
	
	//Test//
	//Para prueba de métodos Repository. Eliminar posteriormente
	
	public List<Hogar> getHogaresByComuna(String nombre){
		return repoHogar.findByComuna(nombre);
	}
	
	public List<Hogar> getHogaresByProvincia(String nombre){
		return repoHogar.findByProvincia(nombre);
	}
	
	public List<Hogar> getHogaresByLocalidad(String comuna, String localidad){
		return repoHogar.findByLocalidad(comuna, localidad);
	}
}
