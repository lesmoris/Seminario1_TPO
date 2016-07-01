package Modelo;

public class Cliente {

	private String nombre;
	private String DNI;
	private String mail;
	private String direccion;
	private String tipoDNI;
	private int idCliente;
	
	public Cliente(String nombre, String DNI, String mail, String direccion, String tipoDNI, int idCliente){
		this.nombre=nombre;
		this.DNI=DNI;
		this.mail=mail;
		this.direccion=direccion;
		this.tipoDNI=tipoDNI;
		this.idCliente=idCliente;
	}
	
	public Cliente (){
		
	}
	
	public boolean sosCliente(String DNI, String tipoDNI){
		return this.DNI.equals(DNI) && this.tipoDNI.equals(tipoDNI);
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	
	
	
	
}
