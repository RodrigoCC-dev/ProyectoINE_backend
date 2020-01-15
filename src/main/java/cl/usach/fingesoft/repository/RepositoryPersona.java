package cl.usach.fingesoft.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Persona;

@Component
public class RepositoryPersona {

	@Autowired
	private RepositoryComuna repoComuna;
	
	@Autowired
	private RepositoryArchivos repoArchivos;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryPersona.class);
	
	
	public List<Persona> findAll(){
		List<Persona> personas = new ArrayList<>();
		String nombreArchivo = "Microdato_Censo2017-Personas.csv";
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaPersonas() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				Persona nuevaPersona = new Persona(info);
				personas.add(nuevaPersona);
			}
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir archivo " + nombreArchivo);
		}
		return personas;
	}
	
	public List<Persona> findByComuna(String nombre){
		List<Persona> personas = new ArrayList<>();
		String nombreArchivo = "Microdato_Censo2017-Personas.csv";
		String nombreFuente = "Personas_";
		String texto = "";
		String[] info;
		Comuna comuna = repoComuna.findDatos(nombre);
		if(comuna.getNumero() != 0) {
			nombreFuente = nombreFuente + comuna.getNombre() + ".csv";
			try {
				FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaPersonas() + nombreFuente);
				BufferedReader contenido = new BufferedReader(archivo);
				texto = contenido.readLine();
				while((texto = contenido.readLine()) != null) {
					info = texto.split(";");
					Persona nuevaPersona = new Persona(info);
					personas.add(nuevaPersona);
				}
				contenido.close();
			}
			catch (Exception e) {
				try {
					FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaPersonas() + nombreArchivo);
					BufferedReader contenido = new BufferedReader(archivo);
					texto = contenido.readLine();
					while((texto = contenido.readLine()) != null) {
						info = texto.split(";");
						if(Integer.parseInt(info[2]) == comuna.getNumero()) {
							Persona nuevaPersona = new Persona(info);
							personas.add(nuevaPersona);
						}
					}
					contenido.close();
					repoArchivos.guardarPersonasPorComuna(nombre, repoArchivos.getRutaPrincipal() + repoArchivos.getRutaPersonas());					
				}
				catch (Exception ex) {
					LOG.error("Error con findByComuna. No es posible abrir archivo " + nombreArchivo);
				}
			}
		}
		else {
			LOG.warn("No existe la comuna " + nombre);
		}
		return personas;	
	}
	
	
	
	public List<Persona> findByLocalidad(String comuna, String localidad){
		Comuna nuevaComuna = repoComuna.findDatos(comuna);
		nuevaComuna = repoComuna.findLocalidades(nuevaComuna);
		int idLocalidad = 0;
		int posicion = 0;
		List<Persona> personas;
		List<Persona> locales = new ArrayList<>();
		for(int i = 0; i < nuevaComuna.getLocalidades().size(); i ++) {
			if(localidad.toUpperCase().equals(nuevaComuna.getLocalidades().get(i))) {
				posicion = nuevaComuna.getLocalidades().indexOf(localidad.toUpperCase());
				idLocalidad = nuevaComuna.getDc().get(posicion);
			}
		}
		personas = this.findByComuna(comuna);
		for(int j = 0; j < personas.size(); j++) {
			if(personas.get(j).getDc() == idLocalidad) {
				locales.add(personas.get(j));
			}
		}
		return locales;
	}
	
	
	
	
}
