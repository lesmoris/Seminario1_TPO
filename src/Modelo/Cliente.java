package Modelo;

public class Cliente {

	private String nombre;
	private String DNI;
	private String mail;
	private String direccion;
	private String tipoDNI;
	
	
	
	
	
	
	
	public boolean soscliente(String DNI){
		
		return this.DNI==DNI;
	}
	
	
	
	// SETTERS Y GETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTipoDNI() {
		return tipoDNI;
	}
	public void setTipoDNI(String tipoDNI) {
		this.tipoDNI = tipoDNI;
	}
	
	
	
	
	
	
	
}
