package cl.usach.fingesoft.data;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Hogar;

@Component
public class TipologiaHogar {

	private double unipersonal;
	private double compuesto;
	private double extenso;
	private double sinNucleo;
	private double monoParental;
	private double parejasSinHijos;
	private double parejasConHijos;
	
	
	public double getUnipersonal() {
		return unipersonal;
	}
	public void setUnipersonal(double unipersonal) {
		this.unipersonal = unipersonal;
	}
	public double getCompuesto() {
		return compuesto;
	}
	public void setCompuesto(double compuesto) {
		this.compuesto = compuesto;
	}
	public double getExtenso() {
		return extenso;
	}
	public void setExtenso(double extenso) {
		this.extenso = extenso;
	}
	public double getSinNucleo() {
		return sinNucleo;
	}
	public void setSinNucleo(double sinNucleo) {
		this.sinNucleo = sinNucleo;
	}
	public double getMonoParental() {
		return monoParental;
	}
	public void setMonoParental(double monoParental) {
		this.monoParental = monoParental;
	}
	public double getParejasSinHijos() {
		return parejasSinHijos;
	}
	public void setParejasSinHijos(double parejasSinHijos) {
		this.parejasSinHijos = parejasSinHijos;
	}
	public double getParejasConHijos() {
		return parejasConHijos;
	}
	public void setParejasConHijos(double parejasConHijos) {
		this.parejasConHijos = parejasConHijos;
	}
	
	
	public TipologiaHogar calcularTipologia(List<Hogar> listaHogares) {
		double total = 0;
		double unipersonal = 0;
		double compuesto = 0;
		double extenso = 0;
		double sinNucleo = 0;
		double monoParental = 0;
		double parejasSinHijos = 0;
		double parejasConHijos = 0;
		TipologiaHogar tipologia = new TipologiaHogar();
		for(int i = 0; i < listaHogares.size(); i++) {
			if(listaHogares.get(i).getTipoHogar() == 1) {
				unipersonal++;
				total++;
			}
			else if(listaHogares.get(i).getTipoHogar() == 2) {
				monoParental++;
				total++;
			}
			else if(listaHogares.get(i).getTipoHogar() == 3) {
				parejasSinHijos++;
				total++;
			}
			else if(listaHogares.get(i).getTipoHogar() == 4) {
				parejasConHijos++;
				total++;
			}
			else if(listaHogares.get(i).getTipoHogar() == 5) {
				compuesto++;
				total++;
			}
			else if(listaHogares.get(i).getTipoHogar() == 6) {
				extenso++;
				total++;
			}
			else if(listaHogares.get(i).getTipoHogar() == 7) {
				sinNucleo++;
				total++;
			}
		}
		tipologia.setUnipersonal((unipersonal / total) * 100);
		tipologia.setCompuesto((compuesto / total) * 100);
		tipologia.setExtenso((extenso / total) * 100);
		tipologia.setSinNucleo((sinNucleo / total) * 100);
		tipologia.setMonoParental((monoParental / total) * 100);
		tipologia.setParejasSinHijos((parejasSinHijos / total) * 100);
		tipologia.setParejasConHijos((parejasConHijos / total) * 100);
		return tipologia;
	}

}
