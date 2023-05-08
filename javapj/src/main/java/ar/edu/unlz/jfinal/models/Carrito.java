package ar.edu.unlz.jfinal.models;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    
    private List<Producto> productos;
    private double total;
    
    public Carrito(List<Producto> productos, double total) {
        this.productos = productos;
        this.total = total;
    }
    
    public Carrito() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
    
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }
}
