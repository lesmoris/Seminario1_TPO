package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaMauveMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;

public class menuPrincipal extends JFrame {

	private JPanelConFondo contentPane;
	private static menuPrincipal instancia;
	private static menuPrincipal frameMnuPrincipal;
	private static String title = "Rent-A-Car";
	private static String separator = " - ";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
					frameMnuPrincipal = new menuPrincipal();
					frameMnuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuPrincipal() {

		instancia = this;

		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 668);

		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Agregamos Icono a la aplicacion
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.jpg"));
		setIconImage(icon);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frameMnuPrincipal.setTitle(title);

				irAMenuPrincipal();

			}
		});
		menuBar.add(btnInicio);

		JMenu mnNewMenu = new JMenu("Clientes");
		menuBar.add(mnNewMenu);

		final JMenuItem mntmAlta_1 = new JMenuItem("Alta de Cliente");
		mntmAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator + mntmAlta_1.getText());

				altaCliente a = new altaCliente();

				irAVentana(a);

			}

		});
		mnNewMenu.add(mntmAlta_1);

		final JMenuItem mntmModificacion = new JMenuItem("Modificar Cliente");
		mntmModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator + mntmModificacion.getText());

				modificarCliente a = new modificarCliente();

				irAVentana(a);

			}
		});
		mnNewMenu.add(mntmModificacion);

		final JMenuItem mntmBaja_1 = new JMenuItem("Baja de Cliente");
		mntmBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator + mntmBaja_1.getText());

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

				frameMnuPrincipal.setTitle(title + separator + mntmAlta.getText());

				altaVehiculo a = new altaVehiculo();

				irAVentana(a);

			}
		});

		final JMenuItem mntmVerVehiculos = new JMenuItem("Ver Vehiculos");
		mntmVerVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frameMnuPrincipal.setTitle(title + separator + mntmVerVehiculos.getText());

				verVehiculos a = new verVehiculos();

				irAVentana(a);

			}
		});
		mnVehiculos.add(mntmVerVehiculos);
		mnVehiculos.add(mntmAlta);

		final JMenuItem mntmBaja = new JMenuItem("Baja de Vehiculo");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator + mntmBaja.getText());
				bajaVehiculo a = new bajaVehiculo();

				irAVentana(a);

			}
		});

		final JMenuItem mntmModificarPrecioPor = new JMenuItem(
				"Modificar Precio por Dia");
		mntmModificarPrecioPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frameMnuPrincipal.setTitle(title + separator
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
				"Historial Mantenimientos efectuados por Vehiculo");
		mnMantenimiento.add(mntmHistorialMantenimientoPor);
		mntmHistorialMantenimientoPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator
						+ mntmHistorialMantenimientoPor.getText());

				generarReporteMantenimientoPorVehiculo a = new generarReporteMantenimientoPorVehiculo();

				irAVentana(a);

			}
		});
		mntmCerrarMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator
						+ mntmCerrarMantenimiento.getText());

				cerrarMantenimiento a = new cerrarMantenimiento();

				irAVentana(a);

			}
		});
		mntmSolicitudMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator
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

				frameMnuPrincipal.setTitle(title + separator
						+ mntmRecibirVehiculo.getText());

				recibirVehiculoenMovimiento a = new recibirVehiculoenMovimiento();

				irAVentana(a);

			}
		});
		mntmMoverVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator + mntmMoverVehiculo.getText());

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

				frameMnuPrincipal.setTitle(title + separator
						+ mntmGenerarPresupuesto.getText());

				generarPresupuesto a = new generarPresupuesto();

				irAVentana(a);

			}
		});
		mnAlquileres.add(mntmGenerarPresupuesto);

		final JMenuItem mntmNuevoAlquiler = new JMenuItem("Nuevo Alquiler");
		mntmNuevoAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator + mntmNuevoAlquiler.getText());

				nuevoContratoAlquiler a = new nuevoContratoAlquiler();

				irAVentana(a);

			}
		});
		mnAlquileres.add(mntmNuevoAlquiler);

		final JMenuItem mntmCerrarAlquiler = new JMenuItem("Cerrar Alquiler");
		mntmCerrarAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator + mntmCerrarAlquiler.getText());

				cierreAlquiler a = new cierreAlquiler();

				irAVentana(a);

			}
		});
		mnAlquileres.add(mntmCerrarAlquiler);
		
		JMenuItem mntmReabrirAlquiler = new JMenuItem("Reabrir Alquiler");
		mntmReabrirAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frameMnuPrincipal.setTitle(title + separator + mntmReabrirAlquiler.getText());

				ReabrirContrato a = new ReabrirContrato();

				irAVentana(a);

				
				
			}
		});
		mnAlquileres.add(mntmReabrirAlquiler);

		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		final JMenuItem mntmAlquileres = new JMenuItem("Reporte de Alquileres");
		mntmAlquileres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator + mntmAlquileres.getText());

				generarReporteAlquileres a = new generarReporteAlquileres();

				irAVentana(a);

			}
		});
		mnReportes.add(mntmAlquileres);

		final JMenuItem mntmMovimientoVehiculos = new JMenuItem(
				"Reporte de Movimiento de Vehiculos Entre Sucursales");
		mntmMovimientoVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameMnuPrincipal.setTitle(title + separator
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

				frameMnuPrincipal.setTitle(title + separator
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
		
		JMenu mnSkins = new JMenu("Skins");
		menuBar.add(mnSkins);

		JMenuItem mntmPlain = new JMenuItem("Plain");
		mntmPlain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmPlain);
		
		JMenuItem mntmAluoxide = new JMenuItem("AluOxide");
		mntmAluoxide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmAluoxide);
		
		JMenuItem mntmBlackeye = new JMenuItem("BlackEye");
		mntmBlackeye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmBlackeye);
		
		JMenuItem mntmBlackmoon = new JMenuItem("BlackMoon");
		mntmBlackmoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmBlackmoon);
		
		JMenuItem mntmBlackstar = new JMenuItem("BlackStar");
		mntmBlackstar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmBlackstar);
		
		JMenuItem mntmBluelce = new JMenuItem("BlueIce");
		mntmBluelce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmBluelce);
		
		JMenuItem mntmBluelight = new JMenuItem("BlueLight");
		mntmBluelight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmBluelight);
		
		JMenuItem mntmBluemoon = new JMenuItem("BlueMoon");
		mntmBluemoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmBluemoon);
		
		JMenuItem mntmBluesteel = new JMenuItem("BlueSteel");
		mntmBluesteel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmBluesteel);
		
		JMenuItem mntmGreendream = new JMenuItem("GreenDream");
		mntmGreendream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaGreenDreamLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmGreendream);
		
		JMenuItem mntmMauvemetallic = new JMenuItem("MauveMetallic");
		mntmMauvemetallic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaMauveMetallicLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmMauvemetallic);
		
		JMenuItem mntmOrangemetallic = new JMenuItem("OrangeMetallic");
		mntmOrangemetallic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmOrangemetallic);
		
		JMenuItem mntmSilvermoon = new JMenuItem("SilverMoon");
		mntmSilvermoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmSilvermoon);
		
		JMenuItem mntmSimpled = new JMenuItem("Simple2D");
		mntmSimpled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmSimpled);
		
		JMenuItem mntmSkymetallic = new JMenuItem("SkyMetallic");
		mntmSkymetallic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmSkymetallic);
		
		JMenuItem mntmWhitevision = new JMenuItem("WhiteVision");
		mntmWhitevision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
					SwingUtilities.updateComponentTreeUI(frameMnuPrincipal);
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnSkins.add(mntmWhitevision);

		menuBar.add(btnSalir);

		Image fondopantalla = new ImageIcon(getClass().getResource(
				getRandomBackground())).getImage();

		contentPane = new JPanelConFondo(fondopantalla);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private String getRandomBackground() {
		String[] backgrounds = new String[5];

		backgrounds[0] = "/ImagenMenuPrincipal_2.png";
		backgrounds[1] = "/ImagenMenuPrincipal_3.jpg";
		backgrounds[2] = "/ImagenMenuPrincipal_4.jpg";
		backgrounds[3] = "/ImagenMenuPrincipal_5.jpg";
		backgrounds[4] = "/ImagenMenuPrincipal.jpg";

		Random rnd = new Random();
		int nextBackground = (int) (rnd.nextDouble() * 4);

		return backgrounds[nextBackground];
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

	public class JPanelConFondo extends JPanel {

		private Image imagen;

		public JPanelConFondo(Image imagenInicial) {
			if (imagenInicial != null) {
				imagen = imagenInicial;
			}
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

			setOpaque(false);
			super.paint(g);
		}

	}
}