/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upa.articulo.controller;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import com.upa.articulo.dao.DoctoresDAO;
import com.upa.articulo.dao.EspecialidadDAO;
import com.upa.articulos.model.Doctores;
import com.upa.articulos.model.Enfermos;
import com.upa.articulos.model.Especialidad;
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
@WebServlet(name = "AdminDoctores", urlPatterns = {"/AdminDoctores"})
public class AdminDoctores extends HttpServlet {

    DoctoresDAO DoctoresDAO;
    EspecialidadDAO EspecialidadDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {

            DoctoresDAO = new DoctoresDAO(jdbcURL, jdbcUsername, jdbcPassword);
            EspecialidadDAO = new EspecialidadDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
            out.println("<title>Servlet AdminDoctores</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminDoctores at " + request.getContextPath() + "</h1>");
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
                case "index":
                    //index(request, response);
                    break;
                case "nuevoDoctor":
                    nuevoDoctor(request, response);
                    break;
                case "register":
                    System.out.println("entro");
                    //registrar(request, response);
                    break;
                case "mostrar":
                    //mostrar(request, response);
                    break;
                case "showedit":
                    showEditar(request, response);
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
            Logger.getLogger(AdminDoctores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("Hola Servlet..");
            String action = request.getParameter("action");
            System.out.println(action);
            switch (action) {
                case "index":
                    //index(request, response);
                    break;
                case "nuevoDoctor":
                    nuevoDoctor(request, response);
                    break;
                case "register":
                    System.out.println("entro");
                    //registrar(request, response);
                    break;
                case "mostrar":
                    //mostrar(request, response);
                    break;
                case "showedit":
                    //showEditar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;

                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDoctores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        System.out.println("Nombre especial:" + request.getParameter("nombreEspecialidad"));
        System.out.println(request.getParameter("idHospital"));
        
        Especialidad especialidad = EspecialidadDAO.obtenerPorNombre(request.getParameter("nombreEspecialidad"));

        int idEspecialidad = especialidad.getIdEspecialidad();
        Doctores doctor = new Doctores(
                0,
                request.getParameter("nombre"),
                Float.parseFloat(request.getParameter("salario")),
                idEspecialidad,
                Integer.parseInt(request.getParameter("idHospital"))
        );

        DoctoresDAO.actualizar(doctor);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }

    private void nuevoDoctor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        System.out.println("Nombre especial:" + request.getParameter("nombreEspecialidad"));
        System.out.println(request.getParameter("idHospital"));
        Especialidad especialidad = EspecialidadDAO.obtenerPorNombre(request.getParameter("nombreEspecialidad"));

        int idEspecialidad = especialidad.getIdEspecialidad();
        Doctores doctor = new Doctores(
                0,
                request.getParameter("nombre"),
                Float.parseFloat(request.getParameter("salario")),
                idEspecialidad,
                Integer.parseInt(request.getParameter("idHospital"))
        );

        DoctoresDAO.insertar(doctor);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Doctores doctor = DoctoresDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));

        DoctoresDAO.eliminar(doctor);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException {
        Doctores doctor = DoctoresDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        List<Especialidad> listaEspecialidad = EspecialidadDAO.listarEspecialidad();

        request.setAttribute("listaEspecialidad", listaEspecialidad);
        request.setAttribute("doctor", doctor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarDoctor.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(AdminDoctores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
