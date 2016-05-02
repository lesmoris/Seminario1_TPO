package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class nuevoContratoAlquiler extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevoContratoAlquiler frame = new nuevoContratoAlquiler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public nuevoContratoAlquiler() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNuevoContratoAlquiler = new JLabel("Nuevo Contrato Alquiler");
		lblNuevoContratoAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevoContratoAlquiler.setBounds(273, 11, 237, 56);
		getContentPane().add(lblNuevoContratoAlquiler);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(20, 104, 96, 14);
		getContentPane().add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(125, 101, 69, 20);
		getContentPane().add(comboBox);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(56, 69, 46, 14);
		getContentPane().add(lblCliente);
		
		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(20, 147, 110, 14);
		getContentPane().add(lblNumeroDocumento);
		
		textField = new JTextField();
		textField.setBounds(122, 144, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setBounds(54, 193, 110, 23);
		getContentPane().add(btnBuscarCliente);
		
		JLabel lblPresupuesto = new JLabel("PRESUPUESTO");
		lblPresupuesto.setBounds(464, 78, 86, 14);
		getContentPane().add(lblPresupuesto);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(398, 119, 136, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnGenerarContrato = new JButton("Generar Contrato");
		btnGenerarContrato.setBounds(413, 277, 121, 23);
		getContentPane().add(btnGenerarContrato);

	}

}
