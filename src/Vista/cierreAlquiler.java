package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class cierreAlquiler extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	
	public cierreAlquiler() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		menuPrincipal.getInstance().setTitle("RENT A CAR - Cerrar Alquiler");
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblCierreContrato = new JLabel("CIERRE CONTRATO ALQUILER");
		lblCierreContrato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCierreContrato.setBounds(216, 22, 285, 50);
		getContentPane().add(lblCierreContrato);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(10, 109, 100, 14);
		getContentPane().add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(146, 106, 60, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(10, 145, 114, 14);
		getContentPane().add(lblNumeroDocumento);
		
		textField = new JTextField();
		textField.setBounds(142, 142, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarContrato = new JButton("Buscar Contrato");
		btnBuscarContrato.setBounds(63, 201, 143, 23);
		getContentPane().add(btnBuscarContrato);
		
		JLabel lblContratosVigentes = new JLabel("Contratos Vigentes");
		lblContratosVigentes.setBounds(288, 109, 139, 14);
		getContentPane().add(lblContratosVigentes);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(421, 106, 164, 20);
		getContentPane().add(comboBox_1);
		
		JLabel lblFechaFinContrato = new JLabel("Fecha Fin Contrato");
		lblFechaFinContrato.setBounds(284, 180, 126, 14);
		getContentPane().add(lblFechaFinContrato);
		
		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(288, 226, 112, 14);
		getContentPane().add(lblSucursalDestino);
		
		textField_1 = new JTextField();
		textField_1.setBounds(415, 177, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(416, 223, 169, 20);
		getContentPane().add(comboBox_2);
		
		JButton btnFinalizarContrato = new JButton("Finalizar Contrato");
		btnFinalizarContrato.setBounds(271, 320, 139, 23);
		getContentPane().add(btnFinalizarContrato);

	}

}
