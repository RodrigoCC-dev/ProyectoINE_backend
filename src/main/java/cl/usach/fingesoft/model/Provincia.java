package cl.usach.fingesoft.model;

import java.util.List;

public class Provincia {

	private String nombre;
	private int numero;
	private List<Comuna> listaComunas;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
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
