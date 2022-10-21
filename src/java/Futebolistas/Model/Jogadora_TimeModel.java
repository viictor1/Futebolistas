package Futebolistas.Model;

import Futebolistas.DAO.Jogadora_TimeDAO;
import Futebolistas.Enteties.Jogadora_Time;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class Jogadora_TimeModel {
    public void add(Jogadora_Time jt) throws SQLException{
        Jogadora_TimeDAO dao = new Jogadora_TimeDAO();
        if(jt.getId_jogadora() == 0){
            return;
        }
        dao.add(jt);
    }
    
    public void removerPorIDJ(int id) throws SQLException{
        Jogadora_TimeDAO dao = new Jogadora_TimeDAO();
        dao.removerPorIDJ(getJTByID(id));
    }
    
    public void removerPorIDT(int id) throws SQLException{
        Jogadora_TimeDAO dao = new Jogadora_TimeDAO();
        dao.removerPorIDT(getJTByID(id));
    }
    
    public Jogadora_Time getJTByID(int id) throws SQLException{
        Jogadora_TimeDAO dao = new Jogadora_TimeDAO();
        return dao.getJTByID(id);
    }
    
    public ArrayList<Jogadora_Time> selectJogadoras(int id) throws SQLException{
        Jogadora_TimeDAO dao = new Jogadora_TimeDAO();
        return dao.selectAtuais(id);
    }
    
    public void editar(Jogadora_Time jt) throws SQLException{
        Jogadora_TimeDAO dao = new Jogadora_TimeDAO();
        dao.editar(jt);
    }
    
}
