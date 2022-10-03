package Futebolistas.Model;

import Futebolistas.DAO.ArquivoDAO;
import Futebolistas.Enteties.Arquivo;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class ArquivoModel {
    public Arquivo getArquivoByID(int id) throws SQLException{
        ArquivoDAO dao = new ArquivoDAO();
        return dao.getArquivoByID(id);
    }
}
