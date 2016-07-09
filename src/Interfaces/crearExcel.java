package Interfaces;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import Controlador.Controlador;

public class crearExcel {

	JTable tabla;
	
	String rutaarchivo = System.getProperty("user.home")+"/Rent_A_Car.xls";
	
	File archivoxls = new File (rutaarchivo);
	
	public crearExcel(JTable tabla){
		this.tabla=tabla;
	}
	
	
	@SuppressWarnings("resource")
	public void crearExcel () throws FileNotFoundException{
		
		 
		try {
		if (archivoxls.exists()){
			archivoxls.delete();
			
				archivoxls.createNewFile();
		}
		}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		Workbook libro = new HSSFWorkbook();
		
		try {
			FileOutputStream archivo = new FileOutputStream(archivoxls);
		
		
		// Setearle nombre a la hoja
		org.apache.poi.ss.usermodel.Sheet hoja = libro.createSheet("INFORME");
		
		
		for (int i = 0; i < tabla.getRowCount(); i++) {
            HSSFRow fila = (HSSFRow) ((org.apache.poi.ss.usermodel.Sheet) hoja).createRow(i);          
            if(i==0){
            	// Llena los nombres de las columnas, los titulos
                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    HSSFCell celda = fila.createCell(j);
                    celda.setCellValue(new HSSFRichTextString(tabla.getColumnModel().getColumn(j).getHeaderValue().toString()));
                }
            }else{
            	// Llena con los valores de la tabla
                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    HSSFCell celda = fila.createCell(j);
                    if(tabla.getValueAt(i, j)!=null)
                        celda.setCellValue(new HSSFRichTextString(tabla.getValueAt(i-1, j).toString()));
                }
                
            }
		}
		int ultimafila = tabla.getRowCount()-1;
		
		HSSFRow fila = (HSSFRow) ((org.apache.poi.ss.usermodel.Sheet) hoja).createRow(tabla.getRowCount());
		 for (int j = 0; j < tabla.getColumnCount(); j++) {
             HSSFCell celda = fila.createCell(j);
             if(tabla.getValueAt(ultimafila, j)!=null)
                 celda.setCellValue(new HSSFRichTextString(tabla.getValueAt(ultimafila, j).toString()));
         }
		
		libro.write(archivo);
		
		
		archivo.close();
		
		Desktop.getDesktop().open(archivoxls);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

