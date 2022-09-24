package Futebolistas.Model;

import Futebolistas.DAO.NoticiaDAO;
import Futebolistas.Enteties.Noticia;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class NoticiaModel {
    public void add(Noticia n) throws SQLException{
        NoticiaDAO dao = new NoticiaDAO();
        if(n.getTitulo() == null || n.getTitulo().equals("")){
            return;
        }
        if(n.getAutor()== null || n.getAutor().equals("")){
            return;
        }
        if(n.getTexto()== null || n.getTexto().equals("")){
            return;
        }
        dao.add(n);
    }
}
