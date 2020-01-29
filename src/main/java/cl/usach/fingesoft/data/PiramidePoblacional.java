package cl.usach.fingesoft.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Persona;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.repository.RepositoryPersona;

@Component
public class PiramidePoblacional {

	private EdadesPorGenero mujer;
	private EdadesPorGenero hombre;
	
	@Autowired
	private EdadesPorGenero edades;
	
	@Autowired
	private RepositoryPersona repoPersona;
	
		
	public EdadesPorGenero getMujer() {
		return mujer;
	}

	public void setMujer(EdadesPorGenero mujer) {
		this.mujer = mujer;
	}

	public EdadesPorGenero getHombre() {
		return hombre;
	}

	public void setHombre(EdadesPorGenero hombre) {
		this.hombre = hombre;
	}



	public PiramidePoblacional registrosPorListaPersonas(List<Persona> listaPersonas) {
		EdadesPorGenero valoresMujeres = edades.registrosPorListaPersonas(2, listaPersonas);
		EdadesPorGenero valoresHombres = edades.registrosPorListaPersonas(1, listaPersonas);
		PiramidePoblacional piramide = new PiramidePoblacional();
		piramide.setMujer(valoresMujeres);
		piramide.setHombre(valoresHombres);
		return piramide;
	}
	
	public PiramidePoblacional calcularPiramidePorComuna(String comuna) {
		List<Persona> listaPersonas = repoPersona.findByComuna(comuna);
		PiramidePoblacional piramide = this.registrosPorListaPersonas(listaPersonas);
		return piramide;
	}
	
	public PiramidePoblacional calcularPiramidePorLocalidad(String comuna, String localidad) {
		List<Persona> listaPersonas = repoPersona.findByLocalidad(comuna, localidad);
		PiramidePoblacional piramide = this.registrosPorListaPersonas(listaPersonas);
		return piramide;
	}
	
