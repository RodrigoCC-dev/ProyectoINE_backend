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

@Component
public class RepositoryCircunscripcion {
	
	@Autowired
	private RepositoryComuna repoComuna;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryCircunscripcion.class);
	
	
	public Circunscripcion findCircunscripcion(int numero) {
		Circunscripcion nueva = new Circunscripcion();
		String nombreArchivo = "División_Politica-Chile.csv";
		String texto = "";
		String[] info;
		List<Comuna> comunas = new ArrayList<Comuna>();
		Comuna newComuna = new Comuna();
		try {
			FileReader archivo = new FileReader(RepositoryArchivos.getRutaParlamentarios() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				if(Integer.parseInt(info[1]) == numero) {
					nueva.setNumero(numero);
					newComuna = repoComuna.findComunaByCodigo(Integer.parseInt(info[3]));
					newComuna = repoComuna.findLocalidades(newComuna);
					comunas.add(newComuna);
				}
			}
			nueva.setListaComunas(comunas);
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return nueva;
	}

}
