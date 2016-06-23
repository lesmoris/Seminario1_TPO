package Modelo;

public class Sucursal {

	
	private String nombre;
	private String direccion;
	private int idSucursal;
	
	
	
	public boolean sosSucursal (String nombre){
		
		
		return this.nombre==nombre;
	}
	
	
	
	// GETTeRS Y SETTERS
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
	
	
	
	
	
	
	
}
