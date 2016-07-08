package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;
	private static menuPrincipal instancia;
	private static menuPrincipal frame;
	private static String title = "Rent-A-Car";
	private static String separator = " - ";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
					frame = new menuPrincipal();
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

		setTitle(title);
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

				frame.setTitle(title);

				irAMenuPrincipal();

			}
		});
		menuBar.add(btnInicio);

		JMenu mnNewMenu = new JMenu("Clientes");
		menuBar.add(mnNewMenu);

		final JMenuItem mntmAlta_1 = new JMenuItem("Alta de Cliente");
		mntmAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator + mntmAlta_1.getText());

				altaCliente a = new altaCliente();

				irAVentana(a);

			}

		});
		mnNewMenu.add(mntmAlta_1);

		final JMenuItem mntmModificacion = new JMenuItem("Modificar Cliente");
		mntmModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator + mntmModificacion.getText());

				modificarCliente a = new modificarCliente();

				irAVentana(a);

			}
		});
		mnNewMenu.add(mntmModificacion);

		final JMenuItem mntmBaja_1 = new JMenuItem("Baja de Cliente");
		mntmBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator + mntmBaja_1.getText());

				bajaCliente a = new bajaCliente();

				irAVentana(a);

			}
		});
		mnNewMenu.add(mntmBaja_1);

		JMenu mnVehiculos = new JMenu("Vehiculos");
		menuBar.add(mnVehiculos);

		final JMenuItem mntmAlta = new JMenuItem("Alta de Vehiculo");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator + mntmAlta.getText());

				altaVehiculo a = new altaVehiculo();

				irAVentana(a);

			}
		});
		mnVehiculos.add(mntmAlta);

		final JMenuItem mntmBaja = new JMenuItem("Baja de Vehiculo");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator + mntmBaja.getText());
				bajaVehiculo a = new bajaVehiculo();

				irAVentana(a);

			}
		});

		final JMenuItem mntmModificarPrecioPor = new JMenuItem(
				"Modificar Precio por Dia");
		mntmModificarPrecioPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.setTitle(title + separator
						+ mntmModificarPrecioPor.getText());

				modificacionVehiculo a = new modificacionVehiculo();

				irAVentana(a);

			}
		});
		mnVehiculos.add(mntmModificarPrecioPor);
		mnVehiculos.add(mntmBaja);

		final JMenu mnMantenimiento = new JMenu("Mantenimientos");
		mnVehiculos.add(mnMantenimiento);

		final JMenuItem mntmSolicitudMantenimiento = new JMenuItem(
				"Solicitud Mantenimiento");
		mnMantenimiento.add(mntmSolicitudMantenimiento);

		final JMenuItem mntmCerrarMantenimiento = new JMenuItem(
				"Cerrar Mantenimiento\r\n");
		mnMantenimiento.add(mntmCerrarMantenimiento);

		final JMenuItem mntmHistorialMantenimientoPor = new JMenuItem(
				"Historial Mantenimientos por Vehiculo");
		mnMantenimiento.add(mntmHistorialMantenimientoPor);
		mntmHistorialMantenimientoPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator
						+ mntmHistorialMantenimientoPor.getText());

				generarReporteMantenimientoPorVehiculo a = new generarReporteMantenimientoPorVehiculo();

				irAVentana(a);

			}
		});
		mntmCerrarMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator
						+ mntmCerrarMantenimiento.getText());

				cerrarMantenimiento a = new cerrarMantenimiento();

				irAVentana(a);

			}
		});
		mntmSolicitudMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator
						+ mntmSolicitudMantenimiento.getText());

				solicitarMantenimiento a = new solicitarMantenimiento();

				irAVentana(a);

			}
		});

		JMenu mnMovimientosIntersucursal = new JMenu(
				"Movimientos Intersucursal");
		mnVehiculos.add(mnMovimientosIntersucursal);

		final JMenuItem mntmMoverVehiculo = new JMenuItem("Mover Vehiculo");
		mnMovimientosIntersucursal.add(mntmMoverVehiculo);

		final JMenuItem mntmRecibirVehiculo = new JMenuItem("Recibir Vehiculo");
		mnMovimientosIntersucursal.add(mntmRecibirVehiculo);
		mntmRecibirVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator
						+ mntmRecibirVehiculo.getText());

				recibirVehiculoenMovimiento a = new recibirVehiculoenMovimiento();

				irAVentana(a);

			}
		});
		mntmMoverVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator + mntmMoverVehiculo.getText());

				moverVehiculo a = new moverVehiculo();

				irAVentana(a);

			}
		});

		JMenu mnAlquileres = new JMenu("Alquileres");
		menuBar.add(mnAlquileres);

		final JMenuItem mntmGenerarPresupuesto = new JMenuItem(
				"Generar Presupuesto");
		mntmGenerarPresupuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator
						+ mntmGenerarPresupuesto.getText());

				generarPresupuesto a = new generarPresupuesto();

				irAVentana(a);

			}
		});
		mnAlquileres.add(mntmGenerarPresupuesto);

		final JMenuItem mntmNuevoAlquiler = new JMenuItem("Nuevo Alquiler");
		mntmNuevoAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator + mntmNuevoAlquiler.getText());

				nuevoContratoAlquiler a = new nuevoContratoAlquiler();

				irAVentana(a);

			}
		});
		mnAlquileres.add(mntmNuevoAlquiler);

		final JMenuItem mntmCerrarAlquiler = new JMenuItem("Cerrar Alquiler");
		mntmCerrarAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator + mntmCerrarAlquiler.getText());

				cierreAlquiler a = new cierreAlquiler();

				irAVentana(a);

			}
		});
		mnAlquileres.add(mntmCerrarAlquiler);

		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		final JMenuItem mntmAlquileres = new JMenuItem("Reporte de Alquileres");
		mntmAlquileres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator + mntmAlquileres.getText());

				generarReporteAlquileres a = new generarReporteAlquileres();

				irAVentana(a);

			}
		});
		mnReportes.add(mntmAlquileres);

		final JMenuItem mntmMovimientoVehiculos = new JMenuItem(
				"Reporte de Movimiento de Vehiculos Entre Sucursales");
		mntmMovimientoVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator
						+ mntmMovimientoVehiculos.getText());

				generarReporteMovimientoVehiculos a = new generarReporteMovimientoVehiculos();

				irAVentana(a);

			}
		});
		mnReportes.add(mntmMovimientoVehiculos);

		final JMenuItem mntmVehiculosEnMantenimiento = new JMenuItem(
				"Reporte de Vehiculos en Mantenimiento Por Sucursal");
		mntmVehiculosEnMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setTitle(title + separator
						+ mntmVehiculosEnMantenimiento.getText());

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

	}

	public void irAMenuPrincipal() {

		setContentPane(contentPane);
		contentPane.repaint();
		contentPane.setLayout(null);
		getContentPane().setVisible(true);

		setTitle(title);

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