	public PiramidePoblacional calcularPiramidePorComunas(List<Comuna> listaComunas) {
		PiramidePoblacional parcial;
		PiramidePoblacional total = this.calcularPiramidePorComuna(listaComunas.get(0).getNombre());
		for(int i = 1; i < listaComunas.size(); i++) {
			parcial = this.calcularPiramidePorComuna(listaComunas.get(i).getNombre());
			total.getHombre().setEntre0y4(total.getHombre().getEntre0y4() + parcial.getHombre().getEntre0y4());
			total.getHombre().setEntre5y9(total.getHombre().getEntre5y9() + parcial.getHombre().getEntre5y9());
			total.getHombre().setEntre10y14(total.getHombre().getEntre10y14() + parcial.getHombre().getEntre10y14());
			total.getHombre().setEntre15y19(total.getHombre().getEntre15y19() + parcial.getHombre().getEntre15y19());
			total.getHombre().setEntre20y24(total.getHombre().getEntre20y24() + parcial.getHombre().getEntre20y24());
			total.getHombre().setEntre25y29(total.getHombre().getEntre25y29() + parcial.getHombre().getEntre25y29());
			total.getHombre().setEntre30y34(total.getHombre().getEntre30y34() + parcial.getHombre().getEntre30y34());
			total.getHombre().setEntre35y39(total.getHombre().getEntre35y39() + parcial.getHombre().getEntre35y39());
			total.getHombre().setEntre40y44(total.getHombre().getEntre40y44() + parcial.getHombre().getEntre40y44());
			total.getHombre().setEntre45y49(total.getHombre().getEntre45y49() + parcial.getHombre().getEntre45y49());
			total.getHombre().setEntre50y54(total.getHombre().getEntre50y54() + parcial.getHombre().getEntre50y54());
			total.getHombre().setEntre55y59(total.getHombre().getEntre55y59() + parcial.getHombre().getEntre55y59());
			total.getHombre().setEntre60y64(total.getHombre().getEntre60y64() + parcial.getHombre().getEntre60y64());
			total.getHombre().setEntre65y69(total.getHombre().getEntre65y69() + parcial.getHombre().getEntre65y69());
			total.getHombre().setEntre70y74(total.getHombre().getEntre70y74() + parcial.getHombre().getEntre70y74());
			total.getHombre().setEntre75y79(total.getHombre().getEntre75y79() + parcial.getHombre().getEntre75y79());
			total.getHombre().setEntre80y84(total.getHombre().getEntre80y84() + parcial.getHombre().getEntre80y84());
			total.getHombre().setEntre85y89(total.getHombre().getEntre85y89() + parcial.getHombre().getEntre85y89());
			total.getHombre().setEntre90y94(total.getHombre().getEntre90y94() + parcial.getHombre().getEntre90y94());
			total.getHombre().setEntre95y99(total.getHombre().getEntre95y99() + parcial.getHombre().getEntre95y99());
			total.getHombre().setMasDe100(total.getHombre().getMasDe100() + parcial.getHombre().getMasDe100());
			total.getMujer().setEntre0y4(total.getMujer().getEntre0y4() + parcial.getMujer().getEntre0y4());
			total.getMujer().setEntre5y9(total.getMujer().getEntre5y9() + parcial.getMujer().getEntre5y9());
			total.getMujer().setEntre10y14(total.getMujer().getEntre10y14() + parcial.getMujer().getEntre10y14());
			total.getMujer().setEntre15y19(total.getMujer().getEntre15y19() + parcial.getMujer().getEntre15y19());
			total.getMujer().setEntre20y24(total.getMujer().getEntre20y24() + parcial.getMujer().getEntre20y24());
			total.getMujer().setEntre25y29(total.getMujer().getEntre25y29() + parcial.getMujer().getEntre25y29());
			total.getMujer().setEntre30y34(total.getMujer().getEntre30y34() + parcial.getMujer().getEntre30y34());
			total.getMujer().setEntre35y39(total.getMujer().getEntre35y39() + parcial.getMujer().getEntre35y39());
			total.getMujer().setEntre40y44(total.getMujer().getEntre40y44() + parcial.getMujer().getEntre40y44());
			total.getMujer().setEntre45y49(total.getMujer().getEntre45y49() + parcial.getMujer().getEntre45y49());
			total.getMujer().setEntre50y54(total.getMujer().getEntre50y54() + parcial.getMujer().getEntre50y54());
			total.getMujer().setEntre55y59(total.getMujer().getEntre55y59() + parcial.getMujer().getEntre55y59());
			total.getMujer().setEntre60y64(total.getMujer().getEntre60y64() + parcial.getMujer().getEntre60y64());
			total.getMujer().setEntre65y69(total.getMujer().getEntre65y69() + parcial.getMujer().getEntre65y69());
			total.getMujer().setEntre70y74(total.getMujer().getEntre70y74() + parcial.getMujer().getEntre70y74());
			total.getMujer().setEntre75y79(total.getMujer().getEntre75y79() + parcial.getMujer().getEntre75y79());
			total.getMujer().setEntre80y84(total.getMujer().getEntre80y84() + parcial.getMujer().getEntre80y84());
			total.getMujer().setEntre85y89(total.getMujer().getEntre85y89() + parcial.getMujer().getEntre85y89());
			total.getMujer().setEntre90y94(total.getMujer().getEntre90y94() + parcial.getMujer().getEntre90y94());
			total.getMujer().setEntre95y99(total.getMujer().getEntre95y99() + parcial.getMujer().getEntre95y99());
			total.getMujer().setMasDe100(total.getMujer().getMasDe100() + parcial.getMujer().getMasDe100());
		}
		return total;
	}
	
