/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Jogadora_Time;
import Futebolistas.Model.Jogadora_TimeModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author victo
 */
@WebServlet(name = "Jogadora_TimeServlet", urlPatterns = {"/Jogadora_TimeServlet"})
public class Jogadora_TimeServlet extends HttpServlet {

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
        try {   
            processRequest(request, response); 
            if("".equals(request.getParameter("id_jogadora")) || request.getParameter("id_jogadora") == null){ // alterar jogadora      
            }else{
                Jogadora_TimeModel model = new Jogadora_TimeModel();
                Jogadora_Time jt = null;
                jt = model.getJTByID(Integer.parseInt(request.getParameter("id_jogadora")));
                request.setAttribute("jt", jt);
            }
            request.setAttribute("id", request.getParameter("id"));
            Hub hub = new Hub();
            try {
                hub.loadlAll(request.getSession());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            request.getRequestDispatcher("WEB-INF/jogadora_time.jsp").forward(request, response);
            
         } catch (SQLException ex) {
            Logger.getLogger(Jogadora_TimeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);     
        int id_time = 0, id_jogadora, numero;
        String posicao;
        Date data_inicio, data_fim;    
        
        id_time = Integer.parseInt(request.getParameter("id"));
        if("".equals(request.getParameter("selectJ")) || request.getParameter("selectJ") == null){
            id_jogadora = 0;
        }
        else{
            id_jogadora = Integer.parseInt(request.getParameter("selectJ"));
        }
        
        numero = Integer.parseInt(request.getParameter("numero")); 
        posicao = request.getParameter("posicao");
        
        Jogadora_Time jt = new Jogadora_Time();
        if("".equals(request.getParameter("alterando")) || request.getParameter("alterando") == null){
            data_inicio = Date.valueOf(request.getParameter("data_inicio")); //cadastrando nova
            jt.setData_inicio(data_inicio);
        }    
        else{    
            if("".equals(request.getParameter("data_fim"))){ //alterando
                data_fim = null;
            } 
            else{
                data_fim = Date.valueOf(request.getParameter("data_fim"));
            }
            id_jogadora = Integer.parseInt(request.getParameter("id_jogadora"));
            jt.setData_fim(data_fim);
        }
        jt.setId_time(id_time);
        jt.setId_jogadora(id_jogadora);
        jt.setPosicao(posicao);
        
        jt.setNumero_atual(numero);
        
        
        Jogadora_TimeModel model = new Jogadora_TimeModel();
        try {
            if("".equals(request.getParameter("alterando")) || request.getParameter("alterando") == null){ 
                model.add(jt);
            }
            else{
                jt.setId(Integer.parseInt(request.getParameter("alterando")));
                model.editar(jt);
            }  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        response.sendRedirect("SaibaMaisTime?id=" + id_time);
        
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
