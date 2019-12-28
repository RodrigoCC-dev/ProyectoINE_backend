package cl.usach.fingesoft.model;

import java.util.List;

public class Region {

	private String nombre;
	private int numero;
	private List<Provincia> listaProvincias;
	
	
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
	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}
	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}
	
	
}
