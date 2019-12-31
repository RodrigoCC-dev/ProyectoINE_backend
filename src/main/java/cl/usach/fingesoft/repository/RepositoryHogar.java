package cl.usach.fingesoft.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Hogar;

@Component
public class RepositoryHogar {

	@Autowired
	private RepositoryComuna repoComuna;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryHogar.class);
	
	
	public List<Hogar> findAll() {
		Hogar nuevoHogar = new Hogar();
		List<Hogar> hogares = new ArrayList<Hogar>();
		String nombreArchivo = "Microdato_Censo2017-Hogares.csv";
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(RepositoryArchivos.getRutaHogares() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				nuevoHogar.setRegion(Integer.parseInt(info[0]));
				nuevoHogar.setProvincia(Integer.parseInt(info[1]));
				nuevoHogar.setComuna(Integer.parseInt(info[2]));
				nuevoHogar.setDc(Integer.parseInt(info[3]));
				nuevoHogar.setArea(Integer.parseInt(info[4]));
				nuevoHogar.setZcLoc(Integer.parseInt(info[5]));
				nuevoHogar.setIdZonaLoc(Integer.parseInt(info[6]));
				nuevoHogar.setnViv(Integer.parseInt(info[7]));
				nuevoHogar.setnHogar(Integer.parseInt(info[8]));
				nuevoHogar.setTipoHogar(Integer.parseInt(info[9]));
				nuevoHogar.setTipoOperativo(Integer.parseInt(info[10]));
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
		Hogar nuevoHogar = new Hogar();
		List<Hogar> hogares = new ArrayList<Hogar>();
		String nombreArchivo = "Microdato_Censo2017-Hogares.csv";
		String nombreFuente = "Hogares_";
		String texto = "";
		String[] info;
		Comuna comuna = repoComuna.findDatos(nombre);
		if(comuna.getNumero() != 0) {
			nombreFuente = nombreFuente + comuna.getNombre() + ".csv";
			try {
				FileReader archivo = new FileReader(RepositoryArchivos.getRutaHogares() + nombreFuente);
				BufferedReader contenido = new BufferedReader(archivo);
				texto = contenido.readLine();
				while((texto = contenido.readLine()) != null) {
					info = texto.split(";");
					nuevoHogar.setRegion(Integer.parseInt(info[0]));
					nuevoHogar.setProvincia(Integer.parseInt(info[1]));
					nuevoHogar.setComuna(Integer.parseInt(info[2]));
					nuevoHogar.setDc(Integer.parseInt(info[3]));
					nuevoHogar.setArea(Integer.parseInt(info[4]));
					nuevoHogar.setZcLoc(Integer.parseInt(info[5]));
					nuevoHogar.setIdZonaLoc(Integer.parseInt(info[6]));
					nuevoHogar.setnViv(Integer.parseInt(info[7]));
					nuevoHogar.setnHogar(Integer.parseInt(info[8]));
					nuevoHogar.setTipoHogar(Integer.parseInt(info[9]));
					nuevoHogar.setTipoOperativo(Integer.parseInt(info[10]));
					hogares.add(nuevoHogar);
				}
				contenido.close();
			}
			catch(Exception e) {
				try {
					FileReader archivo = new FileReader(RepositoryArchivos.getRutaHogares() + nombreArchivo);
					BufferedReader contenido = new BufferedReader(archivo);
					texto = contenido.readLine();
					while((texto = contenido.readLine()) != null) {
						info = texto.split(";");
						if(Integer.parseInt(info[2]) == comuna.getNumero()) {
							nuevoHogar.setRegion(Integer.parseInt(info[0]));
							nuevoHogar.setProvincia(Integer.parseInt(info[1]));
							nuevoHogar.setComuna(Integer.parseInt(info[2]));
							nuevoHogar.setDc(Integer.parseInt(info[3]));
							nuevoHogar.setArea(Integer.parseInt(info[4]));
							nuevoHogar.setZcLoc(Integer.parseInt(info[5]));
							nuevoHogar.setIdZonaLoc(Integer.parseInt(info[6]));
							nuevoHogar.setnViv(Integer.parseInt(info[7]));
							nuevoHogar.setnHogar(Integer.parseInt(info[8]));
							nuevoHogar.setTipoHogar(Integer.parseInt(info[9]));
							nuevoHogar.setTipoOperativo(Integer.parseInt(info[10]));
							hogares.add(nuevoHogar);
						}
					}
					contenido.close();
					this.guardarPorComuna(nombre);
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
	
	
	public void guardarPorComuna(String comuna) {
		String nombreFuente = "Microdato_Censo2017-Hogares.csv";
		String archivoDestino = "Hogares_" + comuna.toUpperCase() + ".csv";
		String texto = "";
		String[] info;
		Comuna nueva = repoComuna.findDatos(comuna);		
		if(nueva.getNumero() != 0) {
			try {
				FileReader archivo = new FileReader(RepositoryArchivos.getRutaHogares() + nombreFuente);
				BufferedReader contenido = new BufferedReader(archivo);
				try {
					FileWriter destino = new FileWriter(RepositoryArchivos.getRutaHogares() + archivoDestino);
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
					LOG.error("Error al guardarPorComuna. No es posible abrir archivo de destino " + archivoDestino);
				}
			}
			catch(Exception e) {
				LOG.error("Error al guardarPorComuna. No es posible abrir archivo " + nombreFuente);
			}
		}
		else {
			LOG.warn("No existe la comuna " + comuna);
		}
	}
	
}
