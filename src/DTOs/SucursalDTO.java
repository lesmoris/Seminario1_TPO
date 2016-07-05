package DTOs;

public class SucursalDTO {

	private String nombre;
	private String direccion;
	private int idSucursal;
	private String telefono;
	private String mail;
	
	
	
	public SucursalDTO(){
		
	}
	
	public SucursalDTO(String nombre, String direccion, int idSucursal, String telefono, String mail){
		
		this.nombre=nombre;
		this.direccion=direccion;
		this.idSucursal=idSucursal;
		this.telefono=telefono;
		this.mail=mail;
		
		
	}
	
	
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
