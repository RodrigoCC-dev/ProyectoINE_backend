package cl.usach.fingesoft.model;

import java.util.List;

public class Circunscripcion {

	private int numero;
	private List<Comuna> listaComunas;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<Comuna> getListaComunas() {
		return listaComunas;
	}
	public void setListaComunas(List<Comuna> listaComunas) {
		this.listaComunas = listaComunas;
	}
	
	
	
}
