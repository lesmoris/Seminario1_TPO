package Helpers;

import java.util.ArrayList;
import java.util.List;

public class HelperValoresFijos {

	private static List<String> tamaños;
	private static List<String> transmisiones;
	private static List<String> tiposDoc;
	private static List<String> colores;
	private static List<String> tiposComb;
	private static List<String> ac;

	public static List<String> getTamaños() {

		tamaños = new ArrayList<String>();
		tamaños.add("CHICO");
		tamaños.add("MEDIANO");
		tamaños.add("GRANDE");

		return tamaños;
	}

	public static List<String> getTransmisiones() {

		transmisiones = new ArrayList<String>();
		transmisiones.add("MANUAL");
		transmisiones.add("AUTOMATICA");

		return transmisiones;
	}

	public static List<String> getTiposDoc() {

		tiposDoc = new ArrayList<String>();
		tiposDoc.add("DNI");
		tiposDoc.add("CUIT");
		tiposDoc.add("CUIL");

		return tiposDoc;
	}

	public static List<String> getColores() {

		colores = new ArrayList<String>();
		colores.add("BLANCO");
		colores.add("NEGRO");
		colores.add("ROJO");
		colores.add("VERDE");
		colores.add("AZUL");
		colores.add("GRIS");
		colores.add("AMARILLO");
		colores.add("CELESTE");
		colores.add("BORDO");

		return colores;
	}

	public static List<String> getTiposComb() {

		tiposComb = new ArrayList<String>();
		tiposComb.add("GNC");
		tiposComb.add("NAFTA");
		tiposComb.add("GASOIL");

		return tiposComb;
	}

	public static List<String> getAireAcondicionado() {

		ac = new ArrayList<String>();
		ac.add("S");
		ac.add("N");

		return ac;
	}

}
