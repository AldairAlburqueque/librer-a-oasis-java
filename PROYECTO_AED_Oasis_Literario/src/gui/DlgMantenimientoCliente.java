package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloClientes;
import clase.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgMantenimientoCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblNombre_1;
	private JLabel lblDireccin;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JButton btnBuscar;
	private JButton btnOpciones;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnOk;
	private JScrollPane scrollPane;
	private JTable tblMantenimientoCliente;
	private DefaultTableModel modelo;
	
	//  Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;
	
	//  Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMantenimientoCliente dialog = new DlgMantenimientoCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMantenimientoCliente() {
		setTitle("Mantenimiento | Clientes");
		setBounds(100, 100, 910, 611);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 28, 68, 14);
		contentPanel.add(lblNewLabel);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblDni.setBounds(10, 77, 68, 14);
		contentPanel.add(lblDni);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblNombre.setBounds(10, 53, 68, 14);
		contentPanel.add(lblNombre);
		
		lblNombre_1 = new JLabel("Tel\u00E9fono");
		lblNombre_1.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblNombre_1.setBounds(10, 102, 68, 14);
		contentPanel.add(lblNombre_1);
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblDireccin.setBounds(10, 127, 68, 14);
		contentPanel.add(lblDireccin);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setBounds(88, 22, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 47, 200, 20);
		contentPanel.add(txtNombre);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(88, 74, 111, 20);
		contentPanel.add(txtDni);
		
		txtTelefono = new JTextField();
		txtTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(88, 99, 111, 20);
		contentPanel.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setHorizontalAlignment(SwingConstants.LEFT);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(88, 124, 200, 20);
		contentPanel.add(txtDireccion);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(199, 19, 89, 23);
		contentPanel.add(btnBuscar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOpciones.setBounds(598, 24, 89, 92);
		contentPanel.add(btnOpciones);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionar.setBounds(715, 24, 111, 23);
		contentPanel.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(715, 49, 111, 23);
		contentPanel.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBounds(715, 73, 111, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBounds(715, 98, 111, 23);
		contentPanel.add(btnEliminar);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOk.setBounds(313, 123, 89, 23);
		contentPanel.add(btnOk);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 874, 366);
		contentPanel.add(scrollPane);
		
		tblMantenimientoCliente = new JTable();
		scrollPane.setViewportView(tblMantenimientoCliente);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("DNI");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DIRECCION");
		tblMantenimientoCliente.setModel(modelo);
		listar();
		
		habilitarEntradas(false);
		habilitarBotones(true);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(e);
		}
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	
	//DECLARACION GLOBAL DEL OBJETO
	ArregloClientes cliente = new ArregloClientes();
	
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarCliente();
	}
	protected void actionPerformedBtnOk(ActionEvent e) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarCliente();
			break;
		case CONSULTAR:
			consultarCliente();
			break;
		case MODIFICAR:
			modificarCliente();
			break;
		case ELIMINAR:
			eliminarCliente();
	}
	}
	protected void actionPerformedBtnOpciones(ActionEvent e) {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		txtCodigo.setText("" + cliente.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	//  Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblMantenimientoCliente.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  // dni
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // telefono
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10));  // direccion
	}
	
	void listar() {
		Cliente x;
		modelo.setRowCount(0);
		for (int i=0; i<cliente.tamanio(); i++) {
			x = cliente.obtener(i);
			Object[] fila = { x.getCodigoCliente(),
					          x.getNombresApellidos(),
					          x.getDni(),
					          x.getTelefono(),
					          x.getDireccion()};
			modelo.addRow(fila);
		}
		tblMantenimientoCliente.setModel(modelo);
	}
	
	void adicionarCliente() {
		int codigo = leerCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String dni = leerDni();
			if (dni.length() > 0)
				if (cliente.buscarDni(dni)== null) 
					try {
						String telefono = leerTelefono();
						try {
							String direccion = leerDireccion();;
							Cliente nueva = new Cliente(codigo, nombre, dni, telefono, direccion);
							cliente.adicionar(nueva);
							listar();
							txtCodigo.setText("" + cliente.codigoCorrelativo());
							txtNombre.setText("");
							txtDni.setText("");
							txtTelefono.setText("");
							txtDireccion.setText("");
							txtNombre.requestFocus();
						}
						catch (Exception e) {
							error("Ingrese una Direccion correcta", txtDireccion);
						}
					}
					catch (Exception e) {
						error("Ingrese un número de teléfono correcto", txtTelefono);
					}
				else
					error("El DNI " + dni + " ya existe", txtDni);
			else
				error("Ingrese DNI correcto", txtDni);
		}
		else
			error("Ingrese NOMBRE correcto", txtNombre);
	}
	
	void consultarCliente() {
		try {
			int codigo = leerCodigo();
			Cliente x = cliente.buscarCodigo(codigo);
			if (x != null) {
				txtNombre.setText(x.getNombresApellidos());
				txtDni.setText(x.getDni());
				txtTelefono.setText("" + x.getTelefono());
				txtDireccion.setText("" + x.getDireccion());

				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
					txtNombre.requestFocus();
				}
				if (tipoOperacion == ELIMINAR) {
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodigo);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}
	void modificarCliente() {
		try {
			int codigo = leerCodigo();
			Cliente x = cliente.buscarCodigo(codigo);
			if (x != null) {
				String nombre = leerNombre();
				if (nombre.length() > 0)
					try {
						String telefono = leerTelefono();
						try {
							String direccion = leerDireccion();
							x.setNombresApellidos(nombre);
							x.setTelefono(telefono);
							x.setDireccion(direccion);
							cliente.actualizarArchivo();
							listar();
							txtNombre.requestFocus();
						}
						catch (Exception e) {
							error("Ingrese una dirección correcta", txtDireccion);
						}	
					}
					catch (Exception e) {
						error("Ingrese número de teléfono correcto", txtTelefono);
					}
				else
					error("Ingrese NOMBRE correcto", txtNombre);
			}
			else
				error("El código " + codigo + " no existe", txtCodigo);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}
	void eliminarCliente() {
		try {
			int codigo = leerCodigo();
			Cliente x = cliente.buscarCodigo(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					cliente.eliminar(x);
					listar();
					btnOk.setEnabled(false);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodigo);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}	
	}
	//  Métodos tipo void (con parámetros)
	void habilitarEntradas(boolean sino) {
		txtNombre.setEditable(sino);
		if (tipoOperacion == ADICIONAR)
			txtDni.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtDireccion.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		if (tipoOperacion == ADICIONAR)
			btnOk.setEnabled(!sino);
		else {
			btnBuscar.setEnabled(!sino);
			btnOk.setEnabled(false);
		}	
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);		
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	//  Métodos que retornan valor (sin parámetros)
	public int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	public String leerNombre() {
		return txtNombre.getText().trim();
	}
	String leerDni() {
		return txtDni.getText().trim();
	}
	String leerTelefono() {
		return txtTelefono.getText().trim();
	}
	String leerDireccion() {
		return txtDireccion.getText().trim();
	}
	//  Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	double ajustar(double numero) {
		return (int)(numero * 10) / 10.0;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}

}
