package ar.edu.unlz.jfinal.models;

import java.io.Serializable;

public class Producto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String descripcion; 
	private String nombre ;
	private Double precio; 
	private int stock;
	
	
	public Producto() {
		
	}
	
	public Producto(int id, String descripcion, String nombre, Double precio, int stock) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	} 
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}

