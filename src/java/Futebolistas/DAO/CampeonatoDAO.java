package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.Campeonato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class CampeonatoDAO{
    
    public void add (Campeonato ca) throws SQLException {
        String sql = "";
        Connection connection = new ConnectionFactory().getConnection();
        if(ca.getVencedor() != 0){
            sql = "INSERT INTO CAMPEONATO (ANO, VENCEDOR) VALUES (?,?)";
        }else{
            sql = "INSERT INTO CAMPEONATO (ANO) VALUES (?)";
            
            String sql2 = "UPDATE TIMES SET POSICAO = 1";
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.execute();
            stmt2.close();
        }
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, ca.getAno());
        if(ca.getVencedor() != 0){
             stmt.setInt(2, ca.getVencedor());
        }
        stmt.execute();
        stmt.close();

        connection.close();                
    }
    
    public void remover(Campeonato ca) throws SQLException{
        String sql = "DELETE FROM CAMPEONATO WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, ca.getId());
        stmt.execute();
        stmt.close();
        connection.close();         
    }
    
    public void removerTodosDoVencedor(int id) throws SQLException{
        String sql = "DELETE FROM CAMPEONATO WHERE VENCEDOR = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public Campeonato selectCabyID(int id) throws SQLException{
        String sql = "SELECT ID, ANO, VENCEDOR FROM CAMPEONATO WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);    
        ResultSet rs = stmt.executeQuery();
        
        Campeonato ca = new Campeonato();
        if(rs.next()){
            ca.setId(rs.getInt("ID"));
            ca.setAno(rs.getInt("ANO"));
            ca.setVencedor(rs.getInt("VENCEDOR"));
        }
        stmt.close();
        connection.close();
        return ca;
    }
    
     public Campeonato selectAtual() throws SQLException{
        String sql = "SELECT ID, ANO FROM CAMPEONATO WHERE VENCEDOR IS NULL";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql); 
        ResultSet rs = stmt.executeQuery();
        
        Campeonato ca = new Campeonato();
        if(rs.next()){
            ca.setId(rs.getInt("ID"));
            ca.setAno(rs.getInt("ANO"));
        }
        stmt.close();
        connection.close();
        return ca;
    }
    
    public ArrayList<Campeonato> selecionarTodos() throws SQLException{
        String sql = "SELECT ID, ANO, VENCEDOR FROM CAMPEONATO WHERE VENCEDOR IS NOT NULL ORDER BY ANO DESC";
        ArrayList<Campeonato> retorno = new ArrayList();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Campeonato ca = new Campeonato();
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
        String sql = "SELECT ID FROM CAMPEONATO WHERE ANO = ?";
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