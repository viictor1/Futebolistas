package Futebolistas.Model;

import Futebolistas.DAO.JogadoraDAO;
import Futebolistas.Enteties.Jogadora;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class JogadoraModel {
    public void add(Jogadora j) throws SQLException{
        JogadoraDAO dao = new JogadoraDAO();
        dao.add(j);
    }
    
    public ArrayList<Jogadora> selecionarTodos() throws SQLException{
        JogadoraDAO dao = new JogadoraDAO();
        return dao.selecionarTodos();
    }
    
    public void remover(int id) throws SQLException{
        JogadoraDAO dao = new JogadoraDAO();
        if(id == 0){
            return;
        }
        dao.remover(id);
    }
}
