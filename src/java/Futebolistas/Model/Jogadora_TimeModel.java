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
        dao.add(jt);
    }
    
    public ArrayList<Jogadora_Time> selectJogadoras(int id) throws SQLException{
        Jogadora_TimeDAO dao = new Jogadora_TimeDAO();
        return dao.selectAtuais(id);
    }
    
}
