
package com.upa.articulo.controller;

import com.upa.articulo.dao.ArticuloDAO;
import com.upa.articulo.dao.UsuarioDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/adminUsuario")
public class AdminUsuario extends HttpServlet {
        private static final long 
                serialVersionUID = 1L;
    UsuarioDAO usuarioDAO;
    
        public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            usuarioDAO = new UsuarioDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public AdminUsuario() {
        super();
    }
    
    
    
    
}
