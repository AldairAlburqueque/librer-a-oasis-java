package clase;

public class Producto {
	private int codigoProducto, stockActual, stockMinimo, stockMaximo;
	private String nombreProducto;
	private double precio;
	
	
	public Producto(int codigoProducto, String nombreProducto, double precio, int stockActual, int stockMinimo, int stockMaximo) {
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
	}


	public int getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public int getStockActual() {
		return stockActual;
	}


	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}


	public int getStockMinimo() {
		return stockMinimo;
	}


	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}


	public int getStockMaximo() {
		return stockMaximo;
	}


	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
