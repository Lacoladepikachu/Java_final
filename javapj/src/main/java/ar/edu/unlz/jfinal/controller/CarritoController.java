package ar.edu.unlz.jfinal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.unlz.jfinal.daos.ProductosDAO;
import ar.edu.unlz.jfinal.models.Carrito;
import ar.edu.unlz.jfinal.models.Producto;

@WebServlet("/carritoC")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductosDAO productosDAO;

	public CarritoController() {
		super();
		productosDAO = new ProductosDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");

		if (accion != null) {
			switch (accion) {
			case "listar":
				listarProductosEnCarrito(request, response);
				break;
			default:
				response.sendRedirect("productosC");
				break;
			}
		} else {
			response.sendRedirect("productosC");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");

		if (accion != null) {
			switch (accion) {
			case "agregar":
				agregarProductoAlCarrito(request, response);
				break;
			default:
				response.sendRedirect("productosC");
				break;
			}
		} else {
			response.sendRedirect("productosC");
		}
	}

	private void agregarProductoAlCarrito(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));

		Producto producto = productosDAO.getById(idProducto);

		if (producto != null) {
			HttpSession session = request.getSession();
			Carrito carrito = (Carrito) session.getAttribute("carrito");

			if (carrito == null) {
				carrito = new Carrito();
				session.setAttribute("carrito", carrito);
			}

			carrito.addProducto(producto);

			response.sendRedirect("productosC");
		} else {
			response.sendRedirect("productosC");
		}
	}

	private void listarProductosEnCarrito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Carrito carrito = (Carrito) session.getAttribute("carrito");

		if (carrito != null) {
			List<Producto> productosEnCarrito = carrito.getProductos();
			request.setAttribute("productosEnCarrito", productosEnCarrito);

			request.getRequestDispatcher("vistas/carrito/index.jsp").forward(request, response);
		} else {
			response.sendRedirect("productosC");
		}
	}
}
