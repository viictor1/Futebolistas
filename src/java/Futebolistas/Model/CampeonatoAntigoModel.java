package Futebolistas.Model;

import Futebolistas.DAO.CampeonatoAntigoDAO;
import Futebolistas.Enteties.CampeonatoAntigo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class CampeonatoAntigoModel {
    public void add(CampeonatoAntigo ca) throws SQLException{
        CampeonatoAntigoDAO dao = new CampeonatoAntigoDAO();
        dao.add(ca);
    }
    
    public ArrayList<CampeonatoAntigo> selecionarTodos() throws SQLException{
        CampeonatoAntigoDAO dao = new CampeonatoAntigoDAO();
        return dao.selecionarTodos();
    }
}
