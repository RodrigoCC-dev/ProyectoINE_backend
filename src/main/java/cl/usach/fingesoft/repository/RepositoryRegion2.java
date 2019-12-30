package cl.usach.fingesoft.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.model.Region;

@Component
public class RepositoryRegion2 {
	
	@Autowired
	private RepositoryProvincia repoProvincia;

	private static Logger LOG = LoggerFactory.getLogger(RepositoryRegion2.class);
	
	
	public Region findDatos(String nombre) {
		Region nueva = new Region();
		String nombreArchivo = "Microdato_Censo2017-Regiones.csv";
		String region = nombre.toUpperCase();
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(RepositoryComuna.getRutaArchivos() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				if(info[1].equals(region)) {
					nueva.setNombre(region);
					nueva.setNumero(Integer.parseInt(info[0]));
				}
			}
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error E1 al abrir el archivo " + nombreArchivo);
		}
		return nueva;
	}
	
	
	public Region findRegionByCodigo(int codigo) {
		Region nueva = new Region();
		String nombreArchivo = "Microdato_Censo2017-Regiones.csv";
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(RepositoryComuna.getRutaArchivos() + nombreArchivo);
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
			LOG.error("Error E2 al abrir el archivo " + nombreArchivo);
		}
		return nueva;
	}
	
	
	public Region findProvincias(Region region) {
		String nombreArchivo = "Microdato_Censo2017-Urbano.csv";
		String texto = "";
		String[] info;
		List<Provincia> provincias = new ArrayList<Provincia>();
		Provincia newProvincia = new Provincia();
		int idProvAnterior = 0;
		try {
			FileReader archivo = new FileReader(RepositoryComuna.getRutaArchivos() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				if(region.getNumero() == Integer.parseInt(info[0])) {
					if(idProvAnterior != Integer.parseInt(info[1])) {
						newProvincia = repoProvincia.findPronviciaByCodigo(Integer.parseInt(info[1]));
						newProvincia = repoProvincia.findComunas(newProvincia);
						idProvAnterior = newProvincia.getNumero();
						provincias.add(newProvincia);
					}
					
				}
			}
			region.setListaProvincias(provincias);
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error E3 al abrir el archivo " + nombreArchivo);
		}
		return region;
	}
	
}

