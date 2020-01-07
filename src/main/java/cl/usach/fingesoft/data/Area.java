package cl.usach.fingesoft.data;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Hogar;
import cl.usach.fingesoft.model.Persona;

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
	
	
	public Area calcularArea(List<Persona> listaPersonas) {
		double total = 0;
		double urbano = 0;
		double rural = 0;
		Area distribucion = new Area();
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getArea() == 1) {
				urbano++;
				total++;
			}
			else if(listaPersonas.get(i).getArea() == 2) {
				rural++;
				total++;
			}
		}
		distribucion.setUrbana((urbano / total) * 100);
		distribucion.setRural((rural / total) * 100);
		return distribucion;
	}
	
}
