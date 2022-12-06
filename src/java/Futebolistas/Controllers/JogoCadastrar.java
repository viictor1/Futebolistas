/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Jogo;
import Futebolistas.Model.CampeonatoModel;
import Futebolistas.Model.JogoModel;
import Futebolistas.Model.TimeModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author victo
 */
@WebServlet(name = "JogoCadastrar", urlPatterns = {"/JogoCadastrar"})
public class JogoCadastrar extends HttpServlet {

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
        
        CampeonatoModel model = new CampeonatoModel();
        TimeModel modelT = new TimeModel();
        try {
            request.setAttribute("campeonato", model.selectAtual());
            request.setAttribute("participantes", modelT.selecionarParticipantes());
        } catch (SQLException ex) {
            Logger.getLogger(JogoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("WEB-INF/cadastrar-jogo.jsp").forward(request, response);
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
        try {
        int campeonato, time_casa = 0, time_visitante = 0;
        Date data_jogo;
        String fase;
        LocalTime horario;
        
        campeonato = Integer.parseInt(request.getParameter("campeonato"));
        if(!"".equals(request.getParameter("time_casa")) && request.getParameter("time_casa") != null){
            time_casa = Integer.parseInt(request.getParameter("time_casa"));
        }
        if(!"".equals(request.getParameter("time_visitante")) && request.getParameter("time_visitante") != null){
            time_visitante = Integer.parseInt(request.getParameter("time_visitante"));
        }
        data_jogo = Date.valueOf(request.getParameter("data_jogo"));
        horario = LocalTime.parse(request.getParameter("horario"));
        fase = request.getParameter("select");       
        
        Jogo j = new Jogo();
        j.setCampeonato(campeonato);
        j.setTime_casa(time_casa);
        j.setTime_visitante(time_visitante);
        j.setData_jogo(data_jogo);
        j.setHorario(horario);
        j.setFase(fase);
        
        JogoModel model = new JogoModel();
        
            model.add(j);
            response.sendRedirect("JogoCadastrar");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            response.sendRedirect("JogoCadastrar");
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
