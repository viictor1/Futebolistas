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
        if("".equals(j.getData_jogo())){
            return;
        }
        if(j.getTime_casa() == 0 || j.getTime_visitante() == 0){
            return;
        }
        if("".equals(j.getFase()) || j.getFase() == null){
            return;
        }
        dao.add(j);
    }
    
    public ArrayList<Jogo> proximosJogos() throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.proximosJogos();
    }
    
    public ArrayList<Jogo> selectHistorico() throws SQLException{
        JogoDAO dao = new JogoDAO();
        return dao.selectHistorico();
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
        if("".equals(j.getGol_casa()) || "".equals(j.getGol_visitante())){
            return;
        }
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
