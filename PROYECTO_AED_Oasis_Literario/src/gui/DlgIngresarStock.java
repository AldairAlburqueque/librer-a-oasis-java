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
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import clase.Producto;
import arreglos.ArregloProducto;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgIngresarStock extends JDialog implements ItemListener, ActionListener {
	
	ArregloProducto ps = new ArregloProducto();


	private DefaultTableModel modelo;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblCantidad;
	private JTextField txtNomProducto;
	private JButton btnIngresarStock;
	private JLabel lblNombreProducto;
	private JTextField txtCantidadProducto;
	private JButton btnAceptarStock;
	private JComboBox<Integer> cboCodProducto;
	private JScrollPane scrollPane;
	private JTable tblStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgIngresarStock dialog = new DlgIngresarStock();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgIngresarStock() {
		setTitle("Almacen/IngresarStock");
		setBounds(100, 100, 614, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Codigo Producto :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 119, 14);
		contentPanel.add(lblNewLabel);
		
		lblCantidad = new JLabel("Cantidad           :");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(10, 73, 119, 14);
		contentPanel.add(lblCantidad);
		
		txtNomProducto = new JTextField();
		txtNomProducto.setEditable(false);
		txtNomProducto.setColumns(10);
		txtNomProducto.setBounds(133, 42, 187, 20);
		contentPanel.add(txtNomProducto);
		
		btnIngresarStock = new JButton("Ingresar Stock");
		btnIngresarStock.addActionListener(this);
		btnIngresarStock.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresarStock.setBounds(426, 8, 132, 23);
		contentPanel.add(btnIngresarStock);
		
		lblNombreProducto = new JLabel("Nombre Producto :");
		lblNombreProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreProducto.setBounds(10, 44, 119, 14);
		contentPanel.add(lblNombreProducto);
		
		txtCantidadProducto = new JTextField();
		txtCantidadProducto.setBounds(133, 73, 86, 20);
		contentPanel.add(txtCantidadProducto);
		txtCantidadProducto.setColumns(10);
		
		btnAceptarStock = new JButton("Aceptar");
		btnAceptarStock.addActionListener(this);
		btnAceptarStock.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptarStock.setBounds(426, 41, 132, 23);
		contentPanel.add(btnAceptarStock);
		
		cboCodProducto = new JComboBox<Integer>();
		cboCodProducto.addItemListener(this);
		cboCodProducto.setSelectedIndex(-1);
		cboCodProducto.setBounds(133, 8, 119, 22);
		contentPanel.add(cboCodProducto);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 578, 176);
		contentPanel.add(scrollPane);
		
		tblStock = new JTable();
		tblStock.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblStock);
		
		
		
		modelo = new DefaultTableModel();
        modelo.addColumn("Código de Libro");
        modelo.addColumn("Nombre del Libro");
        modelo.addColumn("Stock Actual");
        modelo.addColumn("Stock Minimo");
        modelo.addColumn("Stock maximo");
        tblStock.setModel(modelo);
        
        listar();
		
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
	

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodProducto) {
			itemStateChangedCboCodProducto(e);
		}
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptarStock) {
			actionPerformedBtnAceptarStock(e);
		}
		if (e.getSource() == btnIngresarStock) {
			actionPerformedBtnIngresarStock(e);
		}
	}
	
	protected void itemStateChangedCboCodProducto(ItemEvent e) {
		try {
			int codigoProducto = leerCodigoProducto();
			Producto buscado = ps.buscarCodigo(codigoProducto);
			txtNomProducto.setText(buscado.getNombreProducto());
			
		} catch (Exception e2) {
			
		}
	}
	

	protected void actionPerformedBtnIngresarStock(ActionEvent e) {	
		listarCboProducto();
		cboCodProducto.setSelectedIndex(ps.tamanio()-1);
		cboCodProducto.requestFocus();	
	}
	
	
	protected void actionPerformedBtnAceptarStock(ActionEvent e) {
		Producto x = ps.buscarCodigo(leerCodigoProducto());
		if(x.getStockActual() + leerCantidad() < x.getStockMaximo()) {
		x.setStockActual(x.getStockActual() + leerCantidad());
		mensaje("Stock aumentado correctamente");
		listar();
		ps.actualizarArchivo();
		}else 
			error("El stock no debe superar un máximo de" + x.getStockMaximo(), cboCodProducto);
			txtCantidadProducto.setText("");
			txtNomProducto.setText("");
			
	}
	
	void listar() {
		Producto x;
		modelo.setRowCount(0);
		for (int i=0; i< ps.tamanio(); i++) {
			x = ps.obtener(i);
			Object[] fila = { x.getCodigoProducto(),
					          x.getNombreProducto(),
					          x.getStockActual(),
					          x.getStockMinimo(),
					          x.getStockMaximo()};   
			
			modelo.addRow(fila);
		}
		tblStock.setModel(modelo);
	}
	
	
	void error(String s, JComboBox cbo) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	int obtenerStock(Producto x, int cantidad) {
		return x.getStockActual() + cantidad;
	}
	
	void listarCboProducto() {
		cboCodProducto.removeAllItems();
		for (int i = 0; i < ps.tamanio(); i++) {
			cboCodProducto.addItem(ps.obtener(i).getCodigoProducto());
		}
	}
	
	int leerCantidad() {
		return  Integer.parseInt(txtCantidadProducto.getText());
	}
	
	int leerCodigoProducto() {
		return Integer.parseInt(cboCodProducto.getSelectedItem().toString());
	}
	
}
