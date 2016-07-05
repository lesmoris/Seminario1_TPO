package DTOs;

import java.sql.Date;

import Modelo.Sucursal;

public class MovimientoDTO {

	private int idMovimiento;
	private SucursalDTO origen;
	private SucursalDTO destino;
	private Date fechaInicio;
	private Date fechaFin;
	private String dominio;
	
	public MovimientoDTO(int idMovimiento, SucursalDTO sucursalDTO, SucursalDTO sucursalDTO2, Date fechaInicio, Date fechaFin, String dominio){
		
		this.idMovimiento=idMovimiento;
		this.origen=sucursalDTO;
		this.destino=sucursalDTO2;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.dominio = dominio;
	}
	
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public SucursalDTO getOrigen() {
		return origen;
	}
	public void setOrigen(SucursalDTO origen) {
		this.origen = origen;
	}
	public SucursalDTO getDestino() {
		return destino;
	}
	public void setDestino(SucursalDTO destino) {
		this.destino = destino;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
}
