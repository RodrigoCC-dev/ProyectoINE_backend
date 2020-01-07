package cl.usach.fingesoft.model;

public class Vivienda {

	private int region;
	private int provincia;
	private int comuna;
	private int dc;
	private int area;
	private int zcLoc;
	private int idZonaLoc;
	private int nViv;
	private int p01;
	private int p02;
	private int p03a;
	private int p03b;
	private int p03c;
	private int p04;
	private int p05;
	private int cantHog;
	private int cantPer;
	private int region15R;
	private int provincia15R;
	private int comuna15R;
	
	
	public Vivienda() {
	}
	
	public Vivienda(String[] datos) {
		this.region = Integer.parseInt(datos[0]);
		this.provincia = Integer.parseInt(datos[1]);
		this.comuna = Integer.parseInt(datos[2]);
		this.dc = Integer.parseInt(datos[3]);
		this.area = Integer.parseInt(datos[4]);
		this.zcLoc = Integer.parseInt(datos[5]);
		this.idZonaLoc = Integer.parseInt(datos[6]);
		this.nViv = Integer.parseInt(datos[7]);
		this.p01 = Integer.parseInt(datos[8]);
		this.p02 = Integer.parseInt(datos[9]);
		this.p03a = Integer.parseInt(datos[10]);
		this.p03b = Integer.parseInt(datos[11]);
		this.p03c = Integer.parseInt(datos[12]);
		this.p04 = Integer.parseInt(datos[13]);
		this.p05 = Integer.parseInt(datos[14]);
		this.cantHog = Integer.parseInt(datos[15]);
		this.cantPer = Integer.parseInt(datos[16]);
		this.region15R = Integer.parseInt(datos[17]);
		this.provincia15R = Integer.parseInt(datos[18]);
		this.comuna15R = Integer.parseInt(datos[19]);
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
	public int getnViv() {
		return nViv;
	}
	public void setnViv(int nViv) {
		this.nViv = nViv;
	}
	public int getP01() {
		return p01;
	}
	public void setP01(int p01) {
		this.p01 = p01;
	}
	public int getP02() {
		return p02;
	}
	public void setP02(int p02) {
		this.p02 = p02;
	}
	public int getP03a() {
		return p03a;
	}
	public void setP03a(int p03a) {
		this.p03a = p03a;
	}
	public int getP03b() {
		return p03b;
	}
	public void setP03b(int p03b) {
		this.p03b = p03b;
	}
	public int getP03c() {
		return p03c;
	}
	public void setP03c(int p03c) {
		this.p03c = p03c;
	}
	public int getP04() {
		return p04;
	}
	public void setP04(int p04) {
		this.p04 = p04;
	}
	public int getP05() {
		return p05;
	}
	public void setP05(int p05) {
		this.p05 = p05;
	}
	public int getCantHog() {
		return cantHog;
	}
	public void setCantHog(int cantHog) {
		this.cantHog = cantHog;
	}
	public int getCantPer() {
		return cantPer;
	}
	public void setCantPer(int cantPer) {
		this.cantPer = cantPer;
	}
	public int getRegion15R() {
		return region15R;
	}
	public void setRegion15R(int region15r) {
		region15R = region15r;
	}
	public int getProvincia15R() {
		return provincia15R;
	}
	public void setProvincia15R(int provincia15r) {
		provincia15R = provincia15r;
	}
	public int getComuna15R() {
		return comuna15R;
	}
	public void setComuna15R(int comuna15r) {
		comuna15R = comuna15r;
	}
	
	
	
}
