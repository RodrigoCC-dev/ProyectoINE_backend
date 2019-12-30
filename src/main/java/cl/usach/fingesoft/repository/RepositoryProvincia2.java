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
public class RepositoryProvincia2 {
	
	@Autowired
	private RepositoryComuna repoComuna;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryProvincia2.class);
	
	
	public Provincia findDatos(String nombre) {
		Provincia nuevo = new Provincia();
		String nombreArchivo = "Microdato_Censo2017-Provincias.csv";
		String provincia = nombre.toUpperCase();
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(RepositoryComuna.getRutaArchivos() + nombreArchivo);
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
	
	
	public Provincia findComunas(Provincia nombre) {
		String nombreArchivo = "Microdato_Censo2017-Urbano.csv"; 
		String texto = "";
		String[] info;
		int codigo;
		List<Comuna> comunas = new ArrayList<>();
		Comuna newComuna = new Comuna();
		try {
			FileReader archivo = new FileReader(RepositoryComuna.getRutaArchivos() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				codigo = Integer.parseInt(info[1]); 
				if(codigo == nombre.getNumero()) {
					newComuna = repoComuna.findComunaByCodigo(Integer.parseInt(info[2]));
					newComuna = repoComuna.findLocalidades(newComuna);
					comunas.add(newComuna);
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
