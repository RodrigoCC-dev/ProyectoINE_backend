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
import cl.usach.fingesoft.model.Distrito;

@Component
public class RepositoryDistrito {
	
	@Autowired
	private RepositoryComuna repoComuna;
	
	@Autowired
	private RepositoryArchivos repoArchivos;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryDistrito.class);
	
	
	public Distrito findDistrito(int numero) {
		Distrito nuevo = new Distrito();
		String nombreArchivo = "Division_Politica-Chile.csv";
		String texto = "";
		String[] info;
		List<Comuna> comunas = new ArrayList<>();
		Comuna newComuna = new Comuna();
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				if(Integer.parseInt(info[2]) == numero) {
					nuevo.setNumero(numero);
					newComuna = repoComuna.findComunaByCodigo(Integer.parseInt(info[3]));
					newComuna = repoComuna.findLocalidades(newComuna);
					comunas.add(newComuna);
				}
			}
			nuevo.setListaComunas(comunas);
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return nuevo;
	}
	
	public List<Distrito> findAll(){
		List<Distrito> listaDistritos = new ArrayList<>();
		List<Integer> listaNumeros = new ArrayList<>();
		String nombreArchivo = "Division_Politica-Chile.csv";
		String texto = "";
		String[] info;
		int distritoActual = 0;
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				if(distritoActual != Integer.parseInt(info[2])) {
					listaNumeros.add(Integer.parseInt(info[2]));
					distritoActual = Integer.parseInt(info[2]);
				}
			}
			contenido.close();
			for(int i = 0; i < listaNumeros.size(); i++) {
				Distrito distrito = this.findDistrito(listaNumeros.get(i));
				listaDistritos.add(distrito);
			}
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return listaDistritos;
	}

}
