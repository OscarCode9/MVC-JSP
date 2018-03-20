/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.controller;

import com.upa.articulo.dao.AtencionesDAO;
import com.upa.articulo.dao.IngresosDAO;
import com.upa.articulos.model.Atenciones;
import com.upa.articulos.model.Ingresos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "AdminAtenciones", urlPatterns = {"/AdminAtenciones"})
public class AdminAtenciones extends HttpServlet {
    
    
    AtencionesDAO AtencionesDAO;
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            AtencionesDAO = new AtencionesDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAtenciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAtenciones at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("Hola Servlet..");
            String action = request.getParameter("action");
            System.out.println(action);
            switch (action) {
                
                case "showedit":
                    System.out.println("entro");
                    showEditar(request, response);
                    break;
                case "eliminar": 
                    eliminar(request, response);
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminAtenciones.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            System.out.println("Hola Servlet..");
            String action = request.getParameter("action");
            System.out.println(action);
            switch (action) {
                
                case "nuevoAtencio":
                    System.out.println("entro");
                    nuevoAtencion(request, response);
                    break;
                case "editar":
                    editar(request, response);
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminAtenciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void nuevoAtencion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Atenciones atencion = new Atenciones(0,
                Integer.parseInt(request.getParameter("idDoctor")),
                Integer.parseInt(request.getParameter("idIngresos")),
                request.getParameter("comentarios"),
                request.getParameter("fecha"));
        
        
        boolean resul = AtencionesDAO.insertar(atencion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Atenciones atencion = AtencionesDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        
        request.setAttribute("atencion", atencion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarAtencion.jsp");
        dispatcher.forward(request, response);
    }

    
    
    
    

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        
         Atenciones atencion = new Atenciones(
                Integer.parseInt(request.getParameter("idAtencion")),
                Integer.parseInt(request.getParameter("idDoctor")),
                Integer.parseInt(request.getParameter("idIngresos")),
                request.getParameter("comentarios"),
                request.getParameter("fecha"));

        AtencionesDAO.actualizar(atencion);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Atenciones atencion = AtencionesDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        AtencionesDAO.eliminar(atencion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }

}
