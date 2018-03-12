/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.dao;


import com.upa.articulos.model.Conexion;
import com.upa.articulos.model.Hospitales;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author oscarcode
 */
public class HospitalesDAO {
    private Conexion con;
    private Connection connection;
    
    public HospitalesDAO(String jdbcURL, 
                String jdbcUsername, String jdbcPassword)throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
    
    public boolean insertar(Hospitales hospital) 
                throws SQLException {
        
		String sql = "INSERT INTO Hospitales "
                        + "VALUES (?, ?, ?,?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
                
		statement.setString(1, null);
		statement.setString(2, hospital.getNombre());
		statement.setString(3, hospital.getDireccion());
		statement.setString(4, hospital.getTelefono());
	

		boolean rowInserted = 
                        statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
    public List<Hospitales> listarHospitales() 
                throws SQLException {

		List<Hospitales> listarHospitales = 
                        new ArrayList<Hospitales>();
                
		String sql = "SELECT * FROM  Hospitales;";
		con.conectar();
                
		connection = con.getJdbcConnection();
		Statement statement = 
                        connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int idHospital = resulSet.getInt("idHospital");
			String nombre = resulSet.getString("nombre");
			String direccion = resulSet.getString("direccion");
                        String telefono = resulSet.getString("telefono");
			Hospitales hospital = new Hospitales(idHospital, nombre, direccion, telefono);
                        listarHospitales.add(hospital);
		}
		con.desconectar();
		return listarHospitales;
	}
    
    public boolean eliminar(Hospitales hospital) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM Hospitales WHERE idHospital =?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,  hospital.getIdHospital());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
    public Hospitales obtenerPorId(int id) throws SQLException {
		Hospitales hospital = null;

		String sql = "SELECT * FROM "
                        + "Hospitales WHERE idHospital = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			hospital = 
               new Hospitales(res.getInt("idHospital"), 
                       res.getString("nombre"), res.getString("direccion"),
					res.getString("telefono"));
		}
		res.close();
		con.desconectar();

		return hospital;
	}
    
    public boolean actualizar(Hospitales hospital) throws SQLException {
        
		boolean rowActualizar = false;
                
		String sql = "UPDATE Hospitales SET "
                        + "nombre=?, direccion=?,telefono=? WHERE idHospital=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
                
		statement.setString(1, hospital.getNombre());
		statement.setString(2, hospital.getDireccion());
		statement.setString(3, hospital.getTelefono());
		statement.setInt(4, hospital.getIdHospital());

		rowActualizar = statement.executeUpdate() > 0;
                
		statement.close();
		con.desconectar();
                
		return rowActualizar;
	}

    
}
