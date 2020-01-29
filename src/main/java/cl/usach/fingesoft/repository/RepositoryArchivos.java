package cl.usach.fingesoft.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Comuna;

@Component
public class RepositoryArchivos {

	private String rutaPrincipal = "/Datos_Censo_2017/";
	private String rutaGeografica = "Microdato_Censo2017-Personas/Censo2017_Identificación_Geográfica/";
	private String rutaHogares = "Microdato_Censo2017-Hogares/";
	private String rutaViviendas = "Microdato_Censo2017-Viviendas/";
	private String rutaPersonas = "Microdato_Censo2017-Personas/";
	
	@Autowired
	private RepositoryComuna repoComuna;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryArchivos.class);
	
	
	public String getRutaGeografica() {
		return rutaGeografica;
	}
	public void setRutaGeografica(String rutaGeografica) {
		this.rutaGeografica = rutaGeografica;
	}
	public String getRutaHogares() {
		return rutaHogares;
	}
	public void setRutaHogares(String rutaHogares) {
		this.rutaHogares = rutaHogares;
	}
	public String getRutaViviendas() {
		return rutaViviendas;
	}
	public void setRutaViviendas(String rutaViviendas) {
		this.rutaViviendas = rutaViviendas;
	}
	public String getRutaPersonas() {
		return rutaPersonas;
	}
	public void setRutaPersonas(String rutaPersonas) {
		this.rutaPersonas = rutaPersonas;
	}
	public String getRutaPrincipal() {
		return rutaPrincipal;
	}
	public void setRutaPrincipal(String rutaPrincipal) {
		this.rutaPrincipal = rutaPrincipal;
	}
	
	
	
	public void guardarPersonasPorComuna(String comuna, String rutaArchivos) {
		String nombreFuente = "Microdato_Censo2017-Personas.csv";
		String archivoDestino = "Personas_" + comuna.toUpperCase() + ".csv";
		String rutaFuente = rutaArchivos + nombreFuente;
		String rutaDestino = rutaArchivos + archivoDestino;
		try {
			this.guardarPorComuna(comuna, rutaFuente, rutaDestino);
			LOG.info("Generado archivo " + archivoDestino);
		}
		catch(Exception e) {
			LOG.error("No fue posible guardarPersonasPorComuna de " + comuna);
		}
	}
	
	
	public void guardarViviendasPorComuna(String comuna, String rutaArchivos) {
		String nombreFuente = "Microdato_Censo2017-Viviendas.csv";
		String archivoDestino = "Viviendas_" + comuna.toUpperCase() + ".csv";
		String rutaFuente = rutaArchivos + nombreFuente;
		String rutaDestino = rutaArchivos + archivoDestino;
		try {
			this.guardarPorComuna(comuna, rutaFuente, rutaDestino);
			LOG.info("Generado archivo " + archivoDestino);
		}
		catch(Exception e) {
			LOG.error("No fue posible guardarViviendasPorComuna de " + comuna);
		}
	}
	
	
	public void guardarHogaresPorComuna(String comuna, String rutaArchivos) {
		String nombreFuente = "Microdato_Censo2017-Hogares.csv";
		String archivoDestino = "Hogares_" + comuna.toUpperCase() + ".csv";
		String rutaFuente = rutaArchivos + nombreFuente;
		String rutaDestino = rutaArchivos + archivoDestino;
		try {
			this.guardarPorComuna(comuna, rutaFuente, rutaDestino);
			LOG.info("Generado archivo " + archivoDestino);
		}
		catch(Exception e) {
			LOG.error("No fue posible guardarHogaresPorComuna de " + comuna);
		}
	}
	
	
	public void guardarPorComuna(String comuna, String rutaFuente, String rutaDestino) {
		String texto = "";
		String[] info;
		Comuna nueva = repoComuna.findDatos(comuna);		
		if(nueva.getNumero() != 0) {
			try {
				FileReader archivo = new FileReader(rutaFuente);
				BufferedReader contenido = new BufferedReader(archivo);
				try {
					FileWriter destino = new FileWriter(rutaDestino);
					PrintWriter pw = new PrintWriter(destino);
					texto = contenido.readLine();
					pw.write(texto);
					while((texto = contenido.readLine()) != null) {
						info = texto.split(";");
						if(nueva.getNumero() == Integer.parseInt(info[2])) {
							pw.write("\n" + texto);
						}
					}
					pw.close();
					contenido.close();
				}
				catch(Exception e) {
					LOG.error("Error al guardarPorComuna. No es posible abrir archivo de destino.");
				}
			}
			catch(Exception e) {
				LOG.error("Error al guardarPorComuna. No es posible abrir archivo fuente.");
			}
		}
		else {
			LOG.warn("No existe la comuna " + comuna);
		}
	}
	
}
