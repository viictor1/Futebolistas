package Futebolistas.Controllers;

import Futebolistas.Enteties.Jogadora;
import Futebolistas.Model.JogadoraModel;
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
@WebServlet(name = "JogadoraCadastrar", urlPatterns = {"/JogadoraCadastrar"})
public class JogadoraCadastrar extends HttpServlet {

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
        
        Hub hub = new Hub();
        try {
            hub.loadlAll(request.getSession());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("WEB-INF/cadastrar-jogadora.jsp").forward(request, response);
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
        
        String nome;
        int id = 0;
        Jogadora j = new Jogadora();
        
        nome = request.getParameter("nome");
        if(!"".equals(request.getParameter("id")) && request.getParameter("id") != null){
            id = Integer.parseInt(request.getParameter("id"));
            j.setId(id);
        }     
        j.setNome(nome);
        JogadoraModel model = new JogadoraModel();
        try {
            if(id == 0){
                model.add(j);
                response.sendRedirect("Times");      
            }
            else{
                model.editar(j);
                response.sendRedirect("ListarJogadoras");
            }
            
            
        } catch (SQLException ex) {
            response.sendRedirect("JogadoraCadastrar");
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
