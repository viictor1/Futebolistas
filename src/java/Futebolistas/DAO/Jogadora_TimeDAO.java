package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.Jogadora;
import Futebolistas.Enteties.Jogadora_Time;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class Jogadora_TimeDAO {
    public void add(Jogadora_Time jt) throws SQLException{
        String sql = "INSERT INTO JOGADORA_TIME (ID_TIME, ID_JOGADORA, DATA_INICIO, NUMERO_ATUAL, POSICAO) VALUES (?,?,?,?,?)";
        JogadoraDAO dao = new JogadoraDAO();
        Connection connection = new ConnectionFactory().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement(sql);
        
            stmt.setInt(1, jt.getId_time());
            stmt.setInt(2, jt.getId_jogadora());
            stmt.setDate(3, jt.getData_inicio());;
            stmt.setInt(4, jt.getNumero_atual());
            stmt.setString(5, jt.getPosicao());

            stmt.execute();
            stmt.close();
            dao.alterarAtividade(jt.getId_jogadora(), true, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }       
    }
    
    public void removerPorIDJ(Jogadora_Time jt) throws SQLException{
        String sql = "DELETE FROM JOGADORA_TIME WHERE ID_JOGADORA = ?";
        JogadoraDAO dao = new JogadoraDAO();
        Connection connection = new ConnectionFactory().getConnection();
        try {
            connection.setAutoCommit(false);
            dao.alterarAtividade(jt.getId_jogadora(), false, connection);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, jt.getId_jogadora());
            stmt.execute();
            stmt.close();         
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }           
    }
    
    public void removerPorIDT(Jogadora_Time jt) throws SQLException{
        String sql = "DELETE FROM JOGADORA_TIME WHERE ID_TIME = ?";
        JogadoraDAO dao = new JogadoraDAO();
        Connection connection = new ConnectionFactory().getConnection();
        try {
            connection.setAutoCommit(false);
            dao.alterarAtividade(jt.getId_jogadora(), false, connection);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, jt.getId_time());
            stmt.execute();
            stmt.close();         
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }           
    }
    
    public ArrayList<Jogadora_Time> selectAtuais(int id) throws SQLException{
        String sql = "SELECT ID, ID_TIME, ID_JOGADORA, DATA_INICIO, DATA_FIM, NUMERO_ATUAL, POSICAO FROM JOGADORA_TIME WHERE ID_TIME = ? AND DATA_FIM IS NULL";
        ArrayList<Jogadora_Time> retorno = new ArrayList();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Jogadora_Time jt = new Jogadora_Time();
            jt.setId(rs.getInt("ID"));
            jt.setId_time(rs.getInt("ID_TIME"));
            jt.setId_jogadora(rs.getInt("ID_JOGADORA"));
            jt.setData_inicio(rs.getDate("DATA_INICIO"));
            jt.setData_fim(rs.getDate("DATA_FIM"));
            jt.setPosicao(rs.getString("POSICAO"));
            jt.setNumero_atual(rs.getInt("NUMERO_ATUAL"));
            retorno.add(jt);
        }
        stmt.close();
        connection.close();
        return retorno;   
    }
    
    public Jogadora_Time getJTByID(int id) throws SQLException{
        String sql = "SELECT ID, ID_TIME, ID_JOGADORA, DATA_INICIO, DATA_FIM, NUMERO_ATUAL, POSICAO FROM JOGADORA_TIME WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        Jogadora_Time jt = new Jogadora_Time();
        while(rs.next()){
            jt.setId(rs.getInt("ID"));
            jt.setId_time(rs.getInt("ID_TIME"));
            jt.setId_jogadora(rs.getInt("ID_JOGADORA"));
            jt.setData_inicio(rs.getDate("DATA_INICIO"));
            jt.setData_fim(rs.getDate("DATA_FIM"));
            jt.setPosicao(rs.getString("POSICAO"));
            jt.setNumero_atual(rs.getInt("NUMERO_ATUAL"));

        }
        stmt.close();
        connection.close();
        return jt;   
    }
    
    public void editar(Jogadora_Time jt) throws SQLException{
        String sql = "UPDATE JOGADORA_TIME SET DATA_FIM = ?, NUMERO_ATUAL = ?, POSICAO = ? WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        try {
            connection.setAutoCommit(false);
            stmt.setDate(1, jt.getData_fim());
            stmt.setInt(2, jt.getNumero_atual());
            stmt.setString(3, jt.getPosicao());
            stmt.setInt(4, jt.getId());
            stmt.execute();
            stmt.close();
            if(jt.getData_fim() != null){
                JogadoraDAO dao = new JogadoraDAO();
                dao.alterarAtividade(jt.getId_jogadora(), false, connection);
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }
        
        
        
    }

}
