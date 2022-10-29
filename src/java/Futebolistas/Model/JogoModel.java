package Futebolistas.Model;

import Futebolistas.DAO.JogoDAO;
import Futebolistas.Enteties.Jogo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class JogoModel {
    public void add (Jogo j) throws SQLException{
        JogoDAO dao = new JogoDAO();
        dao.add(j);
    }
    
    public ArrayList<Jogo> proximosJogos() throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.proximosJogos();
    }
    
    public void remover(int id) throws SQLException{
        JogoDAO dao = new JogoDAO();
        dao.remover(id);
    }
    
    public Jogo selectJogoByID(int id) throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.selectJogoByID(id);
    }
    
    public void atualizar(Jogo j) throws SQLException{
        JogoDAO dao = new JogoDAO();
        dao.atualizar(j);
    }
}
