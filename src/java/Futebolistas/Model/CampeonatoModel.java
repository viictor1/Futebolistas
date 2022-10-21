package Futebolistas.Model;

import Futebolistas.DAO.CampeonatoDAO;
import Futebolistas.Enteties.Campeonato;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class CampeonatoModel {
    public void add(Campeonato ca) throws SQLException{
        CampeonatoDAO dao = new CampeonatoDAO();
        if(dao.verificarAno(ca.getAno()) == true){
            return;
        }
        dao.add(ca);
    }
    
    public ArrayList<Campeonato> selecionarTodos() throws SQLException{
        CampeonatoDAO dao = new CampeonatoDAO();
        return dao.selecionarTodos();
    }
    
    public void remover(int id) throws SQLException{
        CampeonatoDAO dao = new CampeonatoDAO();
        Campeonato ca = dao.selectCabyID(id);
        dao.remover(ca);
    }
}
