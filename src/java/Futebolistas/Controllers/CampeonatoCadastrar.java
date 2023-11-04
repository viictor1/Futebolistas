/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Campeonato;
import Futebolistas.Model.CampeonatoModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author victo
 */
@WebServlet(name = "CampeonatoCadastrar", urlPatterns = {"/CampeonatoCadastrar"})
public class CampeonatoCadastrar extends HttpServlet {

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
        
        request.getRequestDispatcher("WEB-INF/cadastrar-campeonato.jsp").forward(request, response);
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
        
        int ano, vencedor;
        try {
            ano = Integer.parseInt(request.getParameter("ano"));        
            vencedor = Integer.parseInt(request.getParameter("selectTime"));

            Campeonato ca = new Campeonato();
            ca.setAno(ano);
            ca.setVencedor(vencedor);

            CampeonatoModel model = new CampeonatoModel();           
            try{
                model.add(ca);
            } catch (SQLException ex) {
                response.sendRedirect("CampeonatoCadastrar");
            }
            
            if(vencedor == 0){
                response.sendRedirect("Jogos");
            }
            else{
                response.sendRedirect("Campeonatos");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
