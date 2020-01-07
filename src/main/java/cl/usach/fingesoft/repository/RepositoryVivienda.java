package cl.usach.fingesoft.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Vivienda;

@Component
public class RepositoryVivienda {
	
	@Autowired
	private RepositoryComuna repoComuna;
	
	@Autowired
	private RepositoryProvincia repoProvincia;
	
	@Autowired
	private RepositoryRegion repoRegion;
	
	@Autowired
	private RepositoryDistrito repoDistrito;
	
	@Autowired
	private RepositoryCircunscripcion repoCircunscripcion;
	
	@Autowired
	private RepositoryArchivos repoArchivos;
	
	private static Logger LOG = LoggerFactory.getLogger(RepositoryVivienda.class);
	
	
	public List<Vivienda> findAll(){
		List<Vivienda> viviendas = new ArrayList<>();
		String nombreArchivo = "Microdato_Censo2017-Viviendas.csv";
		String texto = "";
		String[] info;
		try {
			FileReader archivo = new FileReader(repoArchivos.getRutaPrincipal() + repoArchivos.getRutaViviendas() + nombreArchivo);
			BufferedReader contenido = new BufferedReader(archivo);
			texto = contenido.readLine();
			while((texto = contenido.readLine()) != null) {
				info = texto.split(";");
				Vivienda nuevaVivienda = new Vivienda();
				nuevaVivienda.setRegion(Integer.parseInt(info[0]));
				nuevaVivienda.setProvincia(Integer.parseInt(info[1]));
				nuevaVivienda.setComuna(Integer.parseInt(info[2]));
				nuevaVivienda.setDc(Integer.parseInt(info[3]));
				nuevaVivienda.setArea(Integer.parseInt(info[4]));
				nuevaVivienda.setZcLoc(Integer.parseInt(info[5]));
				nuevaVivienda.setIdZonaLoc(Integer.parseInt(info[6]));
				nuevaVivienda.setnViv(Integer.parseInt(info[7]));
				nuevaVivienda.setP01(Integer.parseInt(info[8]));
				nuevaVivienda.setP02(Integer.parseInt(info[9]));
				nuevaVivienda.setP03a(Integer.parseInt(info[10]));
				nuevaVivienda.setP03b(Integer.parseInt(info[11]));
				nuevaVivienda.setP03c(Integer.parseInt(info[12]));
				nuevaVivienda.setP04(Integer.parseInt(info[13]));
				nuevaVivienda.setP05(Integer.parseInt(info[14]));
				nuevaVivienda.setCantHog(Integer.parseInt(info[15]));
				nuevaVivienda.setCantPer(Integer.parseInt(info[16]));
				nuevaVivienda.setRegion15R(Integer.parseInt(info[17]));
				nuevaVivienda.setProvincia15R(Integer.parseInt(info[18]));
				nuevaVivienda.setComuna15R(Integer.parseInt(info[19]));
				viviendas.add(nuevaVivienda);
			}
			contenido.close();
		}
		catch (Exception e) {
			LOG.error("Error al abrir el archivo " + nombreArchivo);
		}
		return viviendas;
	}
	
	
	
	
}
