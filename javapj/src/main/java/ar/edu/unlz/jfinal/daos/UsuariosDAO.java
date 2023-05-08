package ar.edu.unlz.jfinal.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.User;

import ar.edu.unlz.jfinal.factorys.ConexionFactory;
import ar.edu.unlz.jfinal.models.Producto;
import ar.edu.unlz.jfinal.models.Usuario;


public class UsuariosDAO {

	public void insert(Usuario usuario){
try {
		var conn = ConexionFactory.getConexion();

		String query = "insert into usuarios";
		query += " (nombre, clave, nick, clave_acceso, dinero )";
		query += " values (?,?,?,?,?)";

		var ps = conn.prepareStatement(query);

		ps.setString(1, usuario.getNombre());
		ps.setString(2, usuario.getClave());
		ps.setString(3, usuario.getNick());
		ps.setInt(4, usuario.getAcceso());
		ps.setDouble(5, usuario.getDinero());

		ps.executeUpdate();

		conn.close();
} catch (Exception e) {
	// TODO: handle exception
}
	}

	

	public void update(Usuario usuario) {
		try {
		var conn = ConexionFactory.getConexion();

	    String query = "update usuarios set nombre=?, clave=?, nick=?,clave_acceso=?,dinero=?  where id=?";

	    var ps = conn.prepareStatement(query);

	    ps.setString(1, usuario.getNombre());
	    ps.setString(2, usuario.getClave());
	    ps.setString(3, usuario.getNick());
	    ps.setInt(4, usuario.getAcceso());
	    ps.setDouble(5, usuario.getDinero());
	    ps.setInt(6, usuario.getId());
	   

	    ps.executeUpdate();

	    conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
		var conn = ConexionFactory.getConexion();

	    String query = "delete from usuarios where id=?";

	    var ps = conn.prepareStatement(query);

	    ps.setInt(1, id);

	    ps.executeUpdate();

	    conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean existsNombre(String nombre) throws SQLException {
		return this.getByNombre(nombre) != null;
	}

	public Usuario getByNombre(String nombre)  {
		Usuario usuario = null;
		try {
			
		var conn = ConexionFactory.getConexion();

		String query = "select id, nombre, clave, nick, clave_acceso, dinero";
		query += " from usuarios";
		query += " where nombre = ?";

		var ps = conn.prepareStatement(query);

		ps.setString(1, nombre);

		var rs = ps.executeQuery();

		if (rs.next()) {
			usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setClave(rs.getString("clave"));
			usuario.setNick(rs.getString("nick"));
			usuario.setAcceso(rs.getInt("clave_acceso"));
			usuario.setDinero(rs.getDouble("dinero"));

		}

		conn.close();
    
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return usuario;
		
		
	}


	public Usuario getById(int id){
		Usuario usuario = null;
		try {
		var conn = ConexionFactory.getConexion();

		var ps = conn.prepareStatement(
				"select id, nombre, nick, clave, clave_acceso, dinero" + " from usuarios " + " where id = ?");

		ps.setInt(1, id);

		var rs = ps.executeQuery();

		if (rs.next()) {
			var _id = rs.getInt("id");
			var _nombre = rs.getString("nombre");
			var _nick = rs.getString("nick");
			var _clave = rs.getString("clave");
			var _acceso = rs.getInt("clave_acceso");
			var _dinero =rs.getDouble("dinero");
			
			usuario = new Usuario();
			usuario.setId(_id);
			usuario.setNombre(_nombre);
			usuario.setNick(_nick);
			usuario.setClave(_clave);
			usuario.setAcceso(_acceso);
			usuario.setDinero(_dinero);
			

		}

		conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}


	public List<Usuario> list() {
	    var list = new ArrayList<Usuario>();

		try {
			var con = ConexionFactory.getConexion();

			var ps = con.prepareStatement("select * from usuarios");

			var rs = ps.executeQuery();

			while (rs.next()) {
				
				var _id = rs.getInt("id");
				var _nombre = rs.getString("nombre");
				var _nick = rs.getString("clave");
				var _clave = rs.getString("nick");
				var _int = rs.getInt("clave_acceso");
				var _dinero = rs.getDouble("dinero");
				
				var user = new Usuario();
				user.setId(_id);
				user.setNombre(_nombre);
				user.setNick(_nick);
				user.setClave(_clave);
				user.setAcceso(_int);
				user.setDinero(_dinero);
				
				
				
				list.add(user);

			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}	
	
}
