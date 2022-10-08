package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.CampeonatoAntigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class CampeonatoAntigoDAO{
    
    public void add (CampeonatoAntigo ca) throws SQLException {
    String sql = "INSERT INTO CAMPEONATOANTIGO (ANO, VENCEDOR) VALUES (?,?)";
    Connection connection = new ConnectionFactory().getConnection();
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setInt(1, ca.getAno());
    stmt.setInt(2, ca.getVencedor());
    stmt.execute();
    stmt.close();
    connection.close();
    }
    
    public ArrayList<CampeonatoAntigo> selecionarTodos() throws SQLException{
        String sql = "SELECT ID, ANO, VENCEDOR FROM CAMPEONATOANTIGO";
        ArrayList<CampeonatoAntigo> retorno = new ArrayList();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            CampeonatoAntigo ca = new CampeonatoAntigo();
            ca.setId(rs.getInt("ID"));
            ca.setAno(rs.getInt("ANO"));
            ca.setVencedor(rs.getInt("VENCEDOR"));
            retorno.add(ca);
        }
        stmt.close();
        connection.close();
        return retorno;
    }
}