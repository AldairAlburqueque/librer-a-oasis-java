package arreglos;

import java.io.*;
import clase.Cliente;
import java.util.ArrayList;

public class ArregloClientes {
	private ArrayList<Cliente> cli;
	
	public ArregloClientes() {
		cli = new ArrayList<Cliente>();
		cargarClientes();
	}
	
	public void adicionar(Cliente x) {
		cli.add(x);
		grabarClientes();
	}
	
	public int tamanio() {
		return cli.size();
	}
	
	public Cliente obtener(int i) {
		return cli.get(i);
	}
	
	public Cliente buscarCodigo(int codigo) {
	//	Cliente x;
		for (int i=0; i<tamanio(); i++) {
		//	x = obtener(i);
		//	if (x.getCodigoCliente() == codigo)
		//		return x;
			if(obtener(i).getCodigoCliente() == codigo)
				return obtener(i);
		}
		return null;
	}
	
	public Cliente buscarDni(String dni) {
		Cliente x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	
	public void eliminar(Cliente x) {
		cli.remove(x);
		grabarClientes();
	}
	
	public void actualizarArchivo() {
		grabarClientes();
	}
	
	private void grabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoCliente() + ";" +
					    x.getNombresApellidos() + ";" +
						x.getDni() + ";" +
						x.getTelefono() + ";" +
						x.getDireccion();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	private void cargarClientes() {
		try {
			BufferedReader br;
			String linea, nombre, dni;
			String[] s;
			int codigo;
			String direccion, telefono;
			br = new BufferedReader(new FileReader("clientes.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				dni = s[2].trim();
				telefono = s[3].trim();
				direccion = s[4].trim();
				adicionar(new Cliente(codigo, nombre, dni, telefono, direccion));
			}
			br.close();
		}
		catch (Exception e) {
		}	
	}
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio()-1).getCodigoCliente() + 1;		
	}
}
