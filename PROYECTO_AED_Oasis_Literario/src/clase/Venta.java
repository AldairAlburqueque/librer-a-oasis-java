package clase;

import arreglos.ArregloClientes;
import clase.Producto;

public class Venta {
	
	private int codigoVenta, cantidad;

	private Cliente cliente;
	private Producto producto;
	
	//private double precio;
	private String fecha;
	
	
	private static double igv = 0.18;
	
	public Venta( int cod, Cliente cli, Producto pro, int can,  String fech ) {
		codigoVenta = cod;
		cliente = cli;
		producto = pro;
		cantidad = can;
		fecha = fech;
		
	}
	
	public double calcularSubtotal() {
		return producto.getPrecio() * cantidad;
	}
	
	public double calcularIGV() {
	  return  calcularSubtotal() * igv;
	}
	
	public double calcularTotal() {
		return calcularSubtotal() + calcularIGV();
	}
	
	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	

	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getIgv() {
		return igv;
	}

}
