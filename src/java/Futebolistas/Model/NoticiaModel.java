package Futebolistas.Model;

import Futebolistas.DAO.NoticiaDAO;
import Futebolistas.Enteties.Noticia;
import Futebolistas.Enteties.Arquivo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class NoticiaModel {
    public void add(Noticia n, Arquivo arquivo) throws SQLException{
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
        if(arquivo.getConteudo().length == 0){
            return;
        }
        dao.add(n, arquivo);
    }
    
    public void remover(int id) throws SQLException{
        NoticiaDAO dao = new NoticiaDAO();
        dao.remover(id);
    }
    
    public ArrayList<Noticia> selecionarTodos() throws SQLException{
        NoticiaDAO dao = new NoticiaDAO();
        return dao.selecionarTodos();
    }
    
    public Noticia selectNoticiaByID(int id) throws SQLException{
        NoticiaDAO dao = new NoticiaDAO();
        return dao.getNoticiaByID(id);
    }
}
