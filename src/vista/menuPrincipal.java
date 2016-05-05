package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;

	
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
		
//		initComponents();
		
		setTitle("Rent-A-Car");
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
		
		JMenuItem mntmSolicitudMantenimiento = new JMenuItem("Solicitud Mantenimiento");
		mntmSolicitudMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				solicitarMantenimiento a = new solicitarMantenimiento();
				
				irAVentana(a);
				
			}
		});
		mnVehiculos.add(mntmSolicitudMantenimiento);
		
		JMenuItem mntmCerrarMantenimiento = new JMenuItem("Cerrar Mantenimiento\r\n");
		mntmCerrarMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cerrarMantenimiento a = new cerrarMantenimiento();
				
				irAVentana(a);
				
			}
		});
		mnVehiculos.add(mntmCerrarMantenimiento);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				bajaVehiculo a = new bajaVehiculo();
				
				irAVentana(a);
				
			}
		});
		mnVehiculos.add(mntmBaja);
		
		JMenuItem mntmHistorialMantenimientoPor = new JMenuItem("Historial Mantenimiento");
		mntmHistorialMantenimientoPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generarReporteHistoricoMantenimientoVehiculo a = new generarReporteHistoricoMantenimientoVehiculo();
				
				irAVentana(a);
				
				
			}
		});
		mnVehiculos.add(mntmHistorialMantenimientoPor);
		
		JMenuItem mntmMoverVehiculo = new JMenuItem("Mover Vehiculo");
		mntmMoverVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				moverVehiculo a = new moverVehiculo();
				
				irAVentana(a);
				
				
			}
		});
		mnVehiculos.add(mntmMoverVehiculo);
		
		JMenuItem mntmRecibirVehiculo = new JMenuItem("Recibir Vehiculo");
		mntmRecibirVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				recibirVehiculoenMovimiento a = new recibirVehiculoenMovimiento();
				
				irAVentana(a);
				
			}
		});
		mnVehiculos.add(mntmRecibirVehiculo);
		
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
		
		JMenuItem mntmMovimientoVehiculos = new JMenuItem("Movimiento Vehiculos");
		mntmMovimientoVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generarReporteMovimientoVehiculos a = new generarReporteMovimientoVehiculos();
				
				irAVentana(a);
				
				
			}
		});
		mnReportes.add(mntmMovimientoVehiculos);
		
		JMenuItem mntmVehiculosEnMantenimiento = new JMenuItem("Vehiculos en Mantenimiento");
		mntmVehiculosEnMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generarReporteMantenimiento a = new generarReporteMantenimiento();
				
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
				int dialogResult = JOptionPane.showConfirmDialog(null, "Seguro desea salir del sistema?", "Alerta", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION){
				
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
	
	private void irAMenuPrincipal(){
		
		setContentPane(contentPane);
		contentPane.repaint();
		contentPane.setLayout(null);
		getContentPane().setVisible(true);
		
		
		
	}
	
	private void irAVentana(JInternalFrame i) {
		
		setContentPane(i);
		i.getContentPane().setLayout(null);
		getContentPane().setVisible(true);
		getContentPane().repaint();
		
		
	}
}
