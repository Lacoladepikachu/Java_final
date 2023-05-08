

package ar.edu.unlz.jfinal.controller;

import java.io.IOException;
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

@WebServlet("/aduserC")
public class UsuariosadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuariosDAO audao;

	public UsuariosadminController() {
		audao = new UsuariosDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var optAccion = Optional.ofNullable(request.getParameter("accion"));

		var accion = optAccion.orElse("index");

		switch (accion) {
		case "index" -> getIndex(request, response);
		case "crear" -> getCrear(request, response);
		case "editar" -> getEditar(request, response);
		case "transferir"-> gettranferir(request, response);

		default -> response.getWriter().print("Not found (GET)");
		}

	}

	private void gettranferir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var rd = request.getRequestDispatcher("vistas/usuarios/banco.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var accion = request.getParameter("accion");

		switch (accion) {
		case "insert" -> postInsert(request, response);
		case "update" -> postUpdate(request, response);
		case "delete" -> postDelete(request, response);
		case "transferencia" -> posttransferir(request, response);
		}
	}

	private void posttransferir(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nom1 = request.getParameter("nom_user1");
		String nom2 = request.getParameter("nom_user2");
		double dinero = Double.parseDouble(request.getParameter("dinero").replace(",", "."));

		UsuariosDAO udao = new UsuariosDAO();
		Usuario user1 = udao.getByNombre(nom1);
		Usuario user2 = udao.getByNombre(nom2);

		double dinero1 = user1.getDinero() - dinero;
		double dinero2 = user2.getDinero() + dinero;

		user1.setDinero(dinero1);
		user2.setDinero(dinero2);

		udao.update(user1);
		udao.update(user2);

		response.sendRedirect("vistas/usuarios/banco.jsp");

	}


	private void getEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   int id = Integer.parseInt(request.getParameter("id"));
		    Usuario usuario = audao.getById(id);
		    request.setAttribute("usuario", usuario);
		    request.getRequestDispatcher("vistas/usuarios/editar.jsp").forward(request, response);	
	}
	
	
	

	private void getCrear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var rd = request.getRequestDispatcher("vistas/usuarios/crear.jsp");
		rd.forward(request, response);
	}

	private void getIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var listado =audao.list();
		
		System.out.println(listado);
		request.setAttribute("usuarios", listado);
		
		var rd = request.getRequestDispatcher("vistas/usuarios/index.jsp");
		rd.forward(request, response);
	}

	private void postDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	
		  int id = Integer.parseInt(request.getParameter("id"));

		    UsuariosDAO udao = new UsuariosDAO();
		    udao.delete(id);

			response.sendRedirect("aduserC");
		
	}

	private void postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Levantar datos
		String nombre = request.getParameter("nombre");
		String nick = request.getParameter("nick");	
		String clave = request.getParameter("clave");
		String sacceso = request.getParameter("clave_acceso");
		String sdinero = request.getParameter("dinero");
		
		var dinero = Double.parseDouble(sdinero);
		var acceso = Integer.parseInt(sacceso);

		var sId = request.getParameter("id");
		var id = Integer.parseInt(sId);
		
		//Proceso
		var user = audao.getById(id);
		user.setNombre(nombre);
		user.setNick(nick);
		user.setClave(clave);
		user.setAcceso(acceso);
		user.setDinero(dinero);
		
		audao.update(user);
		

		// Salida
		response.sendRedirect("vistas/usuarios/index.jsp");
		
		
	}

	private void postInsert(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
	    // Levantar datos
	    String nombre = request.getParameter("nombre");
	    String nick = request.getParameter("nick");
	    String clave = request.getParameter("clave");
	    String sacceso = request.getParameter("clave_acceso");
	    String sdinero = request.getParameter("dinero");

	    if (sacceso != null && sdinero != null) {
	        var dinero = Double.parseDouble(sdinero);
	        var acceso = Integer.parseInt(sacceso);

	        // Procesar
	        var user = new Usuario(nombre, nick, clave, acceso, dinero);
	        audao.insert(user);

	        // Salida
	        response.sendRedirect("aduserC");
	    } else {
	        // Manejo del error o redirección a una página de error
	        response.sendRedirect("error.jsp");
	    }
	}


}
