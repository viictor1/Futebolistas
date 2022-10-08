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
    
    public void removerTodosDoVencedor(int id) throws SQLException{
        String sql = "DELETE FROM CAMPEONATOANTIGO WHERE VENCEDOR = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        connection.close();
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
    
    public Boolean verificarAno(int ano) throws SQLException{ // pra nao poder cadastrar 2 titulos no mesmo ano
        Boolean encontrado = false;
        String sql = "SELECT ID FROM CAMPEONATOANTIGO WHERE ANO = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, ano);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            encontrado = true;
        }
        stmt.close();
        connection.close();
        return encontrado;
    }
}