package Helpers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class HelperDate {

	public static Date obtenerFechadeString(String fecha)
			throws java.text.ParseException {

		java.sql.Date sqlDate = null;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

			java.util.Date utilDate = formatter.parse(fecha);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return sqlDate;
	}

	public static String FormateaFechaDDMMYYYY(String vFecha) {
		String vDia, vMes, vAno;
		StringTokenizer tokens = new StringTokenizer(vFecha, "/");
		vDia = tokens.nextToken();
		vMes = tokens.nextToken();
		vAno = tokens.nextToken();
		return vAno + "/" + vMes + "/" + vDia;
	}

	public static String obtenerStringDeDate(Date fechaSQL) {

		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		String resultado = fecha.format(fechaSQL);

		return resultado;

	}
}
