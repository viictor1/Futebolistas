/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Jogo;
import Futebolistas.Enteties.Time;
import Futebolistas.Model.JogoModel;
import Futebolistas.Model.TimeModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author victo
 */
@WebServlet(name = "EditarJogo", urlPatterns = {"/EditarJogo"})
public class EditarJogo extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("id"));
        JogoModel model = new JogoModel();
        TimeModel modelt = new TimeModel();
        try {
            Jogo j = model.selectJogoByID(id);
            Time casa = modelt.getTimeByID(j.getTime_casa());
            Time visitante = modelt.getTimeByID(j.getTime_visitante());
            
            j.setNome_casa(casa.getNome());
            j.setImg_casa(casa.getIdArquivo());
            j.setNome_visitante(visitante.getNome());
            j.setImg_visitante(visitante.getIdArquivo());
            
            request.setAttribute("jogo", j);
            request.getRequestDispatcher("WEB-INF/editar-jogo.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarJogo.class.getName()).log(Level.SEVERE, null, ex);
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
        
        int id = Integer.parseInt(request.getParameter("id"));
        int casa = Integer.parseInt(request.getParameter("golsCasa"));
        int visitante = Integer.parseInt(request.getParameter("golsVisitante"));
        
        Jogo j = new Jogo();
        j.setId(id);
        j.setGol_casa(casa);
        j.setGol_visitante(visitante);
        
        JogoModel model = new JogoModel();
        try {
            model.atualizar(j);
            response.sendRedirect("Jogos");
        } catch (SQLException ex) {
            response.sendRedirect("Jogos");
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

}
