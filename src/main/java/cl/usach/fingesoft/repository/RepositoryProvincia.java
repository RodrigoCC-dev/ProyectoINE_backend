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
import cl.usach.fingesoft.model.Provincia;

@Component
public class RepositoryProvincia {
	
	@Autowired
	private RepositoryComuna repoComuna;
	
	@Autowired
	private RepositoryArchivos repoArchivos;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryProvincia.class);
	
	
	public Provincia findDatos(String nombre) {
		Provincia nuevo = new Provincia();
		String nombreArchivo = "Microdato_Censo2017-Provincias.csv";
		String provincia = nombre.toUpperCase();
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaGeografica() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				if(info[1].equals(provincia)) {
					nuevo.setNombre(provincia);
					nuevo.setNumero(Integer.parseInt(info[0]));
				}
			}
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return nuevo;	
	}
	
	
	public Provincia findPronviciaByCodigo(int codigo) {
		Provincia nueva = new Provincia();
		String nombreArchivo = "Microdato_Censo2017-Provincias.csv";
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaGeografica() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				if(codigo == Integer.parseInt(info[0])) {
					nueva.setNumero(codigo);
					nueva.setNombre(info[1]);
				}
			}
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return nueva;
	}
	
	
	public Provincia findComunas(Provincia nombre) {
		String nombreArchivo = "Microdato_Censo2017-Geografia.csv"; 
		String texto = "";
		String[] info;
		int codigo;
		List<Integer> idComunas = new ArrayList<>();
		List<Comuna> comunas = new ArrayList<>();
		Comuna newComuna = new Comuna();
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaGeografica() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				codigo = Integer.parseInt(info[1]); 
				if(codigo == nombre.getNumero()) {
					if(!idComunas.contains(Integer.parseInt(info[2]))) {
						newComuna = repoComuna.findComunaByCodigo(Integer.parseInt(info[2]));
						newComuna = repoComuna.findLocalidades(newComuna);
						idComunas.add(newComuna.getNumero());
						comunas.add(newComuna);
					}
				}
			}
			nombre.setListaComunas(comunas);
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return nombre;
	}
	
}
