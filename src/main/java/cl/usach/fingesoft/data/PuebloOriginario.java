package cl.usach.fingesoft.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.usach.fingesoft.model.Comuna;
import cl.usach.fingesoft.model.Persona;
import cl.usach.fingesoft.model.Provincia;
import cl.usach.fingesoft.repository.RepositoryPersona;

public class PuebloOriginario {

	private double mapuche;
	private double aymara;
	private double rapaNui;
	private double licanAntai;
	private double quechua;
	private double colla;
	private double diaguita;
	private double kawesqar;
	private double yagan;
	private double otro;
	private double ignorado;
	
	@Autowired
	private RepositoryPersona repoPersona;
	
	
	public double getMapuche() {
		return mapuche;
	}
	public void setMapuche(double mapuche) {
		this.mapuche = mapuche;
	}
	public double getAymara() {
		return aymara;
	}
	public void setAymara(double aymara) {
		this.aymara = aymara;
	}
	public double getRapaNui() {
		return rapaNui;
	}
	public void setRapaNui(double rapaNui) {
		this.rapaNui = rapaNui;
	}
	public double getLicanAntai() {
		return licanAntai;
	}
	public void setLicanAntai(double licanAntai) {
		this.licanAntai = licanAntai;
	}
	public double getQuechua() {
		return quechua;
	}
	public void setQuechua(double quechua) {
		this.quechua = quechua;
	}
	public double getColla() {
		return colla;
	}
	public void setColla(double colla) {
		this.colla = colla;
	}
	public double getDiaguita() {
		return diaguita;
	}
	public void setDiaguita(double diaguita) {
		this.diaguita = diaguita;
	}
	public double getKawesqar() {
		return kawesqar;
	}
	public void setKawesqar(double kawesqar) {
		this.kawesqar = kawesqar;
	}
	public double getYagan() {
		return yagan;
	}
	public void setYagan(double yagan) {
		this.yagan = yagan;
	}
	public double getOtro() {
		return otro;
	}
	public void setOtro(double otro) {
		this.otro = otro;
	}
	public double getIgnorado() {
		return ignorado;
	}
	public void setIgnorado(double ignorado) {
		this.ignorado = ignorado;
	}
	
	
	
