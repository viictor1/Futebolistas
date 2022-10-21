/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Filters;

import Futebolistas.Model.TimeModel;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author maluc
 */
@WebFilter(filterName = "FiltroTime", servletNames = {"SaibaMaisTime"})
public class FiltroTime implements Filter{
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        int id = 0;
        TimeModel model = new TimeModel();
        if(!"".equals(request.getParameter("id_time")) || request.getParameter("id") != null){
            id = Integer.parseInt(req.getParameter("id"));
            try {
                if(!"".equals(model.getTimeByID(id).getNome()) && model.getTimeByID(id).getNome() != null){
                    chain.doFilter(req, res);
                }    
                else{
                    response.sendRedirect("Hub");
                }
            } catch (SQLException ex) {
                response.sendRedirect("Hub");
            }
        }
        else{
            response.sendRedirect("Hub");
        }
    
    }
}
