/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.controller;

import com.upa.articulo.dao.ArticuloDAO;
import com.upa.articulo.dao.HospitalesDAO;
import com.upa.articulos.model.Hospitales;

import com.upa.articulos.model.Articulo;
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
@WebServlet(name = "AdminHospitales", urlPatterns = {"/AdminHospitales"})
public class AdminHospitales extends HttpServlet {
    HospitalesDAO HospitalesDAO;
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {

             HospitalesDAO = new  HospitalesDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
            out.println("<title>Servlet AdminHospitales</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminHospitales at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
                case "nuevo":
                    //nuevo(request, response);
                    break;
                case "nuevoHospital":
                    System.out.println("entro");
                    nuevoHospital(request, response);
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
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        
    }
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/hospitales.jsp");
        
        List<Hospitales> listaHospitales = HospitalesDAO.listarHospitales();
        
        request.setAttribute("lista", listaHospitales);
        dispatcher.forward(request, response);
    }
    private void nuevoHospital(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        Hospitales hospital = new Hospitales(0, request.getParameter("nombre"), request.getParameter("direccion"), request.getParameter("telefono"));
        
        HospitalesDAO.insertar(hospital);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        
        dispatcher.forward(request, response);
        
    }
    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Hospitales hospital = HospitalesDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("hospital", hospital);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarHospital.jsp");
        dispatcher.forward(request, response);
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Hospitales hospital = HospitalesDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        HospitalesDAO.eliminar(hospital);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Hospitales hospital = new Hospitales(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"), request.getParameter("direccion"), request.getParameter("telefono"));
        HospitalesDAO.actualizar(hospital);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
