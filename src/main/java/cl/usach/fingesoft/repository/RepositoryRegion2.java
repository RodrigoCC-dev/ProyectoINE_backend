package cl.usach.fingesoft.repository;

import java.io.BufferedReader;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Region;

@Component
public class RepositoryRegion2 {

	private static Logger LOG = LoggerFactory.getLogger(RepositoryRegion2.class);
	
	
	public Region findDatos(String nombre) {
		Region nueva = new Region();
		String nombreArchivo = "Microdato_Censo2017-Regiones.csv";
		String provincia = nombre.toUpperCase();
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(RepositoryComuna.getRutaArchivos() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				
			}
		}
		
	}
}
