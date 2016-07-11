package Modelo;

import java.sql.Date;

import DTOs.ContratoAlquilerDTO;
import Helpers.HelperDate;
import Mappers.contratoMapper;

public class ContratoAlquiler {

	private int numero;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaEmision;
	private float importe;
	private float punitorio;
	private Sucursal sucursalDestino;
	private PresupuestoAlquiler presupuesto;
	
	
	
	// Metodos
	public boolean sosContrato(int numero) {
		return numero == this.numero;
	}

	public void Insert() throws Exception {
		contratoMapper.getInstance().Insert(this);
	}

	public void Update() throws Exception {
		contratoMapper.getInstance().Update(this);
	}

	public void cerrar(Sucursal sucDestino) throws Exception {

		this.setFechaFin(HelperDate.obtenerFechaHoy());
		this.setSucursalDestino(sucDestino);
		this.calcularPunitorios();
		this.Update();
		
		// Ponemos al vehiculo en disponible y le asignamos la sucursal
		this.getPresupuesto().getVehiculo().ponerDisponibleEnSucursal(sucDestino);
	}
	
	private void calcularPunitorios() {
		
		float punitorio = 0;
		
		
		if (HelperDate.ConvertirSQLAUtil(this.getFechaFin()).before(HelperDate.obtenerFechaHoy())){
			System.out.println ("DETECTO FECHA");
			int diasDeAtraso = HelperDate.diferenciaEntreDosfechas(this.getFechaFin(), HelperDate.obtenerFechaHoy());
			punitorio = 100 * diasDeAtraso;
			
		}
		
		if (!this.getPresupuesto().getSucursalDestino().sosSucursal(this.getSucursalDestino().getNombre())){
			System.out.println ("DETECTO CAMBIO DE SUCURSAL");
			punitorio = (float) (punitorio + (this.getImporte()*0.2));
		}
		
		
		this.setPunitorio(punitorio);
	}

	public ContratoAlquilerDTO crearVista() {
		return new ContratoAlquilerDTO(this.numero, this.fechaInicio,
				this.fechaFin, this.fechaEmision, this.importe, this.punitorio,
				this.sucursalDestino != null ? this.sucursalDestino.getNombre()
						: "", this.presupuesto.crearVista());
	}

	// Getters and Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public PresupuestoAlquiler getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(PresupuestoAlquiler presupuesto) {
		this.presupuesto = presupuesto;
	}

	public float getPunitorio() {
		return punitorio;
	}

	public void setPunitorio(float punitorio) {
		this.punitorio = punitorio;
	}
}