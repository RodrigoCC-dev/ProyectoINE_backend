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
import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.model.Region;

@Component
public class RepositoryHogar {

	@Autowired
	private RepositoryComuna repoComuna;
	
	@Autowired
	private RepositoryProvincia repoProvincia;
	
	@Autowired
	private RepositoryRegion repoRegion;
	
	@Autowired
	private RepositoryArchivos repoArchivos;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryHogar.class);
	
	
	public List<Hogar> findAll() {
		Hogar nuevoHogar = new Hogar();
		List<Hogar> hogares = new ArrayList<Hogar>();
		String nombreArchivo = "Microdato_Censo2017-Hogares.csv";
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaHogares() + nombreArchivo);
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
				FileReader archivo = new FileReader(repoArchivos.getRutaHogares() + nombreFuente);
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
					FileReader archivo = new FileReader(repoArchivos.getRutaHogares() + nombreArchivo);
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
					repoArchivos.guardarHogaresPorComuna(nombre, repoArchivos.getRutaHogares());
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
	
	
	public List<Hogar> findByProvincia(String provincia){
		Provincia nuevaProv = repoProvincia.findDatos(provincia);
		nuevaProv = repoProvincia.findComunas(nuevaProv);
		List<Hogar> hogares = new ArrayList<Hogar>();
		String nombreComuna = "";
		if(nuevaProv.getNumero() != 0) {
			for(int i = 0; i < nuevaProv.getListaComunas().size(); i++) {
				nombreComuna = nuevaProv.getListaComunas().get(i).getNombre();
				hogares.addAll(this.findByComuna(nombreComuna));
			}
		}
		else {
			LOG.error("Error con findByProvincia. No se encuentra la provincia " + provincia);
		}
		return hogares;
	}
	
	
	
	public List<Hogar> findByRegion(String region){
		Region nuevaRegion = repoRegion.findDatos(region);
		nuevaRegion = repoRegion.findProvincias(nuevaRegion);
		List<Hogar> hogares = new ArrayList<Hogar>();
		String nombreProvincia = "";
		if(nuevaRegion.getNumero() != 0) {
			for(int i = 0; i < nuevaRegion.getListaProvincias().size(); i++) {
				nombreProvincia = nuevaRegion.getListaProvincias().get(i).getNombre();
				hogares.addAll(this.findByProvincia(nombreProvincia));
			}
		}
		else {
			LOG.error("Error con findByRegion. No se encuentra al región " + region);
		}
		return hogares;
	}
	
	
	
}
