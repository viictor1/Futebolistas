package Futebolistas.Filters;

import Futebolistas.Enteties.Usuario;
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
@WebFilter(filterName = "FiltroAdm", servletNames = {"CadastrarTimes", "MenuCadastro", "NoticiaCadastrar", "CampeonatoCadastrar", "JogadoraCadastrar"})
public class FiltroAdm implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
   
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession sessao = request.getSession(false);
        
        Usuario u = new Usuario();
        if(sessao.getAttribute("autenticado") == null || "".equals(sessao.getAttribute("autenticado"))){
            return;           
        }
        else{
            u = (Usuario) sessao.getAttribute("autenticado");
        }

        if(u.getIsAdministrador()){
            chain.doFilter(req, res);
        }
        else{
            response.sendRedirect("Hub");
        }
    }
    
}
