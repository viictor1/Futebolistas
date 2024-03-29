/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Campeonato;
import Futebolistas.Enteties.Time;
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
@WebServlet(name = "Campeonatos", urlPatterns = {"/Campeonatos"})
public class Campeonatos extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
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
       
        Hub hub = new Hub();
        try {
            hub.loadlAll(request.getSession());
            ArrayList<Campeonato> campeonatos = (ArrayList<Campeonato>) request.getSession().getAttribute("campeonatos");
                TimeModel model = new TimeModel();
                for (Campeonato campeonato : campeonatos) {
                    Time t = null;
                    try {
                        t = model.getTimeByID(campeonato.getVencedor()); // atribuindo o nome do time vencedor ao campeonato, nao está na dao pq o nome pode ser alterado
                    } catch (SQLException ex) {
                        Logger.getLogger(Campeonatos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    campeonato.setNome(t.getNome());
                    campeonato.setImagem(t.getIdArquivo());
                }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("WEB-INF/campeonato-antigo.jsp").forward(request, response);
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Campeonatos.class.getName()).log(Level.SEVERE, null, ex);
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
