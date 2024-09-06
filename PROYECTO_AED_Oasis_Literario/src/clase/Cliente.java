package clase;

public class Cliente {
	private int codigoCliente;
	private String nombresApellidos, dni, telefono, direccion;
	
	
	public Cliente(int codigoCliente, String nombresApellidos, String dni, String telefono, String direccion) {
		super();
		this.codigoCliente = codigoCliente;
		this.nombresApellidos = nombresApellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.direccion = direccion;
	}


	public int getCodigoCliente() {
		return codigoCliente;
	}


	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}


	public String getNombresApellidos() {
		return nombresApellidos;
	}


	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
