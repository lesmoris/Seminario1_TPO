package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import Helpers.HelperExcel;
import Interfaces.ResultadoOperacion;
import Interfaces.TMVerVehiculos;

public class verVehiculos extends JInternalFrame {

	private JTable vehiculosTABLA;
	private JScrollPane scrollPane;
	private Controlador controlador;

	public verVehiculos() {

		this.controlador = Controlador.getInstance();
		iniciarComponentes();

	}

	private void iniciarComponentes() {

		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 988, 480);
		getContentPane().add(scrollPane);

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		vehiculosTABLA = new JTable();
		scrollPane.setViewportView(vehiculosTABLA);

		TMVerVehiculos modelo = new TMVerVehiculos(controlador.getVehiculos());

		vehiculosTABLA.setModel(modelo);

		JButton btnExportarAExcel = new JButton("Exportar a Excel");
		btnExportarAExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ResultadoOperacion res = HelperExcel.crearExcel(vehiculosTABLA,
						"Vehiculos");

				if (!res.sosExitoso())
					// Recibo y muestro el resultado
					JOptionPane.showMessageDialog(null, res.getMessage(), res
							.sosExitoso() ? "Informacion" : "Error", res
							.sosExitoso() ? JOptionPane.INFORMATION_MESSAGE
							: JOptionPane.ERROR_MESSAGE);

			}
		});
		btnExportarAExcel.setBounds(856, 523, 142, 23);
		getContentPane().add(btnExportarAExcel);

	}
}
