/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Jogo;
import Futebolistas.Enteties.Time;
import Futebolistas.Model.CampeonatoModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Futebolistas.Model.JogoModel;
import Futebolistas.Model.TimeModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author victo
 */
@WebServlet(name = "HistoricoJogos", urlPatterns = {"/HistoricoJogos"})
public class HistoricoJogos extends HttpServlet {

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
        
        JogoModel modelj = new JogoModel();
        TimeModel model = new TimeModel();
        CampeonatoModel modelc = new CampeonatoModel();
        try {
            ArrayList<Jogo> array = modelj.selectHistorico();
            for(Jogo j : array){             
                Time casa = model.getTimeByID(j.getTime_casa());
                Time visitante = model.getTimeByID(j.getTime_visitante());
                
                j.setNome_casa(casa.getNome());
                j.setImg_casa(casa.getIdArquivo());
                j.setNome_visitante(visitante.getNome());
                j.setImg_visitante(visitante.getIdArquivo());
            }
            request.setAttribute("campeonato", modelc.selectUltimo());
            request.setAttribute("historico", array);       
            request.getRequestDispatcher("WEB-INF/historico-jogos.jsp").forward(request, response);
        } catch (SQLException ex) {
            response.sendRedirect("Jogos");
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
