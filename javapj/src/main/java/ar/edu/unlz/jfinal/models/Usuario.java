package ar.edu.unlz.jfinal.models;

public class Usuario {

	private int id;
	private String nombre;
	private String clave;
	private String nick;
	private int acceso;
	private double dinero;

	public Usuario(String nombre, String clave, String nick,int acceso,double dinero) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.nick = nick;
		this.acceso = acceso;
		this.dinero = dinero;
	}

	public Usuario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	
	public int getAcceso() {
		return acceso;
	}

	public void setAcceso(int acceso) {
		this.acceso = acceso;
	}
	
	

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public boolean validarClave(String clave) {
		return this.clave.equals(clave);
	}

}
