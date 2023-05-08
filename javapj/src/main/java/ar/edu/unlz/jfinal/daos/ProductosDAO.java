package ar.edu.unlz.jfinal.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlz.jfinal.factorys.ConexionFactory;
import ar.edu.unlz.jfinal.models.Producto;

public class ProductosDAO {

	public void insert(Producto pro) {
		try {
			var con = ConexionFactory.getConexion();

			var query = "INSERT INTO PRODUCTOS";
			query += " (descripcion, id, nombre, precio, stock)";
			query += " values (?, ?, ?, ?, ?)";

			var ps = con.prepareStatement(query);

			ps.setString(1, pro.getDescripcion());
			ps.setInt(2, pro.getId());
			ps.setString(3, pro.getNombre());
			ps.setDouble(4, pro.getPrecio());
			ps.setInt(5, pro.getStock());

			ps.executeUpdate();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public void update(Producto pro) {
		try {
			var con = ConexionFactory.getConexion();

			var query = "UPDATE PRODUCTOS";
			query += " SET nombre = ?,";
			query += " descripcion = ?,";
			query += " precio = ?,";
			query += " stock = ?";
			query += " WHERE id = ?";

			var ps = con.prepareStatement(query);
			ps.setString(1, pro.getNombre());
			ps.setString(2, pro.getDescripcion());
			ps.setDouble(3, pro.getPrecio());
			ps.setInt(4, pro.getStock());
			ps.setInt(5, pro.getId());
			
			ps.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void delete(int id) {
		try {
			var con = ConexionFactory.getConexion();

			var query = "DELETE FROM PRODUCTOS";
			query += " WHERE id = ?";

			var ps = con.prepareStatement(query);

			ps.setInt(1, id);

			ps.executeUpdate();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public Producto getById(int id) {

		Producto pro = null;
		try {
			var con = ConexionFactory.getConexion();

			var ps = con.prepareStatement(
					"select id, nombre, descripcion, precio, stock" + " from PRODUCTOS " + " where id = ?");

			ps.setInt(1, id);

			var rs = ps.executeQuery();

			if (rs.next()) {
				var _id = rs.getInt("id");
				var _nombre = rs.getString("nombre");
				var _descripcion = rs.getString("descripcion");
				var _precio = rs.getDouble("precio");
				var _stock = rs.getInt("stock");
				
				
				pro = new Producto();
				pro.setId(_id);
				pro.setNombre(_nombre);
				pro.setDescripcion(_descripcion);
				pro.setPrecio(_precio);
				pro.setStock(_stock);
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pro;
	}

	
	public List<Producto> all() {
		var list = new ArrayList<Producto>();

		try {
			var con = ConexionFactory.getConexion();

			var ps = con.prepareStatement("select * from PRODUCTOS");

			var rs = ps.executeQuery();

			while (rs.next()) {
				
				var _id = rs.getInt("id");
				var _nombre = rs.getString("nombre");
				var _descripcion = rs.getString("descripcion");
				var _precio = rs.getDouble("precio");
				var _stock = rs.getInt("stock");
				
				var pro = new Producto();
				pro.setId(_id);
				pro.setNombre(_nombre);
				pro.setDescripcion(_descripcion);
				pro.setPrecio(_precio);
				pro.setStock(_stock);
				
				
				
				
				list.add(pro);

			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}	
	
}
