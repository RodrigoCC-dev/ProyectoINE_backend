package cl.usach.fingesoft.model;

public class Persona {

	private int region;
	private int provincia;
	private int comuna;
	private int dc;
	private int area;
	private int zcLoc;
	private int idZonaLoc;
	private int nViv;
	private int nHogar;
	private int personaN;
	private int p07;
	private int p08;
	private int p09;
	private int p10;
	private int p10Comuna;
	private int p10Pais;
	private int p11;
	private int p11Comuna;
	private int p11Pais;
	private int p12;
	private int p12Comuna;
	private int p12Pais;
	private int p12aLlegada;
	private int p12aTramo;
	private int p13;
	private int p14;
	private int p15;
	private int p15a;
	private int p16;
	private int p16a;
	private int p16aOtro;
	private int p17;
	private String p18;
	private int p19;
	private int p20;
	private int p21m;
	private int p21a;
	private int p10PaisGrupo;
	private int p11PaisGrupo;
	private int p12PaisGrupo;
	private int escolaridad;
	private int p16aGrupo;
	private int region15R;
	private int provincia15R;
	private int comuna15R;
	private int p10comuna15R;
	private int p11comuna15R;
	private int p12comuna15R;
	
	
	public Persona() {
	}
	
	
	public Persona(String[] datos) {
		this.region = Integer.parseInt(datos[0]);
		this.provincia = Integer.parseInt(datos[1]);
		this.comuna = Integer.parseInt(datos[2]); 
		this.dc = Integer.parseInt(datos[3]);
		this.area = Integer.parseInt(datos[4]);
		this.zcLoc = Integer.parseInt(datos[5]);
		this.idZonaLoc = Integer.parseInt(datos[6]);
		this.nViv = Integer.parseInt(datos[7]);
		this.nHogar = Integer.parseInt(datos[8]);
		this.personaN = Integer.parseInt(datos[9]);
		this.p07 = Integer.parseInt(datos[10]);
		this.p08 = Integer.parseInt(datos[11]);
		this.p09 = Integer.parseInt(datos[12]);
		this.p10 = Integer.parseInt(datos[13]);
		this.p10Comuna = Integer.parseInt(datos[14]);
		this.p10Pais = Integer.parseInt(datos[15]);
		this.p11 = Integer.parseInt(datos[16]);
		this.p11Comuna = Integer.parseInt(datos[17]);
		this.p11Pais = Integer.parseInt(datos[18]);
		this.p12 = Integer.parseInt(datos[19]);
		this.p12Comuna = Integer.parseInt(datos[20]);
		this.p12Pais = Integer.parseInt(datos[21]);
		this.p12aLlegada = Integer.parseInt(datos[22]);
		this.p12aTramo = Integer.parseInt(datos[23]);
		this.p13 = Integer.parseInt(datos[24]);
		this.p14 = Integer.parseInt(datos[25]);
		this.p15 = Integer.parseInt(datos[26]);
		this.p15a = Integer.parseInt(datos[27]);
		this.p16 = Integer.parseInt(datos[28]);
		this.p16a = Integer.parseInt(datos[29]);
		this.p16aOtro = Integer.parseInt(datos[30]);
		this.p17 = Integer.parseInt(datos[31]);
		this.p18 = datos[32];
		this.p19 = Integer.parseInt(datos[33]);
		this.p20 = Integer.parseInt(datos[34]);
		this.p21m = Integer.parseInt(datos[35]);
		this.p21a = Integer.parseInt(datos[36]);
		this.p10PaisGrupo = Integer.parseInt(datos[37]);
		this.p11PaisGrupo = Integer.parseInt(datos[38]);
		this.p12PaisGrupo = Integer.parseInt(datos[39]);
		this.escolaridad = Integer.parseInt(datos[40]);
		this.p16aGrupo = Integer.parseInt(datos[41]);
		this.region15R = Integer.parseInt(datos[42]);
		this.provincia15R = Integer.parseInt(datos[43]);
		this.comuna15R = Integer.parseInt(datos[44]);
		this.p10comuna15R = Integer.parseInt(datos[45]);
		this.p11comuna15R = Integer.parseInt(datos[46]);
		this.p12comuna15R = Integer.parseInt(datos[47]);
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
	public int getnHogar() {
		return nHogar;
	}
	public void setnHogar(int nHogar) {
		this.nHogar = nHogar;
	}
	public int getPersonaN() {
		return personaN;
	}
	public void setPersonaN(int personaN) {
		this.personaN = personaN;
	}
	public int getP07() {
		return p07;
	}
	public void setP07(int p07) {
		this.p07 = p07;
	}
	public int getP08() {
		return p08;
	}
	public void setP08(int p08) {
		this.p08 = p08;
	}
	public int getP09() {
		return p09;
	}
	public void setP09(int p09) {
		this.p09 = p09;
	}
	public int getP10() {
		return p10;
	}
	public void setP10(int p10) {
		this.p10 = p10;
	}
	public int getP10Comuna() {
		return p10Comuna;
	}
	public void setP10Comuna(int p10Comuna) {
		this.p10Comuna = p10Comuna;
	}
	public int getP10Pais() {
		return p10Pais;
	}
	public void setP10Pais(int p10Pais) {
		this.p10Pais = p10Pais;
	}
	public int getP11() {
		return p11;
	}
	public void setP11(int p11) {
		this.p11 = p11;
	}
	public int getP11Comuna() {
		return p11Comuna;
	}
	public void setP11Comuna(int p11Comuna) {
		this.p11Comuna = p11Comuna;
	}
	public int getP11Pais() {
		return p11Pais;
	}
	public void setP11Pais(int p11Pais) {
		this.p11Pais = p11Pais;
	}
	public int getP12() {
		return p12;
	}
	public void setP12(int p12) {
		this.p12 = p12;
	}
	public int getP12Comuna() {
		return p12Comuna;
	}
	public void setP12Comuna(int p12Comuna) {
		this.p12Comuna = p12Comuna;
	}
	public int getP12Pais() {
		return p12Pais;
	}
	public void setP12Pais(int p12Pais) {
		this.p12Pais = p12Pais;
	}
	public int getP12aLlegada() {
		return p12aLlegada;
	}
	public void setP12aLlegada(int p12aLlegada) {
		this.p12aLlegada = p12aLlegada;
	}
	public int getP12aTramo() {
		return p12aTramo;
	}
	public void setP12aTramo(int p12aTramo) {
		this.p12aTramo = p12aTramo;
	}
	public int getP13() {
		return p13;
	}
	public void setP13(int p13) {
		this.p13 = p13;
	}
	public int getP14() {
		return p14;
	}
	public void setP14(int p14) {
		this.p14 = p14;
	}
	public int getP15() {
		return p15;
	}
	public void setP15(int p15) {
		this.p15 = p15;
	}
	public int getP15a() {
		return p15a;
	}
	public void setP15a(int p15a) {
		this.p15a = p15a;
	}
	public int getP16() {
		return p16;
	}
	public void setP16(int p16) {
		this.p16 = p16;
	}
	public int getP16a() {
		return p16a;
	}
	public void setP16a(int p16a) {
		this.p16a = p16a;
	}
	public int getP16aOtro() {
		return p16aOtro;
	}
	public void setP16aOtro(int p16aOtro) {
		this.p16aOtro = p16aOtro;
	}
	public int getP17() {
		return p17;
	}
	public void setP17(int p17) {
		this.p17 = p17;
	}
	public String getP18() {
		return p18;
	}
	public void setP18(String p18) {
		this.p18 = p18;
	}
	public int getP19() {
		return p19;
	}
	public void setP19(int p19) {
		this.p19 = p19;
	}
	public int getP20() {
		return p20;
	}
	public void setP20(int p20) {
		this.p20 = p20;
	}
	public int getP21m() {
		return p21m;
	}
	public void setP21m(int p21m) {
		this.p21m = p21m;
	}
	public int getP21a() {
		return p21a;
	}
	public void setP21a(int p21a) {
		this.p21a = p21a;
	}
	public int getP10PaisGrupo() {
		return p10PaisGrupo;
	}
	public void setP10PaisGrupo(int p10PaisGrupo) {
		this.p10PaisGrupo = p10PaisGrupo;
	}
	public int getP11PaisGrupo() {
		return p11PaisGrupo;
	}
	public void setP11PaisGrupo(int p11PaisGrupo) {
		this.p11PaisGrupo = p11PaisGrupo;
	}
	public int getP12PaisGrupo() {
		return p12PaisGrupo;
	}
	public void setP12PaisGrupo(int p12PaisGrupo) {
		this.p12PaisGrupo = p12PaisGrupo;
	}
	public int getEscolaridad() {
		return escolaridad;
	}
	public void setEscolaridad(int escolaridad) {
		this.escolaridad = escolaridad;
	}
	public int getP16aGrupo() {
		return p16aGrupo;
	}
	public void setP16aGrupo(int p16aGrupo) {
		this.p16aGrupo = p16aGrupo;
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


	public int getP10comuna15R() {
		return p10comuna15R;
	}


	public void setP10comuna15R(int p10comuna15r) {
		p10comuna15R = p10comuna15r;
	}


	public int getP11comuna15R() {
		return p11comuna15R;
	}


	public void setP11comuna15R(int p11comuna15r) {
		p11comuna15R = p11comuna15r;
	}


	public int getP12comuna15R() {
		return p12comuna15R;
	}


	public void setP12comuna15R(int p12comuna15r) {
		p12comuna15R = p12comuna15r;
	}
	
	
}
