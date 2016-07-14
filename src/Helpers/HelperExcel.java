package Helpers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import Interfaces.ResultadoOperacion;

public class HelperExcel {

	private static String rutaarchivo = System.getProperty("user.home")
			+ "/Rent_A_Car.xls";
	private static File archivoxls = new File(rutaarchivo);

	public static ResultadoOperacion crearExcel(JTable tabla, String titulo) {

		if (tabla.getRowCount() < 0)
			return new ResultadoOperacion(false, "La Tabla esta vacia");

		try {
			if (archivoxls.exists()) {
				archivoxls.delete();
				archivoxls.createNewFile();
			}
		} catch (IOException e) {
			return new ResultadoOperacion(false, "Error al exportar a Excel : "
					+ e.getMessage());
		}

		try {

			Workbook libro = new HSSFWorkbook();

			FileOutputStream archivo = new FileOutputStream(archivoxls);

			// Setearle nombre a la hoja
			org.apache.poi.ss.usermodel.Sheet hoja = libro
					.createSheet("INFORME");

			HSSFRow filatitulo = (HSSFRow) ((org.apache.poi.ss.usermodel.Sheet) hoja)
					.createRow(0);
			HSSFCell celdatitulo = filatitulo.createCell(4);
			celdatitulo.setCellValue(titulo);

			for (int i = 0; i < tabla.getRowCount(); i++) {
				HSSFRow fila = (HSSFRow) ((org.apache.poi.ss.usermodel.Sheet) hoja)
						.createRow(i + 3);
				if (i == 0) {
					// Llena los nombres de las columnas, los titulos
					for (int j = 0; j < tabla.getColumnCount(); j++) {
						HSSFCell celda = fila.createCell(j);
						celda.setCellValue(new HSSFRichTextString(tabla
								.getColumnModel().getColumn(j).getHeaderValue()
								.toString()));

					}
				} else {
					// Llena con los valores de la tabla
					for (int j = 0; j < tabla.getColumnCount(); j++) {
						HSSFCell celda = fila.createCell(j);
						if (tabla.getValueAt(i, j) != null)
							celda.setCellValue(new HSSFRichTextString(tabla
									.getValueAt(i - 1, j).toString()));

						hoja.autoSizeColumn(j);
					}

				}
			}
			int ultimafila = tabla.getRowCount() - 1;

			HSSFRow fila = (HSSFRow) ((org.apache.poi.ss.usermodel.Sheet) hoja)
					.createRow(tabla.getRowCount() + 3);
			for (int j = 0; j < tabla.getColumnCount(); j++) {
				HSSFCell celda = fila.createCell(j);
				// if(tabla.getValueAt(ultimafila, j)!=null)
				celda.setCellValue(new HSSFRichTextString(tabla.getValueAt(
						ultimafila, j).toString()));
				hoja.autoSizeColumn(j);
			}

			libro.write(archivo);

			archivo.close();

			Desktop.getDesktop().open(archivoxls);

		} catch (Exception ex) {
			return new ResultadoOperacion(false, "Error al exportar a Excel : "
					+ ex.getMessage());

		}

		return new ResultadoOperacion(true, "");

	}

}
