/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.dao;

import com.upa.articulos.model.Articulo;
import com.upa.articulos.model.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {
	private Conexion con;
	private Connection connection;

	public ArticuloDAO(String jdbcURL, 
                String jdbcUsername, String jdbcPassword) 
                throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, 
                        jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Articulo articulo) 
                throws SQLException {
		String sql = "INSERT INTO articulos "
                        + "(id, codigo, nombre, "
                        + "descripcion, existencia, precio) "
                        + "VALUES (?, ?, ?,?,?,?)";
		System.out.println(articulo.getDescripcion());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, articulo.getCodigo());
		statement.setString(3, articulo.getNombre());
		statement.setString(4, articulo.getDescripcion());
		statement.setDouble(5, articulo.getExistencia());
		statement.setDouble(6, articulo.getPrecio());

		boolean rowInserted = 
                        statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Articulo> listarArticulos() 
                throws SQLException {

		List<Articulo> listaArticulos = 
                        new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = 
                        connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String codigo = resulSet.getString("codigo");
			String nombre = resulSet.getString("nombre");
			String descripcion = resulSet.getString("descripcion");
			Double existencia = resulSet.getDouble("existencia");
			Double precio = resulSet.getDouble("precio");
			Articulo articulo = 
               new Articulo(id, codigo, nombre, descripcion,
                       existencia, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}

	// obtener por id
	public Articulo obtenerPorId(int id) throws SQLException {
		Articulo articulo = null;

		String sql = "SELECT * FROM "
                        + "articulos WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			articulo = 
               new Articulo(res.getInt("id"), 
                       res.getString("codigo"), res.getString("nombre"),
					res.getString("descripcion"), res.getDouble("existencia"), res.getDouble("precio"));
		}
		res.close();
		con.desconectar();

		return articulo;
	}

	// actualizar
	public boolean actualizar(Articulo articulo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE articulos SET "
                        + "codigo=?,nombre=?,descripcion=?,existencia=?, precio=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, articulo.getCodigo());
		statement.setString(2, articulo.getNombre());
		statement.setString(3, articulo.getDescripcion());
		statement.setDouble(4, articulo.getExistencia());
		System.out.println(articulo.getPrecio());
		statement.setDouble(5, articulo.getPrecio());
		statement.setInt(6, articulo.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Articulo articulo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM articulos WHERE ID=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, articulo.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}