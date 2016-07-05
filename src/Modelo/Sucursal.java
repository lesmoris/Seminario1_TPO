package Modelo;

import DTOs.SucursalDTO;

public class Sucursal {

	
	private String nombre;
	private String direccion;
	private int idSucursal;
	private String telefono;
	private String mail;
	
	// Metodos
	public boolean sosSucursal (String nombre){
		return this.nombre.equals(nombre);
	}
	
	public SucursalDTO crearVista(){
		
		return new SucursalDTO(this.getNombre(), this.getDireccion(), 
				this.getIdSucursal(), this.getTelefono(), this.getMail());
	}
	
	// Getters and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
