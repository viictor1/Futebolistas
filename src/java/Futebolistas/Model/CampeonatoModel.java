package Futebolistas.Model;

import Futebolistas.DAO.CampeonatoDAO;
import Futebolistas.Enteties.Campeonato;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author victo
 */
public class CampeonatoModel {
    public void add(Campeonato ca) throws SQLException{
        CampeonatoDAO dao = new CampeonatoDAO();
        Calendar cal = GregorianCalendar.getInstance();
        if(dao.verificarAno(ca.getAno()) == true){
            return;
        }
        if(ca.getAno() != cal.get(Calendar.YEAR)){ // se o ano digitado não for o atual
            if(ca.getVencedor() == 0){
                return;
            }
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
    
    public Campeonato selectAtual() throws SQLException{
        CampeonatoDAO dao = new CampeonatoDAO();
        return dao.selectAtual();
    }
}
