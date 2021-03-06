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


@Component
public class RepositoryComuna {
	
	@Autowired
	private RepositoryArchivos repoArchivos;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryComuna.class);
	
	public Comuna findDatos(String nombre) {
		Comuna retorno = new Comuna();
		String nombreArchivo = "Microdato_Censo2017-Comunas.csv";
		String comuna = nombre.toUpperCase();
		String texto = "";
		String[] info;
		int num;
		try {
			FileReader lector = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaGeografica() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(lector);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				if(info[1].equals(comuna)) {
					retorno.setNombre(comuna);
					num = Integer.parseInt(info[0]);
					retorno.setNumero(num);
				}
			}
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return retorno;
	}
	
	public Comuna findComunaByCodigo(int codigo) {
		Comuna nueva = new Comuna();
		String nombreArchivo = "Microdato_Censo2017-Comunas.csv";
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
			LOG.error("Error al abrir el archivo" + nombreArchivo);
		}
		return nueva;
	}
	
	public Comuna findLocalidades(Comuna nombre) {
		String nombreArchivo = "Microdato_Censo2017-Distritos.csv";
		String texto = "";
		String[] info;
		int codigo;
		List<Integer> lista = new ArrayList<>();
		List<String> localidades = new ArrayList<>();
		try {
			FileReader lector = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaGeografica() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(lector);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				codigo = Integer.parseInt(info[0]);
				if(codigo == nombre.getNumero()) {
					lista.add(Integer.parseInt(info[1]));
					localidades.add(info[2]);
				}
			}
			nombre.setDc(lista);
			nombre.setLocalidades(localidades);
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return nombre;
	}


}
