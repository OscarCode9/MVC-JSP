/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.controller;

import com.upa.articulo.dao.EnfermosDAO;
import com.upa.articulos.model.Enfermos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "AdminEnfermos", urlPatterns = {"/AdminEnfermos"})
public class AdminEnfermos extends HttpServlet {

    EnfermosDAO enfermoDAO;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminEnfermos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminEnfermos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            
            enfermoDAO = new EnfermosDAO(jdbcURL, jdbcUsername, jdbcPassword);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    private void nuevoEnfermo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        Enfermos enfermo = new Enfermos(
                0, 
                request.getParameter("nombre"),
                request.getParameter("fechaNacimiento"),
                request.getParameter("sexo"),
                request.getParameter("direccion"), 
                request.getParameter("localidad"),
                request.getParameter("provincia"),
                request.getParameter("pais"),
                request.getParameter("codigoPostal")   
        );
        
        System.out.println(request.getParameter("nombre"));
        System.out.println(request.getParameter("fechaNacimiento"));
        System.out.println(request.getParameter("sexo"));
        System.out.println(request.getParameter("direccion"));
        System.out.println(request.getParameter("localidad"));
        System.out.println(request.getParameter("provincia"));
        System.out.println(request.getParameter("pais"));
        System.out.println(request.getParameter("codigoPostal"));
        
        
        
        enfermoDAO.insertar(enfermo);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        
    }
    private void index(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //mostrar(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet..");
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;
                case "nuevoEnfermo":
                    nuevoEnfermo(request, response);
                    break;
                case "mostrar":
                    System.out.println("mostrar");
                    mostrar(request, response);
                    break;
                case "showedit":
                    showEditar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                default:
                    processRequest(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Enfermos enfermo = enfermoDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        
        enfermoDAO.eliminar(enfermo);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
    
    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/enfermos.jsp");
        
        List<Enfermos> listaEnfermos = enfermoDAO.listarEnfermos();
        
        request.setAttribute("lista", listaEnfermos);
        
        dispatcher.forward(request, response);
    }
    
    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Enfermos enfermo = enfermoDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("enfermo", enfermo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarEnfermo.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        
         Enfermos enfermo = new Enfermos(
                Integer.parseInt(request.getParameter("idEnfermo")), 
                request.getParameter("nombre"),
                request.getParameter("fechaNacimiento"),
                request.getParameter("sexo"),
                request.getParameter("direccion"), 
                request.getParameter("localidad"),
                request.getParameter("provincia"),
                request.getParameter("pais"),
                request.getParameter("codigoPostal")   
        );
         
         enfermoDAO.actualizar(enfermo);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        
    }
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    

}
