package Helpers;

import java.util.ArrayList;
import java.util.List;

public class HelperValoresFijos {

	private List<String> tama�os;
	private List<String> transmisiones;
	private List<String> tiposDoc;
	private List<String> colores;
	private List<String> tiposComb;
	private static HelperValoresFijos instancia;
	
	public HelperValoresFijos(){
		
		tama�os = new ArrayList<String>();
		transmisiones = new ArrayList<String>();
		tiposDoc  = new ArrayList<String>();
		colores = new ArrayList<String>();
		tiposComb = new ArrayList<String>();
		
		tama�os.add("CHICO");
		tama�os.add("MEDIANO");
		tama�os.add("GRANDE");
		
		transmisiones.add("MANUAL");
		transmisiones.add("AUTOMATICA");
		
		tiposDoc.add("DNI");
		tiposDoc.add("CUIT");
		tiposDoc.add("CUIL");
		
		colores.add("BLANCO");
		colores.add("NEGRO");
		colores.add("ROJO");
		colores.add("VERDE");
		colores.add("AZUL");
		colores.add("GRIS");
		colores.add("AMARILLO");
		colores.add("CELESTE");
		colores.add("BORDO");
		
		tiposComb.add("GNC");
		tiposComb.add("NAFTA");
		tiposComb.add("GASOIL");
		
		
	}

	public static HelperValoresFijos getInstance(){
		
		if (instancia == null)
			instancia = new HelperValoresFijos();
		
		return instancia;
	}
	

	public List<String> getTama�os() {
		return tama�os;
	}


	public void setTama�os(List<String> tama�os) {
		this.tama�os = tama�os;
	}


	public List<String> getTransmisiones() {
		return transmisiones;
	}


	public void setTransmisiones(List<String> transmisiones) {
		this.transmisiones = transmisiones;
	}


	public List<String> getTiposDoc() {
		return tiposDoc;
	}


	public void setTiposDoc(List<String> tiposDoc) {
		this.tiposDoc = tiposDoc;
	}

	public List<String> getColores() {
		return colores;
	}

	public void setColores(List<String> colores) {
		this.colores = colores;
	}

	public List<String> getTiposComb() {
		return tiposComb;
	}

	public void setTiposComb(List<String> tiposComb) {
		this.tiposComb = tiposComb;
	}
	
	
	
	
}
