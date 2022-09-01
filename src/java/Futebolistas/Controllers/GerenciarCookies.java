/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Futebolistas.Controllers;

import Futebolistas.Enteties.Usuario;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maluc
 */
@WebServlet(name = "GerenciarCookies", urlPatterns = {"/GerenciarCookies"})
public class GerenciarCookies extends HttpServlet {

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
        
        if (sessao != null && sessao.getAttribute("autenticado") != null) {
            u = (Usuario) sessao.getAttribute("autenticado");

            request.setAttribute("autenticado", u);
            request.getRequestDispatcher("WEB-INF/indexlogin.jsp").forward(request, response);
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("ManterLogado".equals(cookie.getName())) {
                        UsuarioModel model = new UsuarioModel();
                        try {
                            u = model.selectUsuariobyID(Integer.parseInt(cookie.getValue()));
                        } catch (SQLException ex) {
                            Logger.getLogger(GerenciarCookies.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        sessao = request.getSession(true);
                        sessao.setAttribute("autenticado", u);
                        request.getRequestDispatcher("WEB-INF/indexlogin.jsp").forward(request, response);
                        achouCookie = true;
                        break;
                    }

                }
            }
        }
        if (achouCookie != true) {
            response.sendRedirect("home");
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
