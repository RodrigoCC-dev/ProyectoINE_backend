package cl.usach.fingesoft.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Circunscripcion;
import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Distrito;
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.model.Region;

@Component
public class RepositoryHogar {

	@Autowired
	private RepositoryComuna repoComuna;
	
	@Autowired
	private RepositoryProvincia repoProvincia;
	
	@Autowired
	private RepositoryRegion repoRegion;
	
	@Autowired
	private RepositoryDistrito repoDistrito;
	
	@Autowired
	private RepositoryCircunscripcion repoCircunscripcion;
	
	@Autowired
	private RepositoryArchivos repoArchivos;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryHogar.class);
	
	
	public List<Hogar> findAll() {
		List<Hogar> hogares = new ArrayList<>();
		String nombreArchivo = "Microdato_Censo2017-Hogares.csv";
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaHogares() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				Hogar nuevoHogar = new Hogar(info);
				hogares.add(nuevoHogar);
			}
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir archivo " + nombreArchivo);
		}
		return hogares;
	}
	
	
	public List<Hogar> findByComuna(String nombre){
		List<Hogar> hogares = new ArrayList<>();
		String nombreArchivo = "Microdato_Censo2017-Hogares.csv";
		String nombreFuente = "Hogares_";
		String texto = "";
		String[] info;
		Comuna comuna = repoComuna.findDatos(nombre);
		if(comuna.getNumero() != 0) {
			nombreFuente = nombreFuente + comuna.getNombre() + ".csv";
			try {
				FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaHogares() + nombreFuente);
				BufferedReader contenido = new BufferedReader(archivo);
				texto = contenido.readLine();
				while((texto = contenido.readLine()) != null) {
					info = texto.split(";");
					Hogar nuevoHogar = new Hogar(info);
					hogares.add(nuevoHogar);
				}
				contenido.close();
			}
			catch(Exception e) {
				try {
					FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaHogares() + nombreArchivo);
					BufferedReader contenido = new BufferedReader(archivo);
					texto = contenido.readLine();
					while((texto = contenido.readLine()) != null) {
						info = texto.split(";");
						if(Integer.parseInt(info[2]) == comuna.getNumero()) {
							Hogar nuevoHogar = new Hogar(info);
							hogares.add(nuevoHogar);
						}
					}
					contenido.close();
					repoArchivos.guardarHogaresPorComuna(nombre, repoArchivos.getRutaPrincipal() + repoArchivos.getRutaHogares());
				}
				catch (Exception ex) {
					LOG.error("Error con findByComuna. No es posible abrir archivo " + nombreArchivo);
				}
			}
		}
		else {
			LOG.warn("No existe la comuna " + nombre);
		}
		return hogares;
	}
	
	
	public List<Hogar> findByProvincia(String provincia){
		Provincia nuevaProv = repoProvincia.findDatos(provincia);
		nuevaProv = repoProvincia.findComunas(nuevaProv);
		List<Hogar> hogares = new ArrayList<>();
		String nombreComuna = "";
		if(nuevaProv.getNumero() != 0) {
			for(int i = 0; i < nuevaProv.getListaComunas().size(); i++) {
				nombreComuna = nuevaProv.getListaComunas().get(i).getNombre();
				hogares.addAll(this.findByComuna(nombreComuna));
			}
		}
		else {
			LOG.error("Error con findByProvincia. No se encuentra la provincia " + provincia);
		}
		return hogares;
	}
	
	
	
	public List<Hogar> findByRegion(String region){
		Region nuevaRegion = repoRegion.findDatos(region);
		nuevaRegion = repoRegion.findProvincias(nuevaRegion);
		List<Hogar> hogares = new ArrayList<>();
		String nombreProvincia = "";
		if(nuevaRegion.getNumero() != 0) {
			for(int i = 0; i < nuevaRegion.getListaProvincias().size(); i++) {
				nombreProvincia = nuevaRegion.getListaProvincias().get(i).getNombre();
				hogares.addAll(this.findByProvincia(nombreProvincia));
			}
		}
		else {
			LOG.error("Error con findByRegion. No se encuentra al región " + region);
		}
		return hogares;
	}
	
	
	public List<Hogar> findByLocalidad(String comuna, String localidad){
		Comuna nuevaComuna = repoComuna.findDatos(comuna);
		nuevaComuna = repoComuna.findLocalidades(nuevaComuna);
		int idLocalidad = 0;
		int posicion = 0;
		List<Hogar> hogares;
		List<Hogar> locales = new ArrayList<>();
		for(int i = 0; i < nuevaComuna.getLocalidades().size(); i ++) {
			if(localidad.toUpperCase().equals(nuevaComuna.getLocalidades().get(i))) {
				posicion = nuevaComuna.getLocalidades().indexOf(localidad.toUpperCase());
				idLocalidad = nuevaComuna.getDc().get(posicion);
			}
		}
		hogares = this.findByComuna(comuna);
		for(int j = 0; j < hogares.size(); j++) {
			if(hogares.get(j).getDc() == idLocalidad) {
				locales.add(hogares.get(j));
			}
		}
		return locales;
	}
	
	
	public List<Hogar> findByDistrito(int distrito){
		Distrito nuevoDistrito = repoDistrito.findDistrito(distrito);
		List<Hogar> hogares = new ArrayList<>();
		String nombreComuna = "";
		for(int i = 0; i < nuevoDistrito.getListaComunas().size(); i++) {
			nombreComuna = nuevoDistrito.getListaComunas().get(i).getNombre();
			hogares.addAll(this.findByComuna(nombreComuna));
		}
		return hogares;
	}
	
	
	public List<Hogar> findByCircunscripcion(int circunscripcion){
		Circunscripcion nuevoCircns = repoCircunscripcion.findCircunscripcion(circunscripcion);
		List<Hogar> hogares = new ArrayList<>();
		String nombreComuna = "";
		for(int i = 0; i < nuevoCircns.getListaComunas().size(); i++) {
			nombreComuna = nuevoCircns.getListaComunas().get(i).getNombre();
			hogares.addAll(this.findByComuna(nombreComuna));
		}
		return hogares;
	}
	
}
