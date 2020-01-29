package cl.usach.fingesoft.data;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.usach.fingesoft.model.Persona;

@Component
public class EdadesPorGenero {

	private int entre0y4;
	private int entre5y9;
	private int entre10y14;
	private int entre15y19;
	private int entre20y24;
	private int entre25y29;
	private int entre30y34;
	private int entre35y39;
	private int entre40y44;
	private int entre45y49;
	private int entre50y54;
	private int entre55y59;
	private int entre60y64;
	private int entre65y69;
	private int entre70y74;
	private int entre75y79;
	private int entre80y84;
	private int entre85y89;
	private int entre90y94;
	private int entre95y99;
	private int masDe100;
	public int getEntre0y4() {
		return entre0y4;
	}
	public void setEntre0y4(int entre0y4) {
		this.entre0y4 = entre0y4;
	}
	public int getEntre5y9() {
		return entre5y9;
	}
	public void setEntre5y9(int entre5y9) {
		this.entre5y9 = entre5y9;
	}
	public int getEntre10y14() {
		return entre10y14;
	}
	public void setEntre10y14(int entre10y14) {
		this.entre10y14 = entre10y14;
	}
	public int getEntre15y19() {
		return entre15y19;
	}
	public void setEntre15y19(int entre15y19) {
		this.entre15y19 = entre15y19;
	}
	public int getEntre20y24() {
		return entre20y24;
	}
	public void setEntre20y24(int entre20y24) {
		this.entre20y24 = entre20y24;
	}
	public int getEntre25y29() {
		return entre25y29;
	}
	public void setEntre25y29(int entre25y29) {
		this.entre25y29 = entre25y29;
	}
	public int getEntre30y34() {
		return entre30y34;
	}
	public void setEntre30y34(int entre30y34) {
		this.entre30y34 = entre30y34;
	}
	public int getEntre35y39() {
		return entre35y39;
	}
	public void setEntre35y39(int entre35y39) {
		this.entre35y39 = entre35y39;
	}
	public int getEntre40y44() {
		return entre40y44;
	}
	public void setEntre40y44(int entre40y44) {
		this.entre40y44 = entre40y44;
	}
	public int getEntre45y49() {
		return entre45y49;
	}
	public void setEntre45y49(int entre45y49) {
		this.entre45y49 = entre45y49;
	}
	public int getEntre50y54() {
		return entre50y54;
	}
	public void setEntre50y54(int entre50y54) {
		this.entre50y54 = entre50y54;
	}
	public int getEntre55y59() {
		return entre55y59;
	}
	public void setEntre55y59(int entre55y59) {
		this.entre55y59 = entre55y59;
	}
	public int getEntre60y64() {
		return entre60y64;
	}
	public void setEntre60y64(int entre60y64) {
		this.entre60y64 = entre60y64;
	}
	public int getEntre65y69() {
		return entre65y69;
	}
	public void setEntre65y69(int entre65y69) {
		this.entre65y69 = entre65y69;
	}
	public int getEntre70y74() {
		return entre70y74;
	}
	public void setEntre70y74(int entre70y74) {
		this.entre70y74 = entre70y74;
	}
	public int getEntre75y79() {
		return entre75y79;
	}
	public void setEntre75y79(int entre75y79) {
		this.entre75y79 = entre75y79;
	}
	public int getEntre80y84() {
		return entre80y84;
	}
	public void setEntre80y84(int entre80y84) {
		this.entre80y84 = entre80y84;
	}
	public int getEntre85y89() {
		return entre85y89;
	}
	public void setEntre85y89(int entre85y89) {
		this.entre85y89 = entre85y89;
	}
	public int getEntre90y94() {
		return entre90y94;
	}
	public void setEntre90y94(int entre90y94) {
		this.entre90y94 = entre90y94;
	}
	public int getEntre95y99() {
		return entre95y99;
	}
	public void setEntre95y99(int entre95y99) {
		this.entre95y99 = entre95y99;
	}
	public int getMasDe100() {
		return masDe100;
	}
	public void setMasDe100(int masDe100) {
		this.masDe100 = masDe100;
	}
	
	
	public EdadesPorGenero registrosPorListaPersonas(int genero, List<Persona> listaPersonas) {
		EdadesPorGenero edades = new EdadesPorGenero();
		int entre0y4 = 0;
		int entre5y9 = 0;
		int entre10y14 = 0;
		int entre15y19 = 0;
		int entre20y24 = 0;
		int entre25y29 = 0;
		int entre30y34 = 0;
		int entre35y39 = 0;
		int entre40y44 = 0;
		int entre45y49 = 0;
		int entre50y54 = 0;
		int entre55y59 = 0;
		int entre60y64 = 0;
		int entre65y69 = 0;
		int entre70y74 = 0;
		int entre75y79 = 0;
		int entre80y84 = 0;
		int entre85y89 = 0;
		int entre90y94 = 0;
		int entre95y99 = 0;
		int masDe100 = 0;
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getP08() == genero) {
				if(listaPersonas.get(i).getP09() >= 0 && listaPersonas.get(i).getP09() <= 4) {
					entre0y4++;
				}
				else if(listaPersonas.get(i).getP09() >= 5 && listaPersonas.get(i).getP09() <= 9) {
					entre5y9++;
				}
				else if(listaPersonas.get(i).getP09() >= 10 && listaPersonas.get(i).getP09() <= 14) {
					entre10y14++;
				}
				else if(listaPersonas.get(i).getP09() >= 15 && listaPersonas.get(i).getP09() <= 19) {
					entre15y19++;
				}
				else if(listaPersonas.get(i).getP09() >= 20 && listaPersonas.get(i).getP09() <= 24) {
					entre20y24++;
				}
				else if(listaPersonas.get(i).getP09() >= 25 && listaPersonas.get(i).getP09() <= 29) {
					entre25y29++;
				}
				else if(listaPersonas.get(i).getP09() >= 30 && listaPersonas.get(i).getP09() <= 34) {
					entre30y34++;
				}
				else if(listaPersonas.get(i).getP09() >= 35 && listaPersonas.get(i).getP09() <= 39) {
					entre35y39++;
				}
				else if(listaPersonas.get(i).getP09() >= 40 && listaPersonas.get(i).getP09() <= 44) {
					entre40y44++;
				}
				else if(listaPersonas.get(i).getP09() >= 45 && listaPersonas.get(i).getP09() <= 49) {
					entre45y49++;
				}
				else if(listaPersonas.get(i).getP09() >= 50 && listaPersonas.get(i).getP09() <= 54) {
					entre50y54++;
				}
				else if(listaPersonas.get(i).getP09() >= 55 && listaPersonas.get(i).getP09() <= 59) {
					entre55y59++;
				}
				else if(listaPersonas.get(i).getP09() >= 60 && listaPersonas.get(i).getP09() <= 64) {
					entre60y64++;
				}
				else if(listaPersonas.get(i).getP09() >= 65 && listaPersonas.get(i).getP09() <= 69) {
					entre65y69++;
				}
				else if(listaPersonas.get(i).getP09() >= 70 && listaPersonas.get(i).getP09() <= 74) {
					entre70y74++;
				}
				else if(listaPersonas.get(i).getP09() >= 75 && listaPersonas.get(i).getP09() <= 79) {
					entre75y79++;
				}
				else if(listaPersonas.get(i).getP09() >= 80 && listaPersonas.get(i).getP09() <= 84) {
					entre80y84++;
				}
				else if(listaPersonas.get(i).getP09() >= 85 && listaPersonas.get(i).getP09() <= 89) {
					entre85y89++;
				}
				else if(listaPersonas.get(i).getP09() >= 90 && listaPersonas.get(i).getP09() <= 94) {
					entre90y94++;
				}
				else if(listaPersonas.get(i).getP09() >= 95 && listaPersonas.get(i).getP09() <= 99) {
					entre95y99++;
				}
				else if(listaPersonas.get(i).getP09() == 100) {
					masDe100++;
				}
			}
		}
		edades.setEntre0y4(entre0y4);
		edades.setEntre5y9(entre5y9);
		edades.setEntre10y14(entre10y14);
		edades.setEntre15y19(entre15y19);
		edades.setEntre20y24(entre20y24);
		edades.setEntre25y29(entre25y29);
		edades.setEntre30y34(entre30y34);
		edades.setEntre35y39(entre35y39);
		edades.setEntre40y44(entre40y44);
		edades.setEntre45y49(entre45y49);
		edades.setEntre50y54(entre50y54);
		edades.setEntre55y59(entre55y59);
		edades.setEntre60y64(entre60y64);
		edades.setEntre65y69(entre65y69);
		edades.setEntre70y74(entre70y74);
		edades.setEntre75y79(entre75y79);
		edades.setEntre80y84(entre80y84);
		edades.setEntre85y89(entre85y89);
		edades.setEntre90y94(entre90y94);
		edades.setEntre95y99(entre95y99);
		edades.setMasDe100(masDe100);
		return edades;
	}
}
