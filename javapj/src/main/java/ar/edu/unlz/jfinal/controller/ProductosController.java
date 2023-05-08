package ar.edu.unlz.jfinal.controller;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ar.edu.unlz.jfinal.daos.ProductosDAO;
import ar.edu.unlz.jfinal.models.Producto;

@WebServlet("/productosC")
public class ProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductosDAO dao;

	public ProductosController() {
		dao = new ProductosDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var optAccion = Optional.ofNullable(request.getParameter("accion"));

		var accion = optAccion.orElse("index");

		switch (accion) {
		case "index" -> getIndex(request, response);
		case "crear" -> getCrear(request, response);
		case "editar" -> getEditar(request, response);
		case "indexcli" -> getIndexcli(request, response);

		default -> response.getWriter().print("Not found (GET)");
		}

	}

	private void getIndexcli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
var listado =dao.all();
		
		System.out.println(listado);
		request.setAttribute("productos", listado);
		
		var rd = request.getRequestDispatcher("vistas/productos/indexcliP.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    var optAccion = Optional.ofNullable(request.getParameter("accion"));

	    var accion = optAccion.orElse("");

	    switch (accion) {
	        case "insert" -> postInsert(request, response);
	        case "update" -> postUpdate(request, response);
	        case "delete" -> postDelete(request, response);
	        default -> response.getWriter().print("Not found (POST)");
	    }
	}

	private void getEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   int id = Integer.parseInt(request.getParameter("id"));
		    Producto producto = dao.getById(id);
		    request.setAttribute("producto", producto);
		    request.getRequestDispatcher("vistas/productos/editar.jsp").forward(request, response);	

	}	
	

	private void getCrear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var rd = request.getRequestDispatcher("vistas/productos/crear.jsp");
		rd.forward(request, response);
	}

	private void getIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var listado =dao.all();
		
		System.out.println(listado);
		request.setAttribute("productos", listado);
		
		var rd = request.getRequestDispatcher("vistas/productos/index.jsp");
		rd.forward(request, response);
	}

	private void postDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	
		  int id = Integer.parseInt(request.getParameter("id"));

		    ProductosDAO dao = new ProductosDAO();
			dao.delete(id);

			response.sendRedirect("productosC");
		
	}

	private void postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Levantar datos
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String sprecio = request.getParameter("precio");	
		String sstock = request.getParameter("stock");		
		
		var precio = Double.parseDouble(sprecio);
		var stock = Integer.parseInt(sstock);

		var sId = request.getParameter("id");
		var id = Integer.parseInt(sId);
		
		//Proceso
		var pro = dao.getById(id);
		pro.setDescripcion(descripcion);
		pro.setNombre(nombre);
		pro.setPrecio(precio);
		pro.setStock(stock);
		
		dao.update(pro);
		

		// Salida
		response.sendRedirect("productosC");
		
		
	}

	private void postInsert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Levantar datos
		String nombre = Optional.ofNullable(request.getParameter("nombre")).orElse("");
	    String descripcion = Optional.ofNullable(request.getParameter("descripcion")).orElse("");
	    String sprecio = Optional.ofNullable(request.getParameter("precio")).orElse("");
	    String sstock = Optional.ofNullable(request.getParameter("stock")).orElse("");

	    var precio = Double.parseDouble(sprecio);
	    var stock = Integer.parseInt(sstock);

		// Procesar
		var pro = new Producto(0, descripcion, nombre, precio, stock);
		dao.insert(pro);

		// Salida
		response.sendRedirect("productosC");

	}

}
