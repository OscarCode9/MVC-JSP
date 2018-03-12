/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.dao;

import com.upa.articulos.model.Articulo;
import com.upa.articulos.model.Conexion;
import com.upa.articulos.model.Enfermos;
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
public class EnfermosDAO {
    private Conexion con;
    private Connection connection;
    public EnfermosDAO(String jdbcURL, 
                String jdbcUsername, String jdbcPassword)throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
    
    public boolean insertar(Enfermos enfermo) 
                throws SQLException {
		String sql = "INSERT INTO `Hospitales`.`Enfermos`(`idEnfermo`,`nombre`,`fechaNacimiento`,`sexo`,`direccion`,`localidad`,`provincia`,`pais`,`codigoPostal`) VALUES (?, ?, STR_TO_DATE(?, '%d %M, %Y'), ?, ?, ?, ?, ?, ?);";
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, enfermo.getNombre());
		statement.setString(3, enfermo.getFechaNacimiento());
		statement.setString(4, enfermo.getSexo());
		statement.setString(5, enfermo.getDireccion());
		statement.setString(6, enfermo.getLocalidad());
                statement.setString(7, enfermo.getProvincia());
                statement.setString(8, enfermo.getPais());
                statement.setString(9, enfermo.getCodigoPostal());

		boolean rowInserted = 
                        statement.executeUpdate() > 0;
                
		statement.close();
		con.desconectar();
		return rowInserted;
	}
    public Enfermos obtenerPorId(int id) throws SQLException {
		Enfermos enfermo = null;

		String sql = "SELECT * FROM "
                        + "Enfermos WHERE idEnfermo = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			enfermo = 
               new Enfermos(res.getInt("idEnfermo"),
                       res.getString("nombre"),
                       res.getString("fechaNacimiento"),
                       res.getString("sexo"),
                       res.getString("direccion"),
                       res.getString("localidad"),
                       res.getString("provincia"),
                       res.getString("pais"),
                       res.getString("codigoPostal"));
		}
		res.close();
		con.desconectar();

		return enfermo;
	}
    
    public List<Enfermos> listarEnfermos() 
                throws SQLException {

		List<Enfermos> listaEnfermos = 
                        new ArrayList<Enfermos>();
                
                
                
		String sql = "SELECT * FROM Enfermos";
                
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = 
                        connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int idEnfermo = resulSet.getInt("idEnfermo");
			String nombre = resulSet.getString("nombre");
			String fechaNacimiento = resulSet.getString("fechaNacimiento");
			String sexo = resulSet.getString("sexo");
			String direccion = resulSet.getString("direccion");
			String localidad = resulSet.getString("localidad");
                        String provincia = resulSet.getString("provincia");
                        String pais = resulSet.getString("pais");
                        String codigoPostal = resulSet.getString("codigoPostal");
			
                        Enfermos enfermo = new Enfermos(idEnfermo, nombre, fechaNacimiento, sexo, direccion,localidad,provincia, pais, codigoPostal);
                        
                        listaEnfermos.add(enfermo);
			
		}
		con.desconectar();
		return listaEnfermos;
	}
    
    public boolean eliminar(Enfermos enfermo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM Enfermos WHERE idEnfermo =?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
                
		statement.setInt(1,  enfermo.getIdEnfermo());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
    public boolean actualizar(Enfermos enfermo) throws SQLException {
        
		boolean rowActualizar = false;
                
		String sql = "UPDATE Enfermos SET "
                        + "nombre=?, fechaNacimiento=?,sexo=?, direccion=?, localidad=?, provincia=?, pais=?, codigoPostal=? WHERE idEnfermo=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
                
		statement.setString(1, enfermo.getNombre());
                statement.setString(2, enfermo.getFechaNacimiento());
                statement.setString(3, enfermo.getSexo());
                statement.setString(4, enfermo.getDireccion());
                statement.setString(5, enfermo.getLocalidad());
                statement.setString(6, enfermo.getProvincia());
                statement.setString(7, enfermo.getPais());
                statement.setString(8, enfermo.getCodigoPostal());
                statement.setInt(9, enfermo.getIdEnfermo());
                
                
		

		rowActualizar = statement.executeUpdate() > 0;
                
		statement.close();
		con.desconectar();
                
		return rowActualizar;
	}
    
}
