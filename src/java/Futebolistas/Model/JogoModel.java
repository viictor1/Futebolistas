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
}
