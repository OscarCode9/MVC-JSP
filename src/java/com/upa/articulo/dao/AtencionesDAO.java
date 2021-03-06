package com.upa.articulo.dao;

import com.upa.articulos.model.Atenciones;
import com.upa.articulos.model.Conexion;
import com.upa.articulos.model.Doctores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscarcode
 */
public class AtencionesDAO {
    private Conexion con;
    private Connection connection;
    
    public AtencionesDAO(String jdbcURL, 
                String jdbcUsername, String jdbcPassword)throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

    
    
    public boolean insertar(Atenciones atencion) 
                throws SQLException {
        
                //String sql = "INSERT INTO Doctores VALUES (?, 'Oscar Martínez', 8600.50, 2,10);";
        
		String sql = "INSERT INTO Atencion VALUES (?, ?, ?, ?, STR_TO_DATE(?,'%d %M, %Y'))";
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
                
		statement.setString(1, null);
		statement.setInt(2, atencion.getIdDoctor());
                statement.setInt(3, atencion.getIdIngresos());
                statement.setString(4,atencion.getComentarios() );
                statement.setString(5,atencion.getFecha());
               

		boolean rowInserted = statement.executeUpdate() > 0;
		
                statement.close();
		con.desconectar();
		return rowInserted;
    }
    
    public List<Atenciones> listarAtenciones()
                throws SQLException {

		List<Atenciones> listarAtencion = 
                        new ArrayList<Atenciones>();
                
		
		
                con.conectar();
                
                
                
		connection = con.getJdbcConnection();
                PreparedStatement pstmt;
                pstmt = connection.prepareStatement("SELECT * FROM Atencion"); 
                
                // Asignar valor a parámetro de entrada  2  
                ResultSet rs = pstmt.executeQuery();
		

		while (rs.next()) {
                    int idAtencion = rs.getInt("idAtencion");
                    int idDoctor = rs.getInt("idDoctor");
                    int idIngresos = rs.getInt("idIngresos");
                    String comentarios = rs.getString("comentarios");
                    String fecha = rs.getString("fecha");
                    Atenciones atencion = new Atenciones(idAtencion, idDoctor, idIngresos, comentarios, fecha);
                       
                    listarAtencion.add(atencion);
		}
		con.desconectar();
		return listarAtencion;
	}
    public Atenciones obtenerPorId(int id) throws SQLException {
		Atenciones atencion = null;

		String sql = "SELECT * FROM "
                        + "Atencion WHERE idAtencion = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
                
		if (res.next()) {
			atencion = 
               new Atenciones(res.getInt("idAtencion"),
                       res.getInt("idDoctor"),
                       res.getInt("idIngresos"),
                       res.getString("comentarios"),
                       res.getString("fecha"));
		}
		res.close();
		con.desconectar();

		return atencion;
	}
    
    public boolean actualizar(Atenciones atencion) throws SQLException {
        
		boolean rowActualizar = false;
                
                
		String sql = "UPDATE Atencion SET "
                        + "idDoctor=?, idIngresos=?, comentarios=?, fecha=STR_TO_DATE(?,'%d %M, %Y') WHERE idAtencion=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
                
		statement.setInt(1, atencion.getIdDoctor());
		statement.setInt(2, atencion.getIdIngresos());
                statement.setString(3, atencion.getComentarios());
                statement.setString(4, atencion.getFecha());
                statement.setInt(5, atencion.getIdAtencion());
                
		rowActualizar = statement.executeUpdate() > 0;
                
		statement.close();
		con.desconectar();
                
		return rowActualizar;
	}
    
    public boolean eliminar(Atenciones atencion) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM Atencion WHERE idAtencion =?";
		con.conectar();
 		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,  atencion.getIdAtencion());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
    
}
