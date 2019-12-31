package cl.usach.fingesoft.repository;

public class RepositoryArchivos {

	private static String rutaGeografica = "D:\\Datos Censo 2017\\Microdato_Censo2017-Personas\\Censo2017_Identificación_Geográfica\\";
	private static String rutaParlamentarios = "src/main/resources/static/";
	private static String rutaHogares = "D:\\Datos Censo 2017\\Microdato_Censo2017-Hogares\\";
	
	
	
	
	public static String getRutaGeografica() {
		return rutaGeografica;
	}
	public static void setRutaGeografica(String rutaGeografica) {
		RepositoryArchivos.rutaGeografica = rutaGeografica;
	}
	public static String getRutaParlamentarios() {
		return rutaParlamentarios;
	}
	public static void setRutaParlamentarios(String rutaParlamentarios) {
		RepositoryArchivos.rutaParlamentarios = rutaParlamentarios;
	}
	public static String getRutaHogares() {
		return rutaHogares;
	}
	public static void setRutaHogares(String rutaHogares) {
		RepositoryArchivos.rutaHogares = rutaHogares;
	}
	
}
