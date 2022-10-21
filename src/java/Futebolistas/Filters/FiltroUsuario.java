/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author maluc
 */
@WebFilter(filterName = "FiltroUsuario", servletNames = {"CadastrarTimes", "MenuCadastro", "NoticiaCadastrar", "CampeonatoAntigoCadastrar", "JogadoraCadastrar"})
public class FiltroUsuario implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException{
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession sessao = request.getSession(false);
        if(sessao != null && sessao.getAttribute("autenticado") != null) {
            chain.doFilter(request, response);
        }
        else {
            response.sendRedirect("Hub");
        }
    }
    
}
