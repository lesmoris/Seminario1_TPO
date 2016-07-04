package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class nuevoContratoAlquiler extends JInternalFrame {
	private JTextField textField;

	
	public nuevoContratoAlquiler() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNuevoContratoAlquiler = new JLabel("Nuevo Contrato Alquiler");
		lblNuevoContratoAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevoContratoAlquiler.setBounds(273, 11, 237, 56);
		getContentPane().add(lblNuevoContratoAlquiler);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(20, 104, 118, 14);
		getContentPane().add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(166, 104, 69, 20);
		getContentPane().add(comboBox);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(56, 69, 69, 14);
		getContentPane().add(lblCliente);
		
		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(20, 147, 133, 14);
		getContentPane().add(lblNumeroDocumento);
		
		textField = new JTextField();
		textField.setBounds(163, 147, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setBounds(54, 193, 150, 23);
		getContentPane().add(btnBuscarCliente);
		
		JLabel lblPresupuesto = new JLabel("PRESUPUESTO");
		lblPresupuesto.setBounds(464, 78, 86, 14);
		getContentPane().add(lblPresupuesto);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(398, 119, 136, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnGenerarContrato = new JButton("Generar Contrato");
		btnGenerarContrato.setBounds(413, 277, 137, 23);
		getContentPane().add(btnGenerarContrato);

	}

}
