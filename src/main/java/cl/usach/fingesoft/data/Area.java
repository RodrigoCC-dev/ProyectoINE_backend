package cl.usach.fingesoft.data;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.model.Vivienda;

@Component
public class Area {

	private double rural;
	private double urbana;
	
	
	public double getRural() {
		return rural;
	}
	public void setRural(double rural) {
		this.rural = rural;
	}
	public double getUrbana() {
		return urbana;
	}
	public void setUrbana(double urbana) {
		this.urbana = urbana;
	}
	
	
	public Area calcularArea(List<Hogar> listaHogares) {
		double total = 0;
		double urbano = 0;
		double rural = 0;
		Area distribucion = new Area();
		for(int i = 0; i < listaHogares.size(); i++) {
			if(listaHogares.get(i).getArea() == 1) {
				urbano++;
				total++;
			}
			else if(listaHogares.get(i).getArea() == 2) {
				rural++;
				total++;
			}
		}
		distribucion.setUrbana((urbano / total) * 100);
		distribucion.setRural((rural / total) * 100);
		return distribucion;
	}
	
}
