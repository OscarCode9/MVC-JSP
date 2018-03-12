package com.upa.articulo.dao;

import com.upa.articulos.model.Conexion;
import com.upa.articulos.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Conexion con;
    private Connection connection;

    public UsuarioDAO(String jdbcURL,
            String jdbcUsername,
            String jdbcPassword)
            throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL,
                jdbcUsername,
                jdbcPassword);
    }

    // insertar artículo
    public boolean registrar(Usuario usuario)
            throws SQLException {
        String sql = "INSERT INTO usuario "
                + "(id, nombre, password, "
                + "descripcion) "
                + "VALUES (?, ?, ?,?)";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement
                = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, usuario.getNombre());
        statement.setString(3, usuario.getPassword());
        statement.setString(4, usuario.getDescripcion());

        boolean rowInserted
                = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar todos los productos
    public List<Usuario> listarUsuarios()
            throws SQLException {

        List<Usuario> listaUsuario
                = new ArrayList<Usuario>();
        String sql
                = "SELECT * FROM usuario";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement
                = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int id = resulSet.getInt("id");
            String nombre = resulSet.getString("nombre");
            String password = resulSet.getString("password");
            String descripcion = resulSet.getString("descripcion");
            Usuario usuario
                    = new Usuario(id, nombre, password, descripcion);
            listaUsuario.add(usuario);
        }
        con.desconectar();
        return listaUsuario;
    }

    public Usuario obtenerUsuario(int id)
            throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM "
                + "usuario WHERE id= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement
                = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            usuario
                    = new Usuario(res.getInt("id"),
                            res.getString("nombre"),
                            res.getString("password"),
                            res.getString("descripcion")
                    );
        }
        res.close();
        con.desconectar();
        return usuario;
    }

}
