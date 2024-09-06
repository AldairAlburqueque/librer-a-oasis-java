package arreglos;

import java.io.*;
import java.util.ArrayList;

import clase.Venta;
import clase.Cliente;
import clase.Producto;

public class ArregloVentas {
    private ArrayList<Venta> ventas;
    private ArregloClientes arregloClientes;
    private ArregloProducto arregloProductos;

    public ArregloVentas(ArregloClientes arregloClientes, ArregloProducto arregloProductos) {
        this.ventas = new ArrayList<>();
        this.arregloClientes = arregloClientes;
        this.arregloProductos = arregloProductos;
        cargarVentas();
    }

    public void adicionar(Venta venta) {
        ventas.add(venta);
        grabarVentas();
    }

    public int tamanio() {
        return ventas.size();
    }

    public Venta obtener(int indice) {
        return ventas.get(indice);
    }
    
    public Venta buscarCodigo(int codigo) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodigoVenta() == codigo)
				return obtener(i);
		}
		return null;
	}
    

    public void eliminar(Venta venta) {
        ventas.remove(venta);
        grabarVentas();
    }

    public void actualizarArchivo() {
        grabarVentas();
    }

    private void grabarVentas() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("ventas.txt"))) {
            for (Venta venta : ventas) {
                pw.println(venta.getCodigoVenta() + ";" +
                		
                        venta.getCliente().getCodigoCliente() + ";" +
                        venta.getProducto().getCodigoProducto() + ";" +
                        venta.getCantidad() + ";" +
                        venta.getFecha());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarVentas() {
        try (BufferedReader br = new BufferedReader(new FileReader("ventas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                int codigoVenta = Integer.parseInt(datos[0].trim());
                int codigoCliente = Integer.parseInt(datos[1].trim());
                Cliente cliente = arregloClientes.buscarCodigo(codigoCliente);
                int codigoProducto = Integer.parseInt(datos[2].trim());
                Producto producto = arregloProductos.buscarCodigo(codigoProducto);
                int cantidad = Integer.parseInt(datos[3].trim());
                String fecha = datos[4].trim();

                if (cliente != null && producto != null) {
                    ventas.add(new Venta(codigoVenta, cliente, producto, cantidad, fecha));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int codigoCorrelativo() {
        if (tamanio() == 0)
            return 3001;
        else
            return obtener(tamanio() - 1).getCodigoVenta() + 1;
    }
}