	public PiramidePoblacional calcularPiramidePorProvincias(List<Provincia> listaProvincias) {
		PiramidePoblacional parcial;
		PiramidePoblacional total = this.calcularPiramidePorComunas(listaProvincias.get(0).getListaComunas());
		for(int i = 1; i < listaProvincias.size(); i++) {
			parcial = this.calcularPiramidePorComunas(listaProvincias.get(i).getListaComunas());
			total.getHombre().setEntre0y4(total.getHombre().getEntre0y4() + parcial.getHombre().getEntre0y4());
			total.getHombre().setEntre5y9(total.getHombre().getEntre5y9() + parcial.getHombre().getEntre5y9());
			total.getHombre().setEntre10y14(total.getHombre().getEntre10y14() + parcial.getHombre().getEntre10y14());
			total.getHombre().setEntre15y19(total.getHombre().getEntre15y19() + parcial.getHombre().getEntre15y19());
			total.getHombre().setEntre20y24(total.getHombre().getEntre20y24() + parcial.getHombre().getEntre20y24());
			total.getHombre().setEntre25y29(total.getHombre().getEntre25y29() + parcial.getHombre().getEntre25y29());
			total.getHombre().setEntre30y34(total.getHombre().getEntre30y34() + parcial.getHombre().getEntre30y34());
			total.getHombre().setEntre35y39(total.getHombre().getEntre35y39() + parcial.getHombre().getEntre35y39());
			total.getHombre().setEntre40y44(total.getHombre().getEntre40y44() + parcial.getHombre().getEntre40y44());
			total.getHombre().setEntre45y49(total.getHombre().getEntre45y49() + parcial.getHombre().getEntre45y49());
			total.getHombre().setEntre50y54(total.getHombre().getEntre50y54() + parcial.getHombre().getEntre50y54());
			total.getHombre().setEntre55y59(total.getHombre().getEntre55y59() + parcial.getHombre().getEntre55y59());
			total.getHombre().setEntre60y64(total.getHombre().getEntre60y64() + parcial.getHombre().getEntre60y64());
			total.getHombre().setEntre65y69(total.getHombre().getEntre65y69() + parcial.getHombre().getEntre65y69());
			total.getHombre().setEntre70y74(total.getHombre().getEntre70y74() + parcial.getHombre().getEntre70y74());
			total.getHombre().setEntre75y79(total.getHombre().getEntre75y79() + parcial.getHombre().getEntre75y79());
			total.getHombre().setEntre80y84(total.getHombre().getEntre80y84() + parcial.getHombre().getEntre80y84());
			total.getHombre().setEntre85y89(total.getHombre().getEntre85y89() + parcial.getHombre().getEntre85y89());
			total.getHombre().setEntre90y94(total.getHombre().getEntre90y94() + parcial.getHombre().getEntre90y94());
			total.getHombre().setEntre95y99(total.getHombre().getEntre95y99() + parcial.getHombre().getEntre95y99());
			total.getHombre().setMasDe100(total.getHombre().getMasDe100() + parcial.getHombre().getMasDe100());
			total.getMujer().setEntre0y4(total.getMujer().getEntre0y4() + parcial.getMujer().getEntre0y4());
			total.getMujer().setEntre5y9(total.getMujer().getEntre5y9() + parcial.getMujer().getEntre5y9());
			total.getMujer().setEntre10y14(total.getMujer().getEntre10y14() + parcial.getMujer().getEntre10y14());
			total.getMujer().setEntre15y19(total.getMujer().getEntre15y19() + parcial.getMujer().getEntre15y19());
			total.getMujer().setEntre20y24(total.getMujer().getEntre20y24() + parcial.getMujer().getEntre20y24());
			total.getMujer().setEntre25y29(total.getMujer().getEntre25y29() + parcial.getMujer().getEntre25y29());
			total.getMujer().setEntre30y34(total.getMujer().getEntre30y34() + parcial.getMujer().getEntre30y34());
			total.getMujer().setEntre35y39(total.getMujer().getEntre35y39() + parcial.getMujer().getEntre35y39());
			total.getMujer().setEntre40y44(total.getMujer().getEntre40y44() + parcial.getMujer().getEntre40y44());
			total.getMujer().setEntre45y49(total.getMujer().getEntre45y49() + parcial.getMujer().getEntre45y49());
			total.getMujer().setEntre50y54(total.getMujer().getEntre50y54() + parcial.getMujer().getEntre50y54());
			total.getMujer().setEntre55y59(total.getMujer().getEntre55y59() + parcial.getMujer().getEntre55y59());
			total.getMujer().setEntre60y64(total.getMujer().getEntre60y64() + parcial.getMujer().getEntre60y64());
			total.getMujer().setEntre65y69(total.getMujer().getEntre65y69() + parcial.getMujer().getEntre65y69());
			total.getMujer().setEntre70y74(total.getMujer().getEntre70y74() + parcial.getMujer().getEntre70y74());
			total.getMujer().setEntre75y79(total.getMujer().getEntre75y79() + parcial.getMujer().getEntre75y79());
			total.getMujer().setEntre80y84(total.getMujer().getEntre80y84() + parcial.getMujer().getEntre80y84());
			total.getMujer().setEntre85y89(total.getMujer().getEntre85y89() + parcial.getMujer().getEntre85y89());
			total.getMujer().setEntre90y94(total.getMujer().getEntre90y94() + parcial.getMujer().getEntre90y94());
			total.getMujer().setEntre95y99(total.getMujer().getEntre95y99() + parcial.getMujer().getEntre95y99());
			total.getMujer().setMasDe100(total.getMujer().getMasDe100() + parcial.getMujer().getMasDe100());
		}
		return total;
	}
}
