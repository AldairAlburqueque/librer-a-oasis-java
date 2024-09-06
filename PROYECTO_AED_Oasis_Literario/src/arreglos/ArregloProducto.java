package arreglos;
import java.io.*;
import clase.Producto;
import java.util.ArrayList;

public class ArregloProducto {
	private ArrayList<Producto> prod;
	
	public ArregloProducto() {
		prod = new ArrayList<Producto>();
		cargarProductos();
	}
	
	public void adicionar(Producto p) {
		prod.add(p);
		grabarProductos();
	}
	
	public int tamanio() {
		return prod.size();
	}
	
	public Producto obtener(int i) {
		return prod.get(i);
	}
	
	public Producto buscarCodigo(int codigo) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodigoProducto() == codigo)
				return obtener(i);
		}
		return null;
	}
	
	public Producto buscarNombre(String nombre) {
		Producto p;
		for (int i=0; i < tamanio();i++) {
			p = obtener(i);
			if(p.getNombreProducto().equals(nombre));
			return p;
		}
		return null;
	}
	///////////////
	public boolean verificarStock(Producto producto, int cantidad) {
        return producto.getStockActual() >= cantidad;
    }
	////////
	
	public void eliminar(Producto x) {
		prod.remove(x);
		grabarProductos();
	}
	
	public void actualizarArchivo() {
		grabarProductos();
	}
	
	private void grabarProductos() {
		try {
			PrintWriter pw;
			String linea;
			Producto p;
			pw = new PrintWriter(new FileWriter("productos.txt"));
			for (int i=0; i<tamanio(); i++) {
				p = obtener(i);
				linea = p.getCodigoProducto() + ";" +
					    p.getNombreProducto() + ";" +
						p.getPrecio() + ";" +
						p.getStockActual() + ";" +
						p.getStockMinimo() + ";" +
						p.getStockMaximo();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	private void cargarProductos() {
		try {
			BufferedReader br;
			String linea, nombre;
			String[] s;
			int codigo, stockAtual, stockMinimo, StockMaximo;
			double precio;
			br = new BufferedReader(new FileReader("productos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				precio = Double.parseDouble(s[2].trim()) ;
				stockAtual = Integer.parseInt(s[3].trim()) ;
				stockMinimo = Integer.parseInt( s[4].trim()) ;
				StockMaximo = Integer.parseInt( s[5].trim());
				
				adicionar(new Producto(codigo, nombre, precio, stockAtual, stockMinimo, StockMaximo));
			}
			br.close();
		}
		catch (Exception e) {
		}	
	}
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 2001;
		else
			return obtener(tamanio()-1).getCodigoProducto() + 1;		
	}
	
	
}
