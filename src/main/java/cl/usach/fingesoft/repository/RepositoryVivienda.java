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
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.model.Region;
import cl.usach.fingesoft.model.Vivienda;

@Component
public class RepositoryVivienda {
	
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
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryVivienda.class);
	
	
	public List<Vivienda> findAll(){
		List<Vivienda> viviendas = new ArrayList<>();
		String nombreArchivo = "Microdato_Censo2017-Viviendas.csv";
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaViviendas() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				Vivienda nuevaVivienda = new Vivienda(info);
				viviendas.add(nuevaVivienda);
			}
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return viviendas;
	}
	
	
	public List<Vivienda> findByComuna(String nombre){
		List<Vivienda> viviendas = new ArrayList<>();
		String nombreArchivo = "Microdato_Censo2017-Viviendas.csv";
		String nombreFuente = "Viviendas_";
		String texto = "";
		String[] info;
		Comuna comuna = repoComuna.findDatos(nombre);
		if(comuna.getNumero() != 0) {
			nombreFuente = nombreFuente + comuna.getNombre() + ".csv";
			try {
				FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaViviendas() + nombreFuente);
				BufferedReader contenido = new BufferedReader(archivo);
				texto = contenido.readLine();
				while((texto = contenido.readLine()) != null) {
					info = texto.split(";");
					Vivienda nuevaVivienda = new Vivienda(info);
					viviendas.add(nuevaVivienda);
				}
				contenido.close();
			}
			catch (Exception e) {
				try {
					FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaViviendas() + nombreArchivo);
					BufferedReader contenido = new BufferedReader(archivo);
					texto = contenido.readLine();
					while((texto = contenido.readLine()) != null) {
						info = texto.split(";");
						if(Integer.parseInt(info[2]) == comuna.getNumero()) {
							Vivienda nuevaVivienda = new Vivienda(info);
							viviendas.add(nuevaVivienda);
						}
					}
					contenido.close();
					repoArchivos.guardarViviendasPorComuna(nombre, repoArchivos.getRutaPrincipal() + repoArchivos.getRutaViviendas());
				}
				catch (Exception ex) {
					LOG.error("Error con findByComuna. No es posible abrir archivo " + nombreArchivo);
				}
			}
		}
		else {
			LOG.warn("No existe la comuna " + nombre);
		}
		return viviendas;
	}
	
	
	public List<Vivienda> findByProvincia(String provincia){
		Provincia nuevaProv = repoProvincia.findDatos(provincia);
		nuevaProv = repoProvincia.findComunas(nuevaProv);
		List<Vivienda> viviendas = new ArrayList<>();
		String nombreComuna = "";
		if(nuevaProv.getNumero() != 0) {
			for(int i = 0; i < nuevaProv.getListaComunas().size(); i++) {
				nombreComuna = nuevaProv.getListaComunas().get(i).getNombre();
				viviendas.addAll(this.findByComuna(nombreComuna));
			}
		}
		else {
			LOG.error("Error con findByProvincia. No se encuentra la provincia " + provincia);
		}
		return viviendas;
	}
	
	
	public List<Vivienda> findByRegion(String region){
		Region nuevaRegion = repoRegion.findDatos(region);
		nuevaRegion = repoRegion.findProvincias(nuevaRegion);
		List<Vivienda> viviendas = new ArrayList<>();
		String nuevaProvincia = "";
		if(nuevaRegion.getNumero() != 0) {
			for(int i = 0; i < nuevaRegion.getListaProvincias().size(); i++) {
				nuevaProvincia = nuevaRegion.getListaProvincias().get(i).getNombre();
				viviendas.addAll(this.findByProvincia(nuevaProvincia));
			}
		}
		else {
			LOG.error("Error con findByRegion. No se encuentra la region " + region);
		}
		return viviendas;
	}
	
	
	public List<Vivienda> findByLocalidad(String comuna, String localidad){
		Comuna nuevaComuna = repoComuna.findDatos(comuna);
		nuevaComuna = repoComuna.findLocalidades(nuevaComuna);
		int idLocalidad = 0;
		int posicion = 0;
		List<Vivienda> viviendas;
		List<Vivienda> locales = new ArrayList<>();
		for(int i = 0; i < nuevaComuna.getLocalidades().size(); i++) {
			if(localidad.toUpperCase().equals(nuevaComuna.getLocalidades().get(i))) {
				posicion = nuevaComuna.getLocalidades().indexOf(localidad.toUpperCase());
				idLocalidad = nuevaComuna.getDc().get(posicion);
			}
		}
		viviendas = this.findByComuna(comuna);
		for(int j = 0; j < viviendas.size(); j++) {
			if(viviendas.get(j).getDc() == idLocalidad) {
				locales.add(viviendas.get(j));
			}
		}
		return locales;
	}
	
	
	public List<Vivienda> findByDistrito(int distrito){
		Distrito nuevoDistrito = repoDistrito.findDistrito(distrito);
		List<Vivienda> viviendas = new ArrayList<>();
		String nombreComuna = "";
		for(int i = 0; i < nuevoDistrito.getListaComunas().size(); i++) {
			nombreComuna = nuevoDistrito.getListaComunas().get(i).getNombre();
			viviendas.addAll(this.findByComuna(nombreComuna));
		}
		return viviendas;
	}
	
	
	public List<Vivienda> findByCircunscripcion(int circunscripcion){
		Circunscripcion nuevoCircuns = repoCircunscripcion.findCircunscripcion(circunscripcion);
		List<Vivienda> viviendas = new ArrayList<>();
		String nombreComuna = "";
		for(int i = 0; i < nuevoCircuns.getListaComunas().size(); i++) {
			nombreComuna = nuevoCircuns.getListaComunas().get(i).getNombre();
			viviendas.addAll(this.findByComuna(nombreComuna));
		}
		return viviendas;
	}
}
