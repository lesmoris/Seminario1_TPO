package Helpers;

import java.util.ArrayList;
import java.util.List;

public class HelperValoresFijos {

	private static List<String> tama�os;
	private static List<String> transmisiones;
	private static List<String> tiposDoc;
	private static List<String> colores;
	private static List<String> tiposComb;

	public HelperValoresFijos() {

		tama�os = new ArrayList<String>();
		transmisiones = new ArrayList<String>();
		tiposDoc = new ArrayList<String>();
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

	public static List<String> getTama�os() {
		return tama�os;
	}

	public static List<String> getTransmisiones() {
		return transmisiones;
	}

	public static List<String> getTiposDoc() {
		return tiposDoc;
	}

	public static List<String> getColores() {
		return colores;
	}

	public static List<String> getTiposComb() {
		return tiposComb;
	}

}
