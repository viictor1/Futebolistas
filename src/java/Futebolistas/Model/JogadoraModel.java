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
        if("".equals(j.getNome())){
            return;
        }
        dao.add(j);
    }
    
    public ArrayList<Jogadora> selecionarLivres() throws SQLException{
        JogadoraDAO dao = new JogadoraDAO();
        return dao.selecionarLivres();
    }
    
    public ArrayList<Jogadora> selecionarTodas() throws SQLException{
        JogadoraDAO dao = new JogadoraDAO();
        return dao.selecionarTodas();
    }
    
    public void atualizarAtividade(int id) throws SQLException{
        JogadoraDAO dao = new JogadoraDAO();
        dao.atualizarAtividade(id);
    }
    
    public Jogadora getJogadoraByID(int id) throws SQLException{
        JogadoraDAO dao = new JogadoraDAO();
        return dao.getJogadoraByID(id);
    }
    
    public void remover(int id) throws SQLException{
        JogadoraDAO dao = new JogadoraDAO();
        if(id == 0){
            return;
        }
        dao.remover(id);
    }
    
    public void editar(Jogadora j) throws SQLException{
        JogadoraDAO dao = new JogadoraDAO();
        dao.editar(j);
    }
}
