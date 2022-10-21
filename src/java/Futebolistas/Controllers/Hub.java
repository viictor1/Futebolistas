/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.CampeonatoAntigo;
import Futebolistas.Enteties.Jogadora;
import Futebolistas.Enteties.Noticia;
import Futebolistas.Enteties.Time;
import Futebolistas.Enteties.Usuario;
import Futebolistas.Model.CampeonatoAntigoModel;
import Futebolistas.Model.JogadoraModel;
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
        ArrayList<Time> times = new ArrayList();
        ArrayList<Noticia> noticias = new ArrayList();
        ArrayList<CampeonatoAntigo> cas = new ArrayList();
        ArrayList<Jogadora> jogadoras = new ArrayList();

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

        HttpSession sessao = request.getSession(false);
        Boolean achouCookie = false;
        Usuario u = null;
        TimeModel modelt = new TimeModel();
        NoticiaModel modeln = new NoticiaModel();
        CampeonatoAntigoModel modelca = new CampeonatoAntigoModel();
        JogadoraModel modelj = new JogadoraModel();
        
        try {
            times = modelt.selecionarTodos();
            noticias = modeln.selecionarTodos();
            cas = modelca.selecionarTodos();
            jogadoras = modelj.selecionarTodos();
        } catch (SQLException ex) {
           Logger.getLogger(Hub.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (sessao != null && sessao.getAttribute("autenticado") != null) {
            u = (Usuario) sessao.getAttribute("autenticado"); // se tiver uma sessão aberta, é atribuida à sessão o usuario
            sessao.setAttribute("autenticado", u);
            loadlAll(sessao);
            verificacaoOrigin(request.getParameter("/"), request, response, sessao);
        
        } else {
            Cookie[] cookies = request.getCookies();
            sessao = request.getSession(true);
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("ManterLogado".equals(cookie.getName())) {
                        UsuarioModel model = new UsuarioModel();
                        try {
                            u = model.selectUsuariobyID(Integer.parseInt(cookie.getValue())); // pegando o usuário pelo id dele que está no valor do cookie
                        } catch (SQLException ex) {
                            Logger.getLogger(Hub.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        sessao.setAttribute("autenticado", u); //se tiver um cookie de manter logado, é atribuida à sessão esse usuário
                        loadlAll(sessao);
                        verificacaoOrigin(request.getParameter("/"), request, response, sessao);
                        achouCookie = true; // declarando que o cookie foi achado
                        break;
                    }

                }
            }             
        }
        if (achouCookie != true) { // se o cookie não for achado, ele é direcionado para a home sem o usuário, mas com os times
            loadlAll(sessao);
            verificacaoOrigin(request.getParameter("/"), request, response, sessao);
            return;
        }
        
    }
    
    public void loadlAll(HttpSession sessao){
        sessao.setAttribute("times", times);
        sessao.setAttribute("noticias", noticias); // atribuindo tudo à sessão
        sessao.setAttribute("campeonatos", cas);
        sessao.setAttribute("jogadoras", jogadoras);
    }
    
    public void verificacaoOrigin(String d, HttpServletRequest request, HttpServletResponse response, HttpSession sessao) throws ServletException, IOException{
        if("".equals(d)){
                request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
                return;
            } else if("Times".equals(d)){
                    request.getRequestDispatcher("WEB-INF/times.jsp").forward(request, response);
                    return;
                }
            else if("Cadastro".equals(d)){
                    request.setAttribute("cadastro", true);
                    request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
                    return;
            } else if("Ca".equals(d)){
                 ArrayList<CampeonatoAntigo> campeonatos = (ArrayList<CampeonatoAntigo>) sessao.getAttribute("campeonatos");
                TimeModel model = new TimeModel();
                for (CampeonatoAntigo campeonato : campeonatos) {
                    Time t = null;
                    try {
                        t = model.getTimeByID(campeonato.getVencedor()); // atribuindo o nome do time vencedor ao campeonato, nao está na dao pq o nome pode ser alterado
                    } catch (SQLException ex) {
                        Logger.getLogger(CampeonatosAntigos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    campeonato.setNome(t.getNome());
                }
                request.getRequestDispatcher("WEB-INF/campeonato-antigo.jsp").forward(request, response);
                return;
            } else if("Torcidas".equals(d)){
                request.getRequestDispatcher("WEB-INF/torcidas.jsp").forward(request, response);
                return;
            }
            else{
                request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
                return;
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
