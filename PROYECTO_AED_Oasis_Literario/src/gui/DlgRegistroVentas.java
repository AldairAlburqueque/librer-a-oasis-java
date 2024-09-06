package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.Query;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloClientes;
import arreglos.ArregloProducto;
import arreglos.ArregloVentas;
import clase.Cliente;
import clase.Producto;
import clase.Venta;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class DlgRegistroVentas extends JDialog implements ActionListener, ItemListener {

    private final JPanel contentPanel = new JPanel();

    private ArregloClientes arregloClientes = new ArregloClientes();
    private ArregloProducto arregloProductos = new ArregloProducto();
    private ArregloVentas arregloVentas = new ArregloVentas(arregloClientes, arregloProductos);

    private DefaultTableModel modelo;
    private JTextField txtCodVenta;
    private JTextField txtFecha;
    private JTextField txtCantidad;
    private JButton btnVenta;
    private JTextField txtNombreProducto;
    private JTable tblVenta;
    private JButton btnAceptar;
    private JLabel lblNombreCliente;
    private JTextField txtNombreCliente;
    private JComboBox<Integer> cboCodigoProducto;
    private JComboBox<Integer> cboCodigoCliente;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DlgRegistroVentas dialog = new DlgRegistroVentas();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DlgRegistroVentas() {
        setTitle("Boleta de Venta");
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Código de Venta:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(20, 20, 120, 20);
        contentPanel.add(lblNewLabel);

        txtCodVenta = new JTextField();
        txtCodVenta.setEditable(false);
        txtCodVenta.setBounds(150, 20, 100, 20);
        contentPanel.add(txtCodVenta);
        txtCodVenta.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblFecha.setBounds(305, 20, 60, 20);
        contentPanel.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(435, 21, 184, 20);
        contentPanel.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblCodProducto = new JLabel("Código de Producto:");
        lblCodProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCodProducto.setBounds(20, 51, 140, 20);
        contentPanel.add(lblCodProducto);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCantidad.setBounds(20, 82, 80, 20);
        contentPanel.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(150, 83, 100, 20);
        contentPanel.add(txtCantidad);
        txtCantidad.setColumns(10);

        JLabel lblCodCliente = new JLabel("Código de Cliente:");
        lblCodCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCodCliente.setBounds(20, 113, 120, 20);
        contentPanel.add(lblCodCliente);

        btnVenta = new JButton("Realizar Venta");
        btnVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnVenta.setBounds(630, 15, 130, 30);
        btnVenta.addActionListener(this);
        contentPanel.add(btnVenta);

        JLabel lblNomProducto = new JLabel("Nombre Producto:");
        lblNomProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNomProducto.setBounds(305, 51, 130, 20);
        contentPanel.add(lblNomProducto);

        txtNombreProducto = new JTextField();
        txtNombreProducto.setEditable(false);
        txtNombreProducto.setBounds(435, 52, 184, 20);
        contentPanel.add(txtNombreProducto);
        txtNombreProducto.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 155, 740, 376);
        contentPanel.add(scrollPane);

        tblVenta = new JTable();
        scrollPane.setViewportView(tblVenta);

        modelo = new DefaultTableModel();
        modelo.addColumn("Código Venta");
        modelo.addColumn("Cliente");
        modelo.addColumn("Código Producto");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Subtotal");
        modelo.addColumn("IGV");
        modelo.addColumn("Total");
        modelo.addColumn("Fecha");
        tblVenta.setModel(modelo);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAceptar.setBounds(630, 46, 130, 30);
        contentPanel.add(btnAceptar);
        
        lblNombreCliente = new JLabel("Nombre Cliente");
        lblNombreCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNombreCliente.setBounds(305, 117, 130, 20);
        contentPanel.add(lblNombreCliente);
        
        txtNombreCliente = new JTextField();
        txtNombreCliente.setEditable(false);
        txtNombreCliente.setColumns(10);
        txtNombreCliente.setBounds(435, 114, 184, 20);
        contentPanel.add(txtNombreCliente);
        
        cboCodigoProducto = new JComboBox();
        cboCodigoProducto.addItemListener(this);
        cboCodigoProducto.setBounds(150, 51, 100, 22);
        contentPanel.add(cboCodigoProducto);
        
        cboCodigoCliente = new JComboBox();
        cboCodigoCliente.addItemListener(this);
        cboCodigoCliente.setBounds(150, 113, 100, 22);
        contentPanel.add(cboCodigoCliente);



        // Mostrar ventas al abrir el diálogo
        mostrarVentas();
    }


    // Método para manejar eventos de botones
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnAceptar) {
    		actionPerformedBtnAceptar(e);
    	}
    	
        if (e.getSource() == btnVenta) {
            actionPerformedBtnRealizarVenta(e);
        }
    }

    // Método para realizar una venta
    protected void actionPerformedBtnRealizarVenta(ActionEvent e) {
    	limpiarCamposVenta();
    	txtCodVenta.setText("" + arregloVentas.codigoCorrelativo());
    	
		listarCboProducto();
		cboCodigoProducto.setSelectedIndex(arregloProductos.tamanio()-1);
		cboCodigoProducto.requestFocus();

		listarCboCliente();
		cboCodigoCliente.setSelectedIndex(arregloClientes.tamanio()-1);
		cboCodigoCliente.requestFocus();


    }
    
	protected void itemStateChangedCboCodigoProducto(ItemEvent e) {
		int codigoProducto = leerCodigoProducto();
		Producto buscado = arregloProductos.buscarCodigo(codigoProducto);
		txtNombreProducto.setText(buscado.getNombreProducto());
	}
	protected void itemStateChangedCboCodigoCliente(ItemEvent e) {
		int codigoCliente = leerCodigoCliente();
		Cliente buscado = arregloClientes.buscarCodigo(codigoCliente);
		txtNombreCliente.setText(buscado.getNombresApellidos());
	}
	
	void listarCboProducto() {
		cboCodigoProducto.removeAllItems();
		for (int i = 0; i < arregloProductos.tamanio(); i++) {
			cboCodigoProducto.addItem(arregloProductos.obtener(i).getCodigoProducto());
		}
	}
	
	void listarCboCliente() {
		cboCodigoCliente.removeAllItems();
		for (int i = 0; i < arregloClientes.tamanio(); i++) {
			cboCodigoCliente.addItem(arregloClientes.obtener(i).getCodigoCliente());
		}
	}
	
	String leerNombreProducto() {
		return  txtNombreProducto.getText();
	}
	
	int leerCodigoProducto() {
		return Integer.parseInt(cboCodigoProducto.getSelectedItem().toString());
	}
	
	String leerNombreCliente() {
		return txtNombreCliente.getText();
	}
	
	int leerCodigoCliente() {
		return Integer.parseInt(cboCodigoCliente.getSelectedItem().toString());
	}
	

    // Método para mostrar un mensaje de error
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

    // Método para limpiar campos después de una venta
    private void limpiarCamposVenta() {
        txtCodVenta.setText("");
        txtNombreProducto.setText("");
        txtNombreCliente.setText("");
        txtCantidad.setText("");
        txtFecha.setText("");
        txtCodVenta.requestFocus(); // Coloca el foco en el campo de código de venta para la siguiente entrada
    }

    // Método para mostrar las ventas en la tabla
    private void mostrarVentas() {
        // Limpiar el modelo de la tabla antes de agregar nuevas filas
        modelo.setRowCount(0);

        // Agregar las ventas al modelo de la tabla
        for (int i = 0; i < arregloVentas.tamanio(); i++) {
            Venta venta = arregloVentas.obtener(i);
            Producto p = venta.getProducto();
            Object[] fila = {
                    venta.getCodigoVenta(),
                    venta.getCliente().getNombresApellidos(),
                    p.getCodigoProducto(),
                    p.getNombreProducto(),
                    venta.getCantidad(),
                    p.getPrecio(), 
                    venta.calcularSubtotal(),
	                venta.calcularIGV(),
	                venta.calcularTotal(),
	                venta.getFecha()
	                    
	            };
	           modelo.addRow(fila);
	        }
	        tblVenta.setModel(modelo);
	    }
	 
	 public int leerCodigo() {
			return Integer.parseInt(txtCodVenta.getText().trim());
		}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		 try {
	            // Obtener datos de los campos
	            int codVenta = arregloVentas.codigoCorrelativo();           
	            int codProducto = leerCodigoProducto();
	            int codCliente = leerCodigoCliente();
	            int cant = Integer.parseInt(txtCantidad.getText().trim());
	            String fecha = txtFecha.getText().trim();

	            // Validar que los códigos y la cantidad sean mayores a 0
	            if (codVenta > 0 && codCliente > 0 && cant > 0) {
	                Cliente cliente = arregloClientes.buscarCodigo(codCliente);
	                Producto producto = arregloProductos.buscarCodigo(codProducto);

	                if (cliente != null && producto != null) {
	                    // Verificar stock disponible
	                    if (producto.getStockActual() >= cant) {
	                        // Crear la venta
	                        Venta nuevaVenta = new Venta(codVenta, cliente, producto, cant, fecha);
	                        arregloVentas.adicionar(nuevaVenta);
	                        
	                        // Actualizar stock del producto
	                        producto.setStockActual(producto.getStockActual() - cant);
	                        mensaje("Venta exitosa");
	                        // Guardar los cambios en productos y ventas
	                        arregloProductos.actualizarArchivo();
	                        arregloVentas.actualizarArchivo();

	                        // Limpiar campos después de la venta
	                        limpiarCamposVenta();

	                        // Mostrar las ventas actualizadas en la tabla
	                        mostrarVentas();
	                    } else {
	                        mostrarError("Stock insuficiente para el producto seleccionado");
	                    }
	                } else {
	                    mostrarError("Cliente o Producto no encontrados");
	                }
	            } else {
	                mostrarError("Ingrese valores válidos para la venta");
	            }
	        } catch (NumberFormatException ex) {
	            mostrarError("Ingrese números válidos en los campos numéricos");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            mostrarError("Ocurrió un error al procesar la venta");
	        }
		

	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigoCliente) {
			itemStateChangedCboCodigoCliente(e);
		}
		if (e.getSource() == cboCodigoProducto) {
			itemStateChangedCboCodigoProducto(e);
		}
	}

	
	
	
	
	
	

}
