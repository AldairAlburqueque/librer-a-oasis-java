package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloProducto;
import clase.Producto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgMantenimientoProducto extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoProducto;
	private JLabel lblCdigo;
	private JLabel lblNombreProducto;
	private JLabel lblPrecio;
	private JLabel lblStockActual;
	private JLabel lblStockMinimo;
	private JTextField txtStockMinimo;
	private JButton btnOk;
	private JTextField txtStockActual;
	private JTextField txtPrecio;
	private JTextField txtNombreProducto;
	private JButton btnBuscar;
	private JButton btnOpciones;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblStockMaximo;
	private JTextField txtStockMaximo;
	private JScrollPane scrollPane;
	private JTable tblMantenimientoProducto;
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
			DlgMantenimientoProducto dialog = new DlgMantenimientoProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMantenimientoProducto() {
		setTitle("Mantenimieto | Productos");
		setBounds(100, 100, 887, 606);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoProducto.setEditable(false);
		txtCodigoProducto.setColumns(10);
		txtCodigoProducto.setBounds(120, 14, 101, 20);
		contentPanel.add(txtCodigoProducto);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblCdigo.setBounds(10, 20, 68, 14);
		contentPanel.add(lblCdigo);
		
		lblNombreProducto = new JLabel("Nombre");
		lblNombreProducto.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblNombreProducto.setBounds(10, 45, 68, 14);
		contentPanel.add(lblNombreProducto);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblPrecio.setBounds(10, 69, 68, 14);
		contentPanel.add(lblPrecio);
		
		lblStockActual = new JLabel("Stock actual");
		lblStockActual.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblStockActual.setBounds(10, 94, 101, 14);
		contentPanel.add(lblStockActual);
		
		lblStockMinimo = new JLabel("Stock m\u00EDnimo");
		lblStockMinimo.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblStockMinimo.setBounds(10, 119, 101, 14);
		contentPanel.add(lblStockMinimo);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setHorizontalAlignment(SwingConstants.LEFT);
		txtStockMinimo.setEditable(false);
		txtStockMinimo.setColumns(10);
		txtStockMinimo.setBounds(120, 116, 101, 20);
		contentPanel.add(txtStockMinimo);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOk.setBounds(242, 139, 89, 23);
		contentPanel.add(btnOk);
		
		txtStockActual = new JTextField();
		txtStockActual.setHorizontalAlignment(SwingConstants.LEFT);
		txtStockActual.setEditable(false);
		txtStockActual.setColumns(10);
		txtStockActual.setBounds(120, 91, 101, 20);
		contentPanel.add(txtStockActual);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(120, 66, 101, 20);
		contentPanel.add(txtPrecio);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombreProducto.setEditable(false);
		txtNombreProducto.setColumns(10);
		txtNombreProducto.setBounds(120, 39, 200, 20);
		contentPanel.add(txtNombreProducto);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(231, 11, 89, 23);
		contentPanel.add(btnBuscar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(598, 16, 89, 92);
		contentPanel.add(btnOpciones);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionar.setEnabled(true);
		btnAdicionar.setBounds(715, 16, 111, 23);
		contentPanel.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setEnabled(true);
		btnConsultar.setBounds(715, 41, 111, 23);
		contentPanel.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setEnabled(true);
		btnModificar.setBounds(715, 65, 111, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setEnabled(true);
		btnEliminar.setBounds(715, 90, 111, 23);
		contentPanel.add(btnEliminar);
		
		lblStockMaximo = new JLabel("Stock m\u00E1ximo");
		lblStockMaximo.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblStockMaximo.setBounds(10, 144, 101, 14);
		contentPanel.add(lblStockMaximo);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setHorizontalAlignment(SwingConstants.LEFT);
		txtStockMaximo.setEditable(false);
		txtStockMaximo.setColumns(10);
		txtStockMaximo.setBounds(120, 141, 101, 20);
		contentPanel.add(txtStockMaximo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 851, 349);
		contentPanel.add(scrollPane);
		
		tblMantenimientoProducto = new JTable();
		scrollPane.setViewportView(tblMantenimientoProducto);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("PRECIO");
		modelo.addColumn("STOCK ACTUAL");
		modelo.addColumn("STOCK MINIMO");
		modelo.addColumn("STOCK MÁXIMO");
		
		tblMantenimientoProducto.setModel(modelo);
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
		//DECLARACION GLOBAL DEL OBJETO PRODUCTO
		ArregloProducto ap = new ArregloProducto();
		
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarProducto();
	}
	protected void actionPerformedBtnOk(ActionEvent e) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarProducto();
			break;
		case CONSULTAR:
			consultarProducto();
			break;
		case MODIFICAR:
			modificarProducto();
			break;
		case ELIMINAR:
			eliminarProducto();
	}
	}
	protected void actionPerformedBtnOpciones(ActionEvent e) {
		txtCodigoProducto.setText("");
		txtNombreProducto.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMinimo.setText("");
		txtStockMaximo.setText("");
		txtCodigoProducto.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		txtCodigoProducto.setText("" + ap.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombreProducto.requestFocus();
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		txtCodigoProducto.setEditable(true);
		habilitarBotones(false);
		txtCodigoProducto.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		txtCodigoProducto.setEditable(true);
		txtPrecio.setEditable(true);
		habilitarBotones(false);
		txtCodigoProducto.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		txtCodigoProducto.setEditable(true);
		habilitarBotones(false);
		txtCodigoProducto.requestFocus();
	}
	
	//  Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblMantenimientoProducto.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(8));  // precio
		tcm.getColumn(3).setPreferredWidth(anchoColumna(8));  // stock actual
		tcm.getColumn(4).setPreferredWidth(anchoColumna(8));  // stock minimo
		tcm.getColumn(5).setPreferredWidth(anchoColumna(8));  // stock maximo
		
	}
	
	void listar() {
		Producto x;
		modelo.setRowCount(0);
		for (int i=0; i< ap.tamanio(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCodigoProducto(),
					          x.getNombreProducto(),
					          x.getPrecio(),
					          x.getStockActual(),
					          x.getStockMinimo(),
					          x.getStockMaximo()};
			modelo.addRow(fila);
		}
		tblMantenimientoProducto.setModel(modelo);
	}
	
	void adicionarProducto() {
		int codigo = leerCodigoProducto();
		String nombre = leerNombreProducto();
		if (nombre.length() > 0) {
			double precio = leerPrecio();
					try {
						int stockActual = leerStockActual();
						try {
							int stockMinimo = leerStockMinimo();;
							try {
								int stockMaximo = leerStockMaximo();
								Producto nueva = new Producto(codigo, nombre, precio, stockActual, stockMinimo, stockMaximo);
								ap.adicionar(nueva);
								listar();
								txtCodigoProducto.setText("" + ap.codigoCorrelativo());
								txtNombreProducto.setText("");
								txtPrecio.setText("");
								txtStockActual.setText("");
								txtStockMinimo.setText("");
								txtStockMaximo.setText("");		
								txtNombreProducto.requestFocus();	
							} catch (Exception e) {
								error("Ingrese un número válido", txtStockMaximo);
							}

						}
						catch (Exception e) {
							error("Ingrese un número correcto", txtStockMinimo);
						}
					}
					catch (Exception e) {
						error("Ingrese un número correcto", txtStockActual);
					}
			}
			else
				error("Ingrese NOMBRE correcto", txtNombreProducto);
	}
	
	void consultarProducto() {
		try {
			int codigo = leerCodigoProducto();
			Producto x = ap.buscarCodigo(codigo);
			if (x != null) {
				txtNombreProducto.setText(x.getNombreProducto());
				txtPrecio.setText(""+ x.getPrecio());
				txtStockActual.setText("" + x.getStockActual());
				txtStockMinimo.setText("" + x.getStockMinimo());
				txtStockMaximo.setText("" + x.getStockMaximo());

				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodigoProducto.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
					txtNombreProducto.requestFocus();
				}
				if (tipoOperacion == ELIMINAR) {
					txtCodigoProducto.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodigoProducto);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigoProducto);
		}
	}
	void modificarProducto() {
	    try {
	        int codigo = leerCodigoProducto();
	        Producto x = ap.buscarCodigo(codigo);
	        if (x != null) {
	            String nombre = leerNombreProducto();
	            if (nombre.length() > 0) {
	                try {
	                    double precio = leerPrecio();
	                    try {
	                        int stockActual = leerStockActual();
	                        try {
	                            int stockMinimo = leerStockMinimo();
	                            int stockMaximo = leerStockMaximo();
	                            x.setNombreProducto(nombre);
	                            x.setPrecio(precio);
	                            x.setStockActual(stockActual);
	                            x.setStockMinimo(stockMinimo);
	                            x.setStockMaximo(stockMaximo);
	                            ap.actualizarArchivo();
	                            listar();
	                            txtNombreProducto.requestFocus();
	                        } catch (Exception e) {
	                            error("Ingrese un número válido", txtStockMinimo);
	                        }
	                    } catch (Exception e) {
	                        error("Ingrese un número válido", txtStockActual);
	                    }
	                } catch (Exception e) {
	                    error("Ingrese un número válido", txtPrecio);
	                }
	            } else {
	                error("Ingrese NOMBRE correcto", txtNombreProducto);
	            }
	        } else {
	            error("El código " + codigo + " no existe", txtCodigoProducto);
	        }
	    } catch (Exception e) {
	        error("Ingrese CÓDIGO correcto", txtCodigoProducto);
	    }
	}
	void eliminarProducto() {
		try {
			int codigo = leerCodigoProducto();
			Producto x = ap.buscarCodigo(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					ap.eliminar(x);
					listar();
					btnOk.setEnabled(false);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodigoProducto);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigoProducto);
		}	
	}
	//  Métodos tipo void (con parámetros)
	void habilitarEntradas(boolean sino) {
		txtNombreProducto.setEditable(sino);
		if (tipoOperacion == ADICIONAR)
			txtPrecio.setEditable(sino);
		txtStockActual.setEditable(sino);
		txtStockMinimo.setEditable(sino);
		txtStockMaximo.setEditable(sino);
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
	public int leerCodigoProducto() {
		return Integer.parseInt(txtCodigoProducto.getText().trim());
	}
	public String leerNombreProducto() {
		return txtNombreProducto.getText().trim();
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim()) ;
	}
	int leerStockActual() {
		return Integer.parseInt( txtStockActual.getText().trim());
	}
	int leerStockMinimo() {
		return Integer.parseInt( txtStockMinimo.getText().trim());
	}
	
	int leerStockMaximo() {
		return Integer.parseInt( txtStockMaximo.getText().trim());
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
