/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Controllers.Times;
import Futebolistas.Enteties.Arquivo;
import Futebolistas.Enteties.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maluc
 */
public class TimeDAO {
    public void add(Time time, Arquivo img) throws SQLException{
        ArquivoDAO dao = new ArquivoDAO();    
        Connection connection = new ConnectionFactory().getConnection();
        try {
            connection.setAutoCommit(false);                      
            
            dao.add(connection, img);
            
            String sql = "INSERT INTO TIMES (NOME, DATA_FUNDACAO, TECNICO, PRESIDENTE, LOCAL_FUNDACAO, TITULOS, NUM_TORCEDORES, IDARQUIVO) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, time.getNome());
            stmt.setString(2, time.getData_fundacao());
            stmt.setString(3, time.getTecnico());
            stmt.setString(4, time.getPresidente());
            stmt.setString(5, time.getLocal_fundacao());
            stmt.setInt(6, time.getTitulos());
            stmt.setInt(7, 0);
            stmt.setInt(8, img.getId());
            
            stmt.execute();
            stmt.close();
            connection.commit();
            
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }       
    }
    
    public void remover(int id) throws SQLException{
        ArquivoDAO dao = new ArquivoDAO(); 
        Connection connection = new ConnectionFactory().getConnection();
        try {
            connection.setAutoCommit(false);
            Time t = selectTimeByID(id);
            String sql = "DELETE FROM TIMES WHERE IDTIME = ?";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            
            dao.remover(connection, t.getIdArquivo());    
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            connection.rollback();
        } finally {
            connection.close();
        }        
    }
    
    public ArrayList<Time> selecionarTodos() throws SQLException{
        String sql = "SELECT IDTIME, NOME, DATA_FUNDACAO, TECNICO, PRESIDENTE, LOCAL_FUNDACAO, TITULOS, NUM_TORCEDORES, IDARQUIVO FROM TIMES";
        ArrayList<Time> retorno = new ArrayList();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Time t = new Time();
            t.setId(rs.getInt("IDTIME"));
            t.setNome(rs.getString("NOME"));
            t.setData_fundacao(rs.getString("DATA_FUNDACAO"));
            t.setTecnico(rs.getString("TECNICO"));
            t.setPresidente(rs.getString("PRESIDENTE"));
            t.setLocal_fundacao(rs.getString("LOCAL_FUNDACAO"));
            t.setTitulos(rs.getInt("TITULOS"));
            t.setNum_torcedores(rs.getInt("NUM_TORCEDORES"));
            t.setIdArquivo(rs.getInt("IDARQUIVO"));
            retorno.add(t);
        }
        stmt.close();
        connection.close();
        return retorno;      
    }
    
    public void alterarTorcedores(int id, int num) throws SQLException{
        String sql = "UPDATE TIMES SET NUM_TORCEDORES = ? WHERE IDTIME = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, (getNumTorcedores(id) + num));
        stmt.setInt(2, id);
        
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public int getNumTorcedores(int id) throws SQLException{
        String sql = "SELECT NUM_TORCEDORES FROM TIMES WHERE IDTIME = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        int num = 0;
        
        if(rs.next()){
            num = rs.getInt("NUM_TORCEDORES");
        }
        connection.close();
        return num;
    }
    
    public void atualizarTime(Time t, int id, Arquivo arquivo) throws SQLException{
        ArquivoDAO dao = new ArquivoDAO();
        Connection connection = new ConnectionFactory().getConnection();
        try {
            connection.setAutoCommit(false);
            dao.alterar(connection, arquivo);
            String sql = "UPDATE TIMES SET NOME = ?, DATA_FUNDACAO = ?, TECNICO = ?, PRESIDENTE = ?, LOCAL_FUNDACAO = ?, TITULOS = ? WHERE IDTIME = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getData_fundacao());
            stmt.setString(3, t.getTecnico());
            stmt.setString(4, t.getPresidente());
            stmt.setString(5, t.getLocal_fundacao());
            stmt.setInt(6, t.getTitulos());
            stmt.setInt(7, id);
            
            stmt.execute();
            stmt.close();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }             
    }
    
    public Time selectTimeByID(int id) throws SQLException{
        String sql = "SELECT IDTIME, NOME, DATA_FUNDACAO, TECNICO, PRESIDENTE, LOCAL_FUNDACAO, TITULOS, NUM_TORCEDORES, IDARQUIVO FROM TIMES WHERE IDTIME = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Time t = new Time();
        
        if(rs.next()){
            t.setId(rs.getInt("IDTIME"));
            t.setNome(rs.getString("NOME"));
            t.setData_fundacao(rs.getString("DATA_FUNDACAO"));
            t.setTecnico(rs.getString("TECNICO"));
            t.setPresidente(rs.getString("PRESIDENTE"));
            t.setLocal_fundacao(rs.getString("LOCAL_FUNDACAO"));
            t.setTitulos(rs.getInt("TITULOS"));
            t.setNum_torcedores(rs.getInt("NUM_TORCEDORES"));
            t.setIdArquivo(rs.getInt("IDARQUIVO"));
        }
        stmt.close();
        connection.close();
        return t;
    }
    
}
