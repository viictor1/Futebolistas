package Futebolistas.Controllers;

import Futebolistas.Enteties.Arquivo;
import Futebolistas.Enteties.Noticia;
import Futebolistas.Model.NoticiaModel;
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
 * @author victo
 */
@WebServlet(name = "NoticiaCadastrar", urlPatterns = {"/NoticiaCadastrar"})
@MultipartConfig(maxFileSize = 8 * 1024 * 1024 * 5) // 5MB
public class NoticiaCadastrar extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        request.getRequestDispatcher("WEB-INF/cadastro-noticias.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String titulo, autor, texto;
        titulo = request.getParameter("titulo");
        autor = request.getParameter("autor");
        texto = request.getParameter("texto");
        
        Part part = request.getPart("imagem");
        String mimetype = part.getContentType();
        byte[] imagem = new byte[part.getInputStream().available()];
        part.getInputStream().read(imagem);
        Arquivo img = new Arquivo(imagem, mimetype);
        
        Noticia n = new Noticia(titulo, autor, texto);
        NoticiaModel model = new NoticiaModel();
        try {
            model.add(n, img);
            response.sendRedirect("Hub");
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("NoticiaCadastrar");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
