package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class JogoDAO {
    public void add(Jogo j) throws SQLException{
        String sql = "INSERT INTO JOGO (CAMPEONATO, TIME_VISITANTE, TIME_CASA, DATA_JOGO) VALUES (?,?,?,?)";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, j.getCampeonato());
        stmt.setInt(2, j.getTime_visitante());
        stmt.setInt(3, j.getTime_casa());
        stmt.setDate(4, j.getData_jogo());
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public void remover(int id) throws SQLException{
        String sql = "DELETE FROM JOGO WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public ArrayList<Jogo> proximosJogos() throws SQLException{
        String sql = "SELECT ID, TIME_VISITANTE, TIME_CASA, DATA_JOGO FROM JOGO WHERE GOL_CASA IS NULL";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Jogo> retorno = new ArrayList();
        while(rs.next()){
            Jogo j = new Jogo();
            j.setId(rs.getInt("ID"));
            j.setTime_visitante(rs.getInt("TIME_VISITANTE"));
            j.setTime_casa(rs.getInt("TIME_CASA"));
            j.setData_jogo(rs.getDate("DATA_JOGO"));
        }
        
        stmt.close();
        connection.close();
        return retorno;
    }
    
    public void atualizar(Jogo j) throws SQLException{
        String sql = "UPDATE JOGO SET GOL_CASA = ?, GOL_VISITANTE = ? WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, j.getGol_casa());
        stmt.setInt(2, j.getGol_visitante());
        stmt.setInt(3, j.getId());
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public Jogo selectJogoByID(int id) throws SQLException{
        String sql = "SELECT ID, TIME_VISITANTE, TIME_CASA, DATA_JOGO FROM JOGO WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Jogo j = new Jogo();
        while(rs.next()){
            j.setId(rs.getInt("ID"));
            j.setTime_visitante(rs.getInt("TIME_VISITANTE"));
            j.setTime_casa(rs.getInt("TIME_CASA"));
            j.setData_jogo(rs.getDate("DATA_JOGO"));
        }
        
        stmt.close();
        connection.close();
        return j;
    }
}
