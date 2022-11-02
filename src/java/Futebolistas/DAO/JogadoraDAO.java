package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.Jogadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class JogadoraDAO {
    public void add(Jogadora j) throws SQLException{
        String sql = "INSERT INTO JOGADORAS (NOME, ATIVA) VALUES (?,?)";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, j.getNome());
        stmt.setBoolean(2, false);
        
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public ArrayList<Jogadora> selecionarLivres() throws SQLException{ // selecionar todas as jogadoras que não estão em um time
        String sql = "SELECT ID, NOME, ATIVA FROM JOGADORAS WHERE ATIVA = FALSE ORDER BY NOME";
        ArrayList<Jogadora> retorno = new ArrayList();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Jogadora j = new Jogadora();
            j.setId(rs.getInt("ID"));
            j.setNome(rs.getString("NOME"));
            j.setAtiva(rs.getBoolean("ATIVA"));
            retorno.add(j);
        }
        stmt.close();
        connection.close();
        return retorno;
    }
    
    public ArrayList<Jogadora> selecionarTodas() throws SQLException{
        String sql = "SELECT ID, NOME, ATIVA FROM JOGADORAS ORDER BY NOME";
        ArrayList<Jogadora> retorno = new ArrayList();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Jogadora j = new Jogadora();
            j.setId(rs.getInt("ID"));
            j.setNome(rs.getString("NOME"));
            j.setAtiva(rs.getBoolean("ATIVA"));
            retorno.add(j);
        }
        stmt.close();
        connection.close();
        return retorno;
    }
    
    public Jogadora getJogadoraByID(int id) throws SQLException{ 
        String sql = "SELECT ID, NOME, ATIVA FROM JOGADORAS WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Jogadora j = new Jogadora();
        if(rs.next()){
            j.setId(rs.getInt("ID"));
            j.setNome(rs.getString("NOME"));
            j.setAtiva(rs.getBoolean("ATIVA"));
        }
        stmt.close();
        connection.close();
        return j;
    }
    
    public void remover(int id) throws SQLException{
        String sql = "DELETE FROM JOGADORAS WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public void atualizarAtividade(int id) throws SQLException{
        String sql = "UPDATE JOGADORAS SET ATIVA = ? WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setBoolean(1, verificarAtividade(id, connection));
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public Boolean verificarAtividade(int id, Connection connection) throws SQLException{
        String sql = "SELECT ID FROM JOGADORA_TIME WHERE ID_JOGADORA = ? AND DATA_FIM IS NULL";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Boolean retorno;
        
        if(rs.next()){
            retorno = true;
        }
        else{
            retorno = false;
        }
        stmt.close();
        return retorno;
    }
   
}
