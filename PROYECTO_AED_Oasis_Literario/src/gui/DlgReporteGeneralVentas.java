package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import arreglos.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.text.DecimalFormat;

public class DlgReporteGeneralVentas extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnGenerarReporte;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	
	DecimalFormat df = new DecimalFormat("#,###.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporteGeneralVentas dialog = new DlgReporteGeneralVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteGeneralVentas() {
		setTitle("REPORTE GENERAL DE VENTAS");
		setBounds(100, 100, 512, 773);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnGenerarReporte = new JButton("Generar reporte");
		btnGenerarReporte.setFont(new Font("Ebrima", Font.BOLD, 14));
		btnGenerarReporte.addActionListener(this);
		btnGenerarReporte.setBounds(176, 11, 153, 23);
		contentPanel.add(btnGenerarReporte);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 476, 678);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Lucida Console", Font.BOLD, 12));
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerarReporte) {
			actionPerformedBtnGenerarReporte(e);
		}
	}

	//OBJETOS GLOBALES
	ArregloClientes ac = new ArregloClientes();
	ArregloProducto ap = new ArregloProducto();
	ArregloVentas av = new ArregloVentas(ac, ap);
	
	
	protected void actionPerformedBtnGenerarReporte(ActionEvent e) {
		
		txtS.setText("");

	for (int i = 0; i < av.tamanio(); i++) {
		imprimir(" Código de venta       :" + av.obtener(i).getCodigoVenta());
		imprimir(" Código de cliente     :" + ac.obtener(i).getCodigoCliente());
		imprimir(" Código de producto    :" + ap.obtener(i).getCodigoProducto());
		imprimir(" Fecha de atención     :" + av.obtener(i).getFecha());
		imprimir(" Subtotal de la compra :" + df.format(av.obtener(i).calcularSubtotal()));
		imprimir(" Impuesto IGV          :" + df.format(av.obtener(i).calcularIGV())) ;
		imprimir(" Importe total         :" + df.format(av.obtener(i).calcularTotal())) ;
		imprimir("\n");
		imprimir("=================================================");
		imprimir("\n");
 	}	
	}
	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
