/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.controller;

import com.upa.articulo.dao.IngresosDAO;
import com.upa.articulos.model.Hospitales;
import com.upa.articulos.model.Ingresos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "AdminIngresos", urlPatterns = {"/AdminIngresos"})
public class AdminIngresos extends HttpServlet {
    
    IngresosDAO IngresosDAO;
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            IngresosDAO = new IngresosDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminIngresos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminIngresos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    private void nuevoIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        Ingresos ingreso = new Ingresos(0,
                Integer.parseInt(request.getParameter("idHospital")),
                Integer.parseInt(request.getParameter("idEnfermo")),
                request.getParameter("fechaNacimiento"),
                request.getParameter("causas"),
                Integer.parseInt(request.getParameter("habitacion"))
        );
        
        
        boolean resul = IngresosDAO.insertar(ingreso);
        
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
                
                case "eliminar":
                    System.out.println("entro");
                    eliminar(request, response);
                    break;
                case "showedit":
                    showEditar(request, response);
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet..");
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
                
                case "nuevoIngreso":
                    System.out.println("entro");
                    nuevoIngreso(request, response);
                    break;
                case "editar": 
                    editar(request, response);
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Ingresos ingreso = IngresosDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        
        
        request.setAttribute("ingreso", ingreso);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarIngreso.jsp");
        dispatcher.forward(request, response);
    }
    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Ingresos ingreso = new Ingresos(Integer.parseInt(request.getParameter("idIngresos")),
                Integer.parseInt(request.getParameter("idHospital")),
                Integer.parseInt(request.getParameter("idEnfermo")),
                request.getParameter("fechaNacimiento"),
                request.getParameter("causas"),
                Integer.parseInt(request.getParameter("habitacion"))
        );
        
        IngresosDAO.actualizar(ingreso);
        
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        
    }
    
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        
        Ingresos ingreso = IngresosDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        IngresosDAO.eliminar(ingreso);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
