/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Arquivo;
import Futebolistas.Enteties.Time;
import Futebolistas.Model.ArquivoModel;
import Futebolistas.Model.TimeModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author maluc
 */
@WebServlet(name = "CadastrarTimes", urlPatterns = {"/CadastrarTimes"})
@MultipartConfig(maxFileSize = 8 * 1024 * 1024 * 5) // 5MB
public class CadastrarTimes extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

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
        request.setCharacterEncoding("UTF-8");
        
        if(!"".equals(request.getParameter("idAlterar"))){
            TimeModel model = new TimeModel();
            Time t = null;
            try {
                t = model.getTimeByID(Integer.parseInt(request.getParameter("idAlterar")));
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarTimes.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("alterar", t);
        }
        
        request.getRequestDispatcher("WEB-INF/cadastrar-times.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        
        String nome, data_fundacao, tecnico, presidente, local_fundacao;
        int titulos;
        int id;
        
        if("".equals(request.getParameter("id"))){
            id = 0;
        }
        else{
            id = Integer.parseInt(request.getParameter("id")); //pegando id do time se ele tiver alterando
        }
     
        nome = request.getParameter("nome");
        data_fundacao = request.getParameter("data");
        tecnico = request.getParameter("tecnico");
        presidente = request.getParameter("presidente");
        local_fundacao = request.getParameter("local");
        titulos = Integer.parseInt(request.getParameter("titulos"));
        
        int idArquivo = 0;
               
        Part part = request.getPart("imagem");
        String mimetype = part.getContentType();
        byte[] imagem = new byte[part.getInputStream().available()];
        part.getInputStream().read(imagem);
        Arquivo img = new Arquivo();
        
        if(id == 0){
            img.setConteudo(imagem); // Time novo
            img.setMimetype(mimetype);  
        }
        else{
            ArquivoModel modelA = new ArquivoModel();
            if(imagem.length != 0){  // passou imagem
                    img.setId(Integer.parseInt(request.getParameter("idArquivo")));
                    img.setConteudo(imagem);
                    img.setMimetype(mimetype);
                }
            else{
                try {
                img = modelA.getArquivoByID(idArquivo); // nao passou imagem
                 } 
                catch (SQLException ex) {
                Logger.getLogger(CadastrarTimes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
               
        Time time = new Time(nome, data_fundacao, tecnico, presidente, local_fundacao, titulos, 0);
        TimeModel model = new TimeModel();

        if(id == 0){
            try {
                model.add(time, img);
            } catch (SQLException ex) {
                response.sendRedirect("CadastrarTimes");
            }
            
        }     
        else{
            try {
                model.atualizarTime(time, id, img);
            } catch (SQLException ex) {
                response.sendRedirect("GerenciarCookies?origin=Times");
            }
        }   
        response.sendRedirect("GerenciarCookies?origin=Times");       
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
