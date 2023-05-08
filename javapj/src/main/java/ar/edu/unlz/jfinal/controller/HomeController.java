package ar.edu.unlz.jfinal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlz.jfinal.daos.UsuariosDAO;
import ar.edu.unlz.jfinal.models.Usuario;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;





	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var uDao = new UsuariosDAO();
		  var usuarioId = Integer.parseInt(request.getParameter("id"));
		    var usuario = uDao.getById(usuarioId);
		    
		var session = request.getSession();

		var usuariosLogueado = (Usuario) session.getAttribute("usuario");
		
		int acceso = usuario.getAcceso();
		
		if (acceso == 1) {
			var rd = request.getRequestDispatcher("vistas/home/index.jsp");
			rd.forward(request, response);
			
		} else if (acceso == 2) {
			var rd = request.getRequestDispatcher("vistas/home/indexcli.jsp");
			rd.forward(request, response);
			
		} 
		
		var rd = request.getRequestDispatcher("vistas/home/index.jsp");
		rd.forward(request, response);
		
		
	 }
		
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 String action = request.getParameter("action");
	        if (action == null) {
	            // Si no se proporciona una acción, se carga la página principal
	            request.getRequestDispatcher("home.jsp").forward(request, response);
	        } else if (action.equals("productos")) {
	            // Si se proporciona la acción 'productos', se redirige al controlador de productos
	        	response.sendRedirect(request.getContextPath()+"/productosC?accion=index");
	        }else if (action.equals("productoscli")) {
	            // Si se proporciona la acción 'productos', se redirige al controlador de productos
	        	response.sendRedirect(request.getContextPath()+"/productosC?accion=indexcli");
	        }else if (action.equals("usuarios")) {
	            // Si se proporciona la acción 'usuarios', se redirige al controlador de usuarios
	            response.sendRedirect(request.getContextPath() + "/aduserC?accion=index");
	        } else if (action.equals("transferir")) {
	            // Si se proporciona la acción 'transferencia', se redirige al controlador de transferencia
	            response.sendRedirect(request.getContextPath() + "/aduserC?accion=transferir");
	        } else if (action.equals("carrito")) {
	            // Si se proporciona la acción 'transferencia', se redirige al controlador de transferencia
	            response.sendRedirect(request.getContextPath() + "/carritoC?accion=listar");
	        }
	        else {
	            // Si se proporciona una acción desconocida, se muestra un error
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción desconocida: " + action);
	        }
	    
	        

}


}
