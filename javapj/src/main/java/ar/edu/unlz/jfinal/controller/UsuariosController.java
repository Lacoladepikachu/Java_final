package ar.edu.unlz.jfinal.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlz.jfinal.daos.ProductosDAO;
import ar.edu.unlz.jfinal.daos.UsuariosDAO;
import ar.edu.unlz.jfinal.models.Producto;
import ar.edu.unlz.jfinal.models.Usuario;

/**
 * Servlet implementation class UsuariosController
 */
@WebServlet("/ingreso/*")
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuariosDAO uDao;

	public UsuariosController() {
		super();
		uDao = new UsuariosDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var accion = request.getPathInfo();
		accion = Optional.ofNullable(accion).orElse("/login");

		switch (accion.toLowerCase()) {
		case "/login" -> getLogin(request, response);
		case "/register" -> getRegister(request, response);
		default -> response.sendRedirect(request.getContextPath()+"/ingreso/login");
		}

	}

	

	

	private void getLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var rd = request.getRequestDispatcher("/vistas/usuarios/login.jsp");

		rd.forward(request, response);

		return;
	}

	private void getRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var rd = request.getRequestDispatcher("/vistas/usuarios/register.jsp");

		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var accion = request.getPathInfo();
		accion = Optional.ofNullable(accion).orElse("/");
		try {
			switch (accion.toLowerCase()) {
			case "/login" -> postLogin(request, response);
			case "/register" -> postRegister(request, response);
			case "/update"-> postUpdate(request, response);
			case "/delete"-> postDelete(request, response);

			default -> response.sendError(404,"No existe la accion: "+accion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(500, "Algo salio mal");
		}
	}
	

	protected void postDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  int id = Integer.parseInt(request.getParameter("id"));

		    ProductosDAO dao = new ProductosDAO();
			dao.delete(id);

			response.sendRedirect("ingreso/*");
	}

	private void postUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		var nombre = request.getParameter("nombre");
		var clave = request.getParameter("clave");
		var nick = request.getParameter("nick");
		var sacceso = request.getParameter("clave_acceso");
		var sdinero = request.getParameter("dinero");
		
		var dinero = Double.parseDouble(sdinero);
		
		var acceso = Integer.parseInt(sacceso);
		

		var sId = request.getParameter("id");
		var id = Integer.parseInt(sId);
		
		//Proceso
		var user = uDao.getById(id);
		user.setAcceso(acceso);
		user.setClave(clave);
		user.setNick(nick);
		user.setNombre(nombre);
		user.setDinero(dinero);
		
		
		uDao.update(user);
		

		// Salida
		response.sendRedirect("vistas/productos/index.jsp");
		
	}

	

	private void postRegister(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		var nombre = request.getParameter("nombre");
		var clave = request.getParameter("clave");
		var nick = request.getParameter("nick");
		var sacceso = request.getParameter("clave_acceso");
		var sdinero = request.getParameter("dinero");
		var dinero = Double.parseDouble(sdinero);
		
		var acceso = 0;
		if (sacceso != null && !sacceso.isEmpty()) {
		    acceso = Integer.parseInt(sacceso);
		}
		 
        
		
		if(!uDao.existsNombre(nombre)) {
			var usuario = new Usuario(nombre, clave, nick, acceso,dinero);
			
			uDao.insert(usuario);
			
			
			
		}else {
			response.sendError(500,"Ya existe el usuario.");
			return;
		}
		

		response.sendRedirect(request.getContextPath()+"/ingreso");
	}

	private void postLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

	    var nombre = request.getParameter("nombre");
	    var clave = request.getParameter("clave");
	    
	    var usuario = uDao.getByNombre(nombre);
	    
	    if(usuario == null) {
	        response.sendError(500,"No existe el usuario");
	        return;
	    } else if(!usuario.validarClave(clave)) {
	        response.sendError(500,"Clave incorrecta");    
	        return;
	    }
	        
	    var session = request.getSession();
	    
	    session.setAttribute("usuario_id", usuario.getId());
	    
	    response.sendRedirect(request.getContextPath()+"/home?id="+usuario.getId());
	}

	
}


