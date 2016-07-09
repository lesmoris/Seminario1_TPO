package Helpers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

	public static Date obtenerFechaHoy() {

		java.sql.Date fechahoy = new java.sql.Date(Calendar.getInstance()
				.getTime().getTime());

		return fechahoy;
	}

	public static java.sql.Date ConvertirUtilASQL(java.util.Date fechainicial) {

		java.util.Calendar cal = Calendar.getInstance();
		java.util.Date utilDate = fechainicial;
		cal.setTime(utilDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
		System.out.println("utilDate:" + utilDate);
		System.out.println("sqlDate:" + sqlDate);

		return sqlDate;

	}

	public static java.util.Date ConvertirSQLAUtil(java.sql.Date fechainicial) {

		java.util.Date utilDate = new java.util.Date(fechainicial.getTime());

		return utilDate;
	}

	public static int diferenciaEntreDosfechas(java.util.Date fechaInicio,
			java.util.Date fechaFin) {

		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;

		int cantidadDias = (int) ((fechaInicio.getTime() - fechaFin.getTime()) / MILLSECS_PER_DAY);

		return cantidadDias;
	}

	public static int diferenciaEntreDosfechas(String fechaInicio,
			String fechaFin) throws java.text.ParseException {

		Date fechaInicioDate = obtenerFechadeString(fechaInicio);
		Date fechaFinDate = obtenerFechadeString(fechaFin);
		return diferenciaEntreDosfechas(fechaInicioDate, fechaFinDate);

	}

	public static int diferenciaEntreDosfechas(java.sql.Date fechaInicio,
			java.sql.Date fechaFin) {

		java.util.Date fechaInicioModificada = ConvertirSQLAUtil(fechaInicio);
		java.util.Date fechaFinModificada = ConvertirSQLAUtil(fechaFin);

		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;

		int cantidadDias = (int) ((fechaInicioModificada.getTime() - fechaFinModificada
				.getTime()) / MILLSECS_PER_DAY);

		return cantidadDias;
	}

	public static boolean esFechaValida(String fecha) {
		try {
			obtenerFechadeString(fecha);
			return true;
		} catch (java.text.ParseException e) {
			return false;
		}
	}

}
