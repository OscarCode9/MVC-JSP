/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.controller;

import com.upa.articulo.dao.EspecialidadDAO;
import com.upa.articulos.model.Especialidad;
import com.upa.articulos.model.Hospitales;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oscarcode
 */
@WebServlet(name = "AdminEspecialidad", urlPatterns = {"/AdminEspecialidad"})
public class AdminEspecialidad extends HttpServlet {
    
    EspecialidadDAO especialidadDAO;
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {

             especialidadDAO = new  EspecialidadDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("Hola Servlet..");
            String action = request.getParameter("action");
            System.out.println(action);
            switch (action) {
                case "index":
                    //index(request, response);
                    break;
                case "nuevo":
                    //nuevo(request, response);
                    break;
                case "nuevoHospital":
                    System.out.println("entro");
                    //nuevoHospital(request, response);
                    break;
                case "mostrar":
                    System.out.println("mostrar");
                    {
                        try {
                            mostrar(request, response);
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "showedit":
                {
                    try {
                        showEditar(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "editar":
                    //editar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/especialidad.jsp");
        
        List<Especialidad> listaEspecialidad = especialidadDAO.listarEspecialidad();
        
        request.setAttribute("lista", listaEspecialidad);
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            System.out.println("Hola Servlet post..");
            String action = request.getParameter("action");
            System.out.println(action);
            switch (action) {
                case "index":
                    //index(request, response);
                    break;
                case "nuevo":
                    //nuevo(request, response);
                    break;
                case "nuevoEspecialidad":
                    System.out.println("entro");
                    {
                        try {
                            nuevoEspecialidad(request, response);
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "mostrar":
                    System.out.println("mostrar");
                    //mostrar(request, response);
                    break;
                case "showedit":
                {
                    try {
                        showEditar(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "editar":
                {
                    try {
                        editar(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void nuevoEspecialidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        Especialidad especialidad = new Especialidad(0, request.getParameter("nombre"));
        
        especialidadDAO.insertar(especialidad);
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        
        dispatcher.forward(request, response);
        
    }
    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        Especialidad especialidad = especialidadDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("especialidad", especialidad);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarEspecialidad.jsp");
        dispatcher.forward(request, response);
    }
    
    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Especialidad especialidad = new Especialidad(Integer.parseInt(request.getParameter("idEspecialidad")),request.getParameter("nombre"));
        especialidadDAO.actualizar(especialidad);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Especialidad especialidad = especialidadDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        especialidadDAO.eliminar(especialidad);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
