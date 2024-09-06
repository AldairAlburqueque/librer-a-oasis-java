package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloVentas;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Frm_principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnAlmacen;
	private JMenu mnReportes;
	private JMenuItem mntmSalir;
	private JMenuItem mntmMantenimientoCliente;
	private JMenuItem mntmMantenimientoProducto;
	private JMenuItem mntmMantenimientoBoletaVentas;
	private JMenuItem mntmAlmacenIngresarStock;
	private JMenuItem mntmReportesGeneralVentas;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_principal frame = new Frm_principal();
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
	public Frm_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 631);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnNewMenu.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnMantenimiento);
		
		mntmMantenimientoCliente = new JMenuItem("Cliente");
		mntmMantenimientoCliente.addActionListener(this);
		mntmMantenimientoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		mnMantenimiento.add(mntmMantenimientoCliente);
		
		mntmMantenimientoProducto = new JMenuItem("Producto");
		mntmMantenimientoProducto.addActionListener(this);
		mntmMantenimientoProducto.setHorizontalAlignment(SwingConstants.LEFT);
		mnMantenimiento.add(mntmMantenimientoProducto);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnVentas);
		
		mntmMantenimientoBoletaVentas = new JMenuItem("Boleta ventas");
		mntmMantenimientoBoletaVentas.addActionListener(this);
		mntmMantenimientoBoletaVentas.setHorizontalAlignment(SwingConstants.LEFT);
		mnVentas.add(mntmMantenimientoBoletaVentas);
		
		mnAlmacen = new JMenu("Almac\u00E9n");
		mnAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		mnAlmacen.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnAlmacen);
		
		mntmAlmacenIngresarStock = new JMenuItem("Ingresar stock");
		mntmAlmacenIngresarStock.addActionListener(this);
		mntmAlmacenIngresarStock.setHorizontalAlignment(SwingConstants.LEFT);
		mnAlmacen.add(mntmAlmacenIngresarStock);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setHorizontalAlignment(SwingConstants.CENTER);
		mnReportes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnReportes);
		
		mntmReportesGeneralVentas = new JMenuItem("Reporte General de ventas");
		mntmReportesGeneralVentas.addActionListener(this);
		mntmReportesGeneralVentas.setHorizontalAlignment(SwingConstants.LEFT);
		mnReportes.add(mntmReportesGeneralVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Natali\\Downloads\\imagen_frame_principal.jpg"));
		lblNewLabel.setBounds(0, 0, 997, 566);
		contentPane.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmReportesGeneralVentas) {
			actionPerformedMntmReportesGeneralVentas(e);
		}
		if (e.getSource() == mntmAlmacenIngresarStock) {
			actionPerformedMntmAlmacenIngresarStock(e);
		}
		if (e.getSource() == mntmMantenimientoBoletaVentas) {
			actionPerformedMntmMantenimientoBoletaVentas(e);
		}
		if (e.getSource() == mntmMantenimientoProducto) {
			actionPerformedMntmMantenimientoProducto(e);
		}
		if (e.getSource() == mntmMantenimientoCliente) {
			actionPerformedMntmMantenimientoCliente(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		int valor = JOptionPane.showOptionDialog(null, "¿Estás seguro que deseas cerrar el programa?","Confirmar",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No"}, null);
		if (valor == 0) System.exit(0);
	}
	protected void actionPerformedMntmMantenimientoCliente(ActionEvent e) {
		DlgMantenimientoCliente mantCliente = new DlgMantenimientoCliente();
		mantCliente.setModal(true);
		mantCliente.setLocationRelativeTo(this);
		mantCliente.setVisible(true);
	}
	protected void actionPerformedMntmMantenimientoProducto(ActionEvent e) {
		DlgMantenimientoProducto mantProducto = new DlgMantenimientoProducto();
		mantProducto.setModal(true);
		mantProducto.setLocationRelativeTo(this);
		mantProducto.setVisible(true);
	}
	protected void actionPerformedMntmMantenimientoBoletaVentas(ActionEvent e) {
		DlgRegistroVentas bolVenta = new DlgRegistroVentas();
		bolVenta.setModal(true);
		bolVenta.setLocationRelativeTo(this);
		bolVenta.setVisible(true);
	}
	protected void actionPerformedMntmAlmacenIngresarStock(ActionEvent e) {
		DlgIngresarStock ingreStock = new DlgIngresarStock();
		ingreStock.setModal(true);
		ingreStock.setLocationRelativeTo(this);
		ingreStock.setVisible(true);
	}
	protected void actionPerformedMntmReportesGeneralVentas(ActionEvent e) {
		DlgReporteGeneralVentas reporteGVentas = new DlgReporteGeneralVentas();
		reporteGVentas.setModal(true);
		reporteGVentas.setLocationRelativeTo(this);
		reporteGVentas.setVisible(true);
	}

}
