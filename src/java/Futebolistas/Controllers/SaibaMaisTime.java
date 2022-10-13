/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Jogadora_Time;
import Futebolistas.Enteties.Time;
import Futebolistas.Model.Jogadora_TimeModel;
import Futebolistas.Model.TimeModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author victo
 */
@WebServlet(name = "SaibaMaisTime", urlPatterns = {"/SaibaMaisTime"})
public class SaibaMaisTime extends HttpServlet {

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
        processRequest(request, response);
        
        int id;
        id = Integer.parseInt(request.getParameter("id"));
        TimeModel model = new TimeModel();
        Jogadora_TimeModel modeljt = new Jogadora_TimeModel();
        ArrayList<Jogadora_Time> jogadoras = new ArrayList();
        try {
            Time t = model.getTimeByID(id);
            request.setAttribute("time", t);
            request.setAttribute("jogadorasT", modeljt.selectJogadoras(id));;
            request.getRequestDispatcher("WEB-INF/saibaMaisTime.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            response.sendRedirect("GerenciarCookies?origin=Times");
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
        processRequest(request, response);
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

}
