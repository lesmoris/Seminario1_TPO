package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
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
	public menuPrincipal() {
		setTitle("Rent-A-Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnInicio = new JButton("Inicio");
		menuBar.add(btnInicio);
		
		JMenu mnNewMenu = new JMenu("Clientes");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAlta_1 = new JMenuItem("Alta");
		mnNewMenu.add(mntmAlta_1);
		
		JMenuItem mntmModificacion = new JMenuItem("Modificacion");
		mnNewMenu.add(mntmModificacion);
		
		JMenuItem mntmBaja_1 = new JMenuItem("Baja");
		mnNewMenu.add(mntmBaja_1);
		
		JMenu mnVehiculos = new JMenu("Vehiculos");
		menuBar.add(mnVehiculos);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mnVehiculos.add(mntmAlta);
		
		JMenuItem mntmSolicitudMantenimiento = new JMenuItem("Solicitud Mantenimiento");
		mnVehiculos.add(mntmSolicitudMantenimiento);
		
		JMenuItem mntmCerrarMantenimiento = new JMenuItem("Cerrar Mantenimiento\r\n");
		mnVehiculos.add(mntmCerrarMantenimiento);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mnVehiculos.add(mntmBaja);
		
		JMenuItem mntmHistorialMantenimientoPor = new JMenuItem("Historial Mantenimiento");
		mnVehiculos.add(mntmHistorialMantenimientoPor);
		
		JMenuItem mntmMoverVehiculo = new JMenuItem("Mover Vehiculo");
		mnVehiculos.add(mntmMoverVehiculo);
		
		JMenuItem mntmRecibirVehiculo = new JMenuItem("Recibir Vehiculo");
		mnVehiculos.add(mntmRecibirVehiculo);
		
		JMenu mnAlquileres = new JMenu("Alquileres");
		menuBar.add(mnAlquileres);
		
		JMenuItem mntmGenerarPresupuesto = new JMenuItem("Generar Presupuesto");
		mnAlquileres.add(mntmGenerarPresupuesto);
		
		JMenuItem mntmNuevoAlquiler = new JMenuItem("Nuevo Alquiler");
		mnAlquileres.add(mntmNuevoAlquiler);
		
		JMenuItem mntmCerrarAlquiler = new JMenuItem("Cerrar Alquiler");
		mnAlquileres.add(mntmCerrarAlquiler);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenuItem mntmAlquileres = new JMenuItem("Alquileres");
		mnReportes.add(mntmAlquileres);
		
		JMenuItem mntmMovimientoVehiculos = new JMenuItem("Movimiento Vehiculos");
		mnReportes.add(mntmMovimientoVehiculos);
		
		JMenuItem mntmVehiculosEnMantenimiento = new JMenuItem("Vehiculos en Mantenimiento");
		mnReportes.add(mntmVehiculosEnMantenimiento);
		
		JButton btnSalir = new JButton("Salir");
		menuBar.add(btnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