	public List<Double> registrosPorListaPersonas(List<Persona> listaPersonas){
		List<Double> subtotales = new ArrayList<>();
		double mapuche = 0;
		double aymara = 0;
		double rapaNui = 0;
		double licanAntai = 0;
		double quechua = 0;
		double colla = 0;
		double diaguita = 0;
		double kawesqar = 0;
		double yagan = 0;
		double otro = 0;
		double ignorado = 0;
		double total = 0;
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getP16() == 1) {
				if(listaPersonas.get(i).getP16a() == 1) {
					mapuche++;
					total++;
				}
				else if(listaPersonas.get(i).getP16a() == 2) {
					aymara++;
					total++;
				}
				else if(listaPersonas.get(i).getP16a() == 3) {
					rapaNui++;
					total++;
				}
				else if(listaPersonas.get(i).getP16a() == 4) {
					licanAntai++;
					total++;
				}
				else if(listaPersonas.get(i).getP16a() == 5) {
					quechua++;
					total++;
				}
				else if(listaPersonas.get(i).getP16a() == 6) {
					colla++;
					total++;
				}
				else if(listaPersonas.get(i).getP16a() == 7) {
					diaguita++;
					total++;
				}
				else if(listaPersonas.get(i).getP16a() == 8) {
					kawesqar++;
					total++;
				}
				else if(listaPersonas.get(i).getP16a() == 9) {
					yagan++;
					total++;
				}
				else if(listaPersonas.get(i).getP16a() == 10) {
					otro++;
					total++;
				}
				else {
					ignorado++;
					total++;
				}
			}
		}
		subtotales.add(mapuche);
		subtotales.add(aymara);
		subtotales.add(rapaNui);
		subtotales.add(licanAntai);
		subtotales.add(quechua);
		subtotales.add(colla);
		subtotales.add(diaguita);
		subtotales.add(kawesqar);
		subtotales.add(yagan);
		subtotales.add(otro);
		subtotales.add(ignorado);
		subtotales.add(total);
		return subtotales;
	}
	
	
	public List<Double> registrosPorComuna(String comuna){
		return this.registrosPorListaPersonas(repoPersona.findByComuna(comuna));
	}
	
	
	public List<Double> registrosPorLocalidad(String comuna, String localidad){
		return this.registrosPorListaPersonas(repoPersona.findByLocalidad(comuna, localidad));
	}
	
	
	public PuebloOriginario calcularPueblosPorComuna(String comuna) {
		List<Double> totales = this.registrosPorComuna(comuna);
		PuebloOriginario pueblos = new PuebloOriginario();
		pueblos.setMapuche((totales.get(0) / totales.get(11)) * 100);
		pueblos.setAymara((totales.get(1) / totales.get(11)) * 100);
		pueblos.setRapaNui((totales.get(2) / totales.get(11)) * 100);
		pueblos.setLicanAntai((totales.get(3) / totales.get(11)) * 100);
		pueblos.setQuechua((totales.get(4) / totales.get(11)) * 100);
		pueblos.setColla((totales.get(5) / totales.get(11)) * 100);
		pueblos.setDiaguita((totales.get(6) / totales.get(11)) * 100);
		pueblos.setKawesqar((totales.get(7) / totales.get(11)) * 100);
		pueblos.setYagan((totales.get(8) / totales.get(11)) * 100);
		pueblos.setOtro((totales.get(9) / totales.get(11)) * 100);
		pueblos.setIgnorado((totales.get(10) / totales.get(11)) * 100);
		return pueblos;
	}
	
	
	public PuebloOriginario calcularPueblosPorLocalidad(String comuna, String localidad) {
		List<Double> totales = this.registrosPorLocalidad(comuna, localidad);
		PuebloOriginario pueblos = new PuebloOriginario();
		pueblos.setMapuche((totales.get(0) / totales.get(11)) * 100);
		pueblos.setAymara((totales.get(1) / totales.get(11)) * 100);
		pueblos.setRapaNui((totales.get(2) / totales.get(11)) * 100);
		pueblos.setLicanAntai((totales.get(3) / totales.get(11)) * 100);
		pueblos.setQuechua((totales.get(4) / totales.get(11)) * 100);
		pueblos.setColla((totales.get(5) / totales.get(11)) * 100);
		pueblos.setDiaguita((totales.get(6) / totales.get(11)) * 100);
		pueblos.setKawesqar((totales.get(7) / totales.get(11)) * 100);
		pueblos.setYagan((totales.get(8) / totales.get(11)) * 100);
		pueblos.setOtro((totales.get(9) / totales.get(11)) * 100);
		pueblos.setIgnorado((totales.get(10) / totales.get(11)) * 100);
		return pueblos;
	}
	
	
	public PuebloOriginario calcularPueblosPorComunas(List<Comuna> listaComunas) {
		PuebloOriginario pueblos = new PuebloOriginario();
		List<Double> parciales;
		double mapuche = 0;
		double aymara = 0;
		double rapaNui = 0;
		double licanAntai = 0;
		double quechua = 0;
		double colla = 0;
		double diaguita = 0;
		double kawesqar = 0;
		double yagan = 0;
		double otro = 0;
		double ignorado = 0;
		double total = 0;
		for(int i = 0; i < listaComunas.size(); i++) {
			parciales = this.registrosPorComuna(listaComunas.get(i).getNombre());
			mapuche = mapuche + parciales.get(0);
			aymara = aymara + parciales.get(1);
			rapaNui = rapaNui + parciales.get(2);
			licanAntai = licanAntai + parciales.get(3);
			quechua = quechua + parciales.get(4);
			colla = colla + parciales.get(5);
			diaguita = diaguita + parciales.get(6);
			kawesqar = kawesqar + parciales.get(7);
			yagan = yagan + parciales.get(8);
			otro = otro + parciales.get(9);
			ignorado = ignorado + parciales.get(10);
			total = total + parciales.get(11);
		}
		pueblos.setMapuche((mapuche / total) * 100);
		pueblos.setAymara((aymara / total) * 100);
		pueblos.setRapaNui((rapaNui / total) * 100);
		pueblos.setLicanAntai((licanAntai / total) * 100);
		pueblos.setQuechua((quechua / total) * 100);
		pueblos.setColla((colla / total) * 100);
		pueblos.setDiaguita((diaguita / total) * 100);
		pueblos.setKawesqar((kawesqar / total) * 100);
		pueblos.setYagan((yagan / total) * 100);
		pueblos.setOtro((otro / total) * 100);
		pueblos.setIgnorado((ignorado / total) * 100);
		return pueblos;
	}
	
	
	public PuebloOriginario calcularPueblosPorProvincias(List<Provincia> listaProvincias) {
		PuebloOriginario pueblos = new PuebloOriginario();
		List<Double> parciales;
		double mapuche = 0;
		double aymara = 0;
		double rapaNui = 0;
		double licanAntai = 0;
		double quechua = 0;
		double colla = 0;
		double diaguita = 0;
		double kawesqar = 0;
		double yagan = 0;
		double otro = 0;
		double ignorado = 0;
		double total = 0;
		for(int i = 0; i < listaProvincias.size(); i++) {
			for(int j = 0; j < listaProvincias.get(i).getListaComunas().size(); j++) {
				parciales = this.registrosPorComuna(listaProvincias.get(i).getListaComunas().get(j).getNombre());
				mapuche = mapuche + parciales.get(0);
				aymara = aymara + parciales.get(1);
				rapaNui = rapaNui + parciales.get(2);
				licanAntai = licanAntai + parciales.get(3);
				quechua = quechua + parciales.get(4);
				colla = colla + parciales.get(5);
				diaguita = diaguita + parciales.get(6);
				kawesqar = kawesqar + parciales.get(7);
				yagan = yagan + parciales.get(8);
				otro = otro + parciales.get(9);
				ignorado = ignorado + parciales.get(10);
				total = total + parciales.get(11);
			}
		}
		pueblos.setMapuche((mapuche / total) * 100);
		pueblos.setAymara((aymara / total) * 100);
		pueblos.setRapaNui((rapaNui / total) * 100);
		pueblos.setLicanAntai((licanAntai / total) * 100);
		pueblos.setQuechua((quechua / total) * 100);
		pueblos.setColla((colla / total) * 100);
		pueblos.setDiaguita((diaguita / total) * 100);
		pueblos.setKawesqar((kawesqar / total) * 100);
		pueblos.setYagan((yagan / total) * 100);
		pueblos.setOtro((otro / total) * 100);
		pueblos.setIgnorado((ignorado / total) * 100);
		return pueblos;
	}
}
