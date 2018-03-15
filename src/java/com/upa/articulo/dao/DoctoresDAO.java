/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.dao;


import com.upa.articulos.model.Conexion;
import com.upa.articulos.model.Especialidad;
import com.upa.articulos.model.Doctores;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctoresDAO {
    private Conexion con;
    private Connection connection;
    
    public DoctoresDAO(String jdbcURL, 
                String jdbcUsername, String jdbcPassword)throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
    
    public boolean insertar(Doctores doctor) 
                throws SQLException {
        
                //String sql = "INSERT INTO Doctores VALUES (?, 'Oscar Martínez', 8600.50, 2,10);";
        
		String sql = "INSERT INTO Doctores VALUES (?, ?, ?, ?,?);";
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
                
		statement.setString(1, null);
		statement.setString(2, doctor.getNombre());
                statement.setFloat(3, doctor.getSalario());
                statement.setFloat(4, doctor.getIdEspecialidad());
                statement.setFloat(5, doctor.getIdHospital());
                
		
	

		boolean rowInserted = 
                        statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
    public List<Doctores> listarDoctoresByHospital(int idHospitalA)
                throws SQLException {

		List<Doctores> listarDoctores = 
                        new ArrayList<Doctores>();
                
		
		
                con.conectar();
                
                
                
		connection = con.getJdbcConnection();
                PreparedStatement pstmt;
                pstmt = connection.prepareStatement("SELECT * FROM  Doctores WHERE idHospital =?"); 
                pstmt.setInt(1, idHospitalA);   // Asignar valor a parámetro de entrada  2  
                ResultSet rs = pstmt.executeQuery();
		

		while (rs.next()) {
                    
			int idDoctor = rs.getInt("idDoctor");
			String nombre = rs.getString("nombre");
                        float salario = rs.getFloat("salario");
                        int idEspecialidad = rs.getInt("idEspecialidad");
                        int idHospital = rs.getInt("idHospital");
                        
                        
			
                        Doctores doctor = new Doctores(idDoctor, nombre, salario,idEspecialidad,idHospital );
			
                        listarDoctores.add(doctor);
		}
		con.desconectar();
		return listarDoctores;
	}
    
    public boolean eliminar(Doctores doctor) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM Doctores WHERE idDoctor =?";
		con.conectar();
 		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,  doctor.getIdDoctor());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
    public Doctores obtenerPorId(int id) throws SQLException {
		Doctores doctor = null;

		String sql = "SELECT * FROM "
                        + "Doctores WHERE idDoctor = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = 
                        connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
                    
                    doctor = new Doctores(res.getInt("idDoctor"),res.getString("nombre"),
                            res.getFloat("salario"), 
                            res.getInt("idEspecialidad"), res.getInt("idHospital"));
			
		}
		res.close();
		con.desconectar();

		return doctor;
	}
    
    public boolean actualizar(Doctores doctor) throws SQLException {
        
		boolean rowActualizar = false;
                
                
		String sql = "UPDATE Doctores SET "
                        + "nombre=?, salario=?, idEspecialidad=?, idHospital=? WHERE idDoctor=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
                
		statement.setString(1, doctor.getNombre());
		statement.setFloat(2, doctor.getSalario());
                statement.setFloat(3, doctor.getIdEspecialidad());
                statement.setFloat(4, doctor.getIdHospital());
                statement.setFloat(5, doctor.getIdDoctor());
                
		rowActualizar = statement.executeUpdate() > 0;
                
		statement.close();
		con.desconectar();
                
		return rowActualizar;
	}

    
}
