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
        if(j.getCampeonato() == 0){
            return;
        }
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
    
    public int partidasJogadas(int id) throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.partidasJogadas(id);
    }
    
    public int vitorias(int id) throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.vitorias(id);
    }
    
    public int empates(int id) throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.empates(id);
    }
    
    public int derrotas(int id) throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.derrotas(id);
    }
    
    public int golsMarcados(int id) throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.golsMarcados(id);
    }
    
    public int golsSofridos(int id) throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.golsSofridos(id);
    }
}
