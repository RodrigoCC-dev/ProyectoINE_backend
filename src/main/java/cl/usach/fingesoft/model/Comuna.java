package cl.usach.fingesoft.model;

import java.util.List;

public class Comuna {
	
	private String nombre;
	private int numero;
	private List<Integer> dc;
	private List<String> localidades;
	
	
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
	public List<String> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(List<String> localidades) {
		this.localidades = localidades;
	}
	public List<Integer> getDc() {
		return dc;
	}
	public void setDc(List<Integer> dc) {
		this.dc = dc;
	}

	
	
}
