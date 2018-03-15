/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.dao;

import com.upa.articulos.model.Conexion;
import com.upa.articulos.model.Hospitales;
import com.upa.articulos.model.Ingresos;
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
public class IngresosDAO {
    private Conexion con;
    private Connection connection;
    
    public IngresosDAO(String jdbcURL, 
                String jdbcUsername, String jdbcPassword)throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
    
    public boolean insertar(Ingresos ingreso) 
                throws SQLException {
        
		String sql = "INSERT INTO Ingresos VALUES(?,?,?, STR_TO_DATE(?,'%d %M, %Y'), ?,?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
                
		statement.setString(1, null);
		statement.setInt(2, ingreso.getIdHospital());
		statement.setInt(3, ingreso.getIdEnfermo());
		statement.setString(4, ingreso.getFecha());
                statement.setString(5, ingreso.getCausas());
                statement.setInt(6, ingreso.getHabitacion());
                
	

		boolean rowInserted = 
                        statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
    
    public List<Ingresos> listarIngresos(int idHospitalA) 
                throws SQLException {

		List<Ingresos> listarIngresos = 
                        new ArrayList<Ingresos>();
                
		String sql = "SELECT * FROM Ingresos where idHospital = ?";
                
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
		statement.setInt(1, idHospitalA);

		ResultSet resulSet = statement.executeQuery();

		while (resulSet.next()) {
			int idIngresos = resulSet.getInt("idIngresos");
			int  idHospital = resulSet.getInt("idHospital");
			int idEnfermo = resulSet.getInt("idEnfermo");
                        
                        String fecha = resulSet.getString("fecha");
                        String causas = resulSet.getString("causas");
                        int habitacion = resulSet.getInt("habitacion");
                         
			Ingresos ingreso = new Ingresos(idIngresos, idHospital, idEnfermo, fecha, causas, habitacion);
                        listarIngresos.add(ingreso);
		}
		con.desconectar();
		return listarIngresos;
	}
    
    public boolean eliminar(Ingresos ingreso) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM Ingresos WHERE idIngresos =?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,  ingreso.getIdIngresos());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
    
    public Ingresos obtenerPorId(int id) throws SQLException {
		Ingresos ingreso = null;

		String sql = "SELECT * FROM "
                        + "Ingresos WHERE idIngresos = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resulSet = statement.executeQuery();
		if (resulSet.next()) {
			int idIngresos = resulSet.getInt("idIngresos");
			int  idHospital = resulSet.getInt("idHospital");
			int idEnfermo = resulSet.getInt("idEnfermo");
                        
                        String fecha = resulSet.getString("fecha");
                        String causas = resulSet.getString("causas");
                        int habitacion = resulSet.getInt("habitacion");
                         
			ingreso = new Ingresos(idIngresos, idHospital, idEnfermo, fecha, causas, habitacion);
		}
		resulSet.close();
		con.desconectar();

		return ingreso;
	}
    
}
