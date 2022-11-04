/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Campeonato;
import Futebolistas.Enteties.Jogadora;
import Futebolistas.Enteties.Jogo;
import Futebolistas.Enteties.Noticia;
import Futebolistas.Enteties.Time;
import Futebolistas.Enteties.Usuario;
import Futebolistas.Model.CampeonatoModel;
import Futebolistas.Model.JogadoraModel;
import Futebolistas.Model.JogoModel;
import Futebolistas.Model.NoticiaModel;
import Futebolistas.Model.TimeModel;
import Futebolistas.Model.UsuarioModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maluc
 */
@WebServlet(name = "Hub", urlPatterns = {"/Hub"})
public class Hub extends HttpServlet {      

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
        
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }
    
    public void loadlAll(HttpSession sessao) throws SQLException{
        ArrayList<Time> times = new ArrayList();
        ArrayList<Noticia> noticias = new ArrayList();
        ArrayList<Campeonato> cas = new ArrayList();
        ArrayList<Jogadora> jogadorasL = new ArrayList();
        ArrayList<Jogo> jogos = new ArrayList();
        ArrayList<Jogadora> jogadoras = new ArrayList();
        
        TimeModel modelt = new TimeModel();
        NoticiaModel modeln = new NoticiaModel();
        CampeonatoModel modelca = new CampeonatoModel();
        JogadoraModel modelj = new JogadoraModel();
        JogoModel modelJogo = new JogoModel();
        
        for(Jogadora j : modelj.selecionarTodas()){
            modelj.atualizarAtividade(j.getId());
        }

        times = modelt.selecionarTodos();
        noticias = modeln.selecionarTodos();
        cas = modelca.selecionarTodos();
        jogadorasL = modelj.selecionarLivres();
        jogos = modelJogo.proximosJogos();
        
        for(Time t : times){
            modelt.atualizarTorcedores(t.getId());
            modelt.atualizarTitulos(t.getId());
        }

        
        sessao.setAttribute("times", times);
        sessao.setAttribute("noticias", noticias); // atribuindo tudo à sessão
        sessao.setAttribute("campeonatos", cas);
        sessao.setAttribute("jogadoras", jogadorasL);
        sessao.setAttribute("jogos", jogos);
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
