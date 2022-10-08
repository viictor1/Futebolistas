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
        try {
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ca.getAno());
            stmt.setInt(2, ca.getVencedor());
            stmt.execute();
            stmt.close();

            TimeDAO dao = new TimeDAO();
            dao.alterarTitulos(ca.getVencedor(), 1);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }
        
        
    }
    
    public void remover(CampeonatoAntigo ca) throws SQLException{
        String sql = "DELETE FROM CAMPEONATOANTIGO WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        try {
            connection.setAutoCommit(false);
            stmt.setInt(1, ca.getId());
            stmt.execute();
            stmt.close();
            TimeDAO dao = new TimeDAO();

            dao.alterarTitulos(ca.getVencedor(), -1);
            
            connection.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            connection.rollback();
        } finally {
            connection.close(); 
        }
        
           
    }
    
    public CampeonatoAntigo selectCabyID(int id) throws SQLException{
        String sql = "SELECT ID, ANO, VENCEDOR FROM CAMPEONATOANTIGO WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);    
        ResultSet rs = stmt.executeQuery();
        
        CampeonatoAntigo ca = new CampeonatoAntigo();
        if(rs.next()){
            ca.setId(rs.getInt("ID"));
            ca.setAno(rs.getInt("ANO"));
            ca.setVencedor(rs.getInt("VENCEDOR"));
        }
        stmt.close();
        connection.close();
        return ca;
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