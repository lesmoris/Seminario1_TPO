package Vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;
	private static menuPrincipal instancia;

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

		// initComponents();

		instancia = this;

		setTitle("RENT A CAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);

		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnInicio = new JButton("Inicio");
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		btnInicio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				irAMenuPrincipal();

			}
		});
		menuBar.add(btnInicio);

		JMenu mnNewMenu = new JMenu("Clientes");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAlta_1 = new JMenuItem("Alta");
		mntmAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				altaCliente a = new altaCliente();

				irAVentana(a);

			}

		});
		mnNewMenu.add(mntmAlta_1);

		JMenuItem mntmModificacion = new JMenuItem("Modificacion");
		mntmModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modificarCliente a = new modificarCliente();

				irAVentana(a);

			}
		});
		mnNewMenu.add(mntmModificacion);

		JMenuItem mntmBaja_1 = new JMenuItem("Baja");
		mntmBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bajaCliente a = new bajaCliente();

				irAVentana(a);

			}
		});
		mnNewMenu.add(mntmBaja_1);

		JMenu mnVehiculos = new JMenu("Vehiculos");
		menuBar.add(mnVehiculos);

		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				altaVehiculo a = new altaVehiculo();

				irAVentana(a);

			}
		});
		mnVehiculos.add(mntmAlta);

		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bajaVehiculo a = new bajaVehiculo();

				irAVentana(a);

			}
		});

		JMenuItem mntmModificarPrecioPor = new JMenuItem(
				"Modificar Precio por Dia");
		mntmModificarPrecioPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				modificacionVehiculo a = new modificacionVehiculo();

				irAVentana(a);

			}
		});
		mnVehiculos.add(mntmModificarPrecioPor);
		mnVehiculos.add(mntmBaja);

		JMenu mnMantenimiento = new JMenu("Mantenimientos");
		mnVehiculos.add(mnMantenimiento);

		JMenuItem mntmSolicitudMantenimiento = new JMenuItem(
				"Solicitud Mantenimiento");
		mnMantenimiento.add(mntmSolicitudMantenimiento);

		JMenuItem mntmCerrarMantenimiento = new JMenuItem(
				"Cerrar Mantenimiento\r\n");
		mnMantenimiento.add(mntmCerrarMantenimiento);

		JMenuItem mntmHistorialMantenimientoPor = new JMenuItem(
				"Historial Mantenimientos por Vehiculo");
		mnMantenimiento.add(mntmHistorialMantenimientoPor);
		mntmHistorialMantenimientoPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				generarReporteMantenimientoPorVehiculo a = new generarReporteMantenimientoPorVehiculo();

				irAVentana(a);

			}
		});
		mntmCerrarMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cerrarMantenimiento a = new cerrarMantenimiento();

				irAVentana(a);

			}
		});
		mntmSolicitudMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				solicitarMantenimiento a = new solicitarMantenimiento();

				irAVentana(a);

			}
		});

		JMenu mnMovimientosIntersucursal = new JMenu(
				"Movimientos Intersucursal");
		mnVehiculos.add(mnMovimientosIntersucursal);

		JMenuItem mntmMoverVehiculo = new JMenuItem("Mover Vehiculo");
		mnMovimientosIntersucursal.add(mntmMoverVehiculo);

		JMenuItem mntmRecibirVehiculo = new JMenuItem("Recibir Vehiculo");
		mnMovimientosIntersucursal.add(mntmRecibirVehiculo);
		mntmRecibirVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				recibirVehiculoenMovimiento a = new recibirVehiculoenMovimiento();

				irAVentana(a);

			}
		});
		mntmMoverVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				moverVehiculo a = new moverVehiculo();

				irAVentana(a);

			}
		});

		JMenu mnAlquileres = new JMenu("Alquileres");
		menuBar.add(mnAlquileres);

		JMenuItem mntmGenerarPresupuesto = new JMenuItem("Generar Presupuesto");
		mntmGenerarPresupuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				generarPresupuesto a = new generarPresupuesto();

				irAVentana(a);

			}
		});
		mnAlquileres.add(mntmGenerarPresupuesto);

		JMenuItem mntmNuevoAlquiler = new JMenuItem("Nuevo Alquiler");
		mntmNuevoAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nuevoContratoAlquiler a = new nuevoContratoAlquiler();

				irAVentana(a);

			}
		});
		mnAlquileres.add(mntmNuevoAlquiler);

		JMenuItem mntmCerrarAlquiler = new JMenuItem("Cerrar Alquiler");
		mntmCerrarAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cierreAlquiler a = new cierreAlquiler();

				irAVentana(a);

			}
		});
		mnAlquileres.add(mntmCerrarAlquiler);

		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		JMenuItem mntmAlquileres = new JMenuItem("Alquileres");
		mntmAlquileres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				generarReporteAlquileres a = new generarReporteAlquileres();

				irAVentana(a);

			}
		});
		mnReportes.add(mntmAlquileres);

		JMenuItem mntmMovimientoVehiculos = new JMenuItem(
				"Movimiento de Vehiculos Entre Sucursales");
		mntmMovimientoVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				generarReporteMovimientoVehiculos a = new generarReporteMovimientoVehiculos();

				irAVentana(a);

			}
		});
		mnReportes.add(mntmMovimientoVehiculos);

		JMenuItem mntmVehiculosEnMantenimiento = new JMenuItem(
				"Vehiculos en Mantenimiento Por Sucursal");
		mntmVehiculosEnMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				generarReporteMantenimientosAbiertosPorSucursal a = new generarReporteMantenimientosAbiertosPorSucursal();

				irAVentana(a);

			}
		});
		mnReportes.add(mntmVehiculosEnMantenimiento);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Seguro desea salir del sistema?", "Alerta",
						dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {

					dispose();

				}

			}
		});
		menuBar.add(btnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRentACar = new JLabel("RENT A CAR");
		lblRentACar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblRentACar.setBounds(220, 106, 404, 79);
		contentPane.add(lblRentACar);
	}

	public void irAMenuPrincipal() {

		setContentPane(contentPane);
		contentPane.repaint();
		contentPane.setLayout(null);
		getContentPane().setVisible(true);

		setTitle("RENT A CAR");
		
	}

	public void irAVentana(JInternalFrame i) {

		setContentPane(i);
		i.getContentPane().setLayout(null);
		getContentPane().setVisible(true);
		getContentPane().repaint();

	}

	public static menuPrincipal getInstance() {

		if (instancia == null)
			instancia = new menuPrincipal();

		return instancia;

	}
}
