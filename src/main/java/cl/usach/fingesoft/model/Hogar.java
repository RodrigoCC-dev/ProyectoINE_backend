package cl.usach.fingesoft.model;

public class Hogar {

	private int region;
	private int provincia;
	private int comuna;
	private int dc;
	private int area;
	private int zcLoc;
	private int idZonaLoc;
	private int nViv;
	private int nHogar;
	private int tipoHogar;
	private int tipoOperativo;
	
	
	
	public Hogar() {
	}
	
	
	public Hogar(String[] datos) {
		this.region = Integer.parseInt(datos[0]);
		this.provincia = Integer.parseInt(datos[1]);
		this.comuna = Integer.parseInt(datos[2]);
		this.dc = Integer.parseInt(datos[3]);
		this.area = Integer.parseInt(datos[4]);
		this.zcLoc = Integer.parseInt(datos[5]);
		this.idZonaLoc = Integer.parseInt(datos[6]);
		this.nViv = Integer.parseInt(datos[7]);
		this.nHogar = Integer.parseInt(datos[8]);
		this.tipoHogar = Integer.parseInt(datos[9]);
		this.tipoOperativo = Integer.parseInt(datos[10]);
	}
	
	
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public int getProvincia() {
		return provincia;
	}
	public void setProvincia(int provincia) {
		this.provincia = provincia;
	}
	public int getComuna() {
		return comuna;
	}
	public void setComuna(int comuna) {
		this.comuna = comuna;
	}
	public int getDc() {
		return dc;
	}
	public void setDc(int dc) {
		this.dc = dc;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getZcLoc() {
		return zcLoc;
	}
	public void setZcLoc(int zcLoc) {
		this.zcLoc = zcLoc;
	}
	public int getIdZonaLoc() {
		return idZonaLoc;
	}
	public void setIdZonaLoc(int idZonaLoc) {
		this.idZonaLoc = idZonaLoc;
	}
	public int getnHogar() {
		return nHogar;
	}
	public void setnHogar(int nHogar) {
		this.nHogar = nHogar;
	}
	public int getTipoHogar() {
		return tipoHogar;
	}
	public void setTipoHogar(int tipoHogar) {
		this.tipoHogar = tipoHogar;
	}
	public int getTipoOperativo() {
		return tipoOperativo;
	}
	public void setTipoOperativo(int tipoOperativo) {
		this.tipoOperativo = tipoOperativo;
	}
	public int getnViv() {
		return nViv;
	}
	public void setnViv(int nViv) {
		this.nViv = nViv;
	}
	
	
}
