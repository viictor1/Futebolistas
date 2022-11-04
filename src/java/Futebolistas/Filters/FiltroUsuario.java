/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Filters;

import Futebolistas.Controllers.Hub;
import Futebolistas.Enteties.Usuario;
import Futebolistas.Model.UsuarioModel;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maluc
 */
@WebFilter(filterName = "FiltroUsuario", servletNames = {"Hub", "AlterarSenha", "TorcerTime"})
public class FiltroUsuario implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException{
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        Boolean achouCookie = false;
        Usuario u = null;

        
        if (request.getSession(false) != null && request.getSession(false).getAttribute("autenticado") != null) {
            HttpSession sessao = request.getSession();
            u = (Usuario) sessao.getAttribute("autenticado"); // se tiver uma sessão aberta, é atribuida à sessão o usuario
            sessao.setAttribute("autenticado", u);
            Hub hub = new Hub();
                try {
                    hub.loadlAll(request.getSession());
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            chain.doFilter(request, response);
            
        
        } else {
            Cookie[] cookies = request.getCookies();
            HttpSession sessao = request.getSession(true);
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
                        achouCookie = true; // declarando que o cookie foi achado
                        Hub hub = new Hub();
                        try {
                            hub.loadlAll(request.getSession());
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                        chain.doFilter(request, response);
                        break;
                    }

                }
            }             
        }
        if (achouCookie != true) { 
                HttpSession sessao = request.getSession(true);
                Hub hub = new Hub();
                try {
                    hub.loadlAll(sessao);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                request.getRequestDispatcher("WEB-INF/home.jsp").forward(req, res);
        }
    }
    
}
