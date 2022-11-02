/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Controllers.Times;
import Futebolistas.Enteties.Arquivo;
import Futebolistas.Enteties.Jogadora;
import Futebolistas.Enteties.Jogadora_Time;
import Futebolistas.Enteties.Time;
import Futebolistas.Model.JogadoraModel;
import Futebolistas.Model.Jogadora_TimeModel;
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
            String sql = "INSERT INTO TIMES (NOME, DATA_FUNDACAO, TECNICO, PRESIDENTE, LOCAL_FUNDACAO, NUM_TORCEDORES, TITULOS, IDARQUIVO) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, time.getNome());
            stmt.setDate(2, time.getData_fundacao());
            stmt.setString(3, time.getTecnico());
            stmt.setString(4, time.getPresidente());
            stmt.setString(5, time.getLocal_fundacao());
            stmt.setInt(6, 0);
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
        CampeonatoDAO daoC = new CampeonatoDAO();
        Connection connection = new ConnectionFactory().getConnection();
        Jogadora_TimeDAO daoJT = new Jogadora_TimeDAO();
        Jogadora_TimeModel model = new Jogadora_TimeModel();
        JogadoraDAO daoJ = new JogadoraDAO();
        ArrayList<Jogadora_Time> array = new ArrayList();
        try {
            connection.setAutoCommit(false);
            array = model.selectJogadoras(id);
            for(Jogadora_Time jogadora: array){
                daoJ.alterarAtividade(jogadora.getId_jogadora(), false, connection);               
            }
            String sql2 = "DELETE FROM JOGADORA_TIME WHERE ID_TIME = ?"; // apagando as jogadoras_time 
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setInt(1, id);
            stmt2.execute();
            stmt2.close();
            
            daoC.removerTodosDoVencedor(id);
            Time t = selectTimeByID(id); //removendo os campeonatos do time
            
            String sql3 = "DELETE FROM JOGO WHERE TIME_CASA = ? OR TIME_VISITANTE = ?";  //removendo os futuros jogos do time
            PreparedStatement stmt3 = connection.prepareStatement(sql3);
            stmt3.setInt(1, id);
            stmt3.setInt(2, id);
            stmt3.execute();
            stmt3.close();
            
                    
            String sql = "DELETE FROM TIMES WHERE IDTIME = ?"; //apagando o time
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            
            dao.remover(connection, t.getIdArquivo());  // deletando o arquivo de imagem do time
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
        String sql = "SELECT IDTIME, NOME, DATA_FUNDACAO, TECNICO, PRESIDENTE, LOCAL_FUNDACAO, TITULOS, NUM_TORCEDORES, IDARQUIVO, POSICAO FROM TIMES ORDER BY NOME";
        ArrayList<Time> retorno = new ArrayList();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Time t = new Time();
            t.setId(rs.getInt("IDTIME"));
            t.setNome(rs.getString("NOME"));
            t.setData_fundacao(rs.getDate("DATA_FUNDACAO"));
            t.setTecnico(rs.getString("TECNICO"));
            t.setPresidente(rs.getString("PRESIDENTE"));
            t.setLocal_fundacao(rs.getString("LOCAL_FUNDACAO"));
            t.setTitulos(rs.getInt("TITULOS"));
            t.setNum_torcedores(rs.getInt("NUM_TORCEDORES"));
            t.setIdArquivo(rs.getInt("IDARQUIVO"));
            t.setPosicao(rs.getInt("POSICAO"));
            retorno.add(t);
        }
        stmt.close();
        connection.close();
        return retorno;      
    }
    
    public void atualizarTorcedores(int id) throws SQLException{
        String sql = "UPDATE TIMES SET NUM_TORCEDORES = ? WHERE IDTIME = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, getNumTorcedores(id));
        stmt.setInt(2, id);
        
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public void atualizarTitulos(int id) throws SQLException{
        String sql = "UPDATE TIMES SET TITULOS = ? WHERE IDTIME = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, getNumTitulos(id));
        stmt.setInt(2, id);
        
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public int getNumTorcedores(int id) throws SQLException{
        String sql = "SELECT ID FROM USUARIOS WHERE IDTIME = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        int num = 0;
        
        while(rs.next()){
            num++;
        }
        return num;
  
    }
    
    public int getNumTitulos(int id) throws SQLException{
        String sql = "SELECT ID FROM CAMPEONATO WHERE VENCEDOR = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        int num = 0;
        
        while(rs.next()){
            num++;
        }
        
        return num;
    }
    
    public void atualizarTime(Time t, int id, Arquivo arquivo) throws SQLException{
        ArquivoDAO dao = new ArquivoDAO();
        Connection connection = new ConnectionFactory().getConnection();
        try {
            connection.setAutoCommit(false);
            dao.alterar(connection, arquivo);
            String sql = "UPDATE TIMES SET NOME = ?, DATA_FUNDACAO = ?, TECNICO = ?, PRESIDENTE = ?, LOCAL_FUNDACAO = ? WHERE IDTIME = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, t.getNome());
            stmt.setDate(2, t.getData_fundacao());
            stmt.setString(3, t.getTecnico());
            stmt.setString(4, t.getPresidente());
            stmt.setString(5, t.getLocal_fundacao());
            stmt.setInt(6, id);
            
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
        String sql = "SELECT IDTIME, NOME, DATA_FUNDACAO, TECNICO, PRESIDENTE, LOCAL_FUNDACAO, TITULOS, NUM_TORCEDORES, IDARQUIVO, POSICAO FROM TIMES WHERE IDTIME = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Time t = new Time();
        
        if(rs.next()){
            t.setId(rs.getInt("IDTIME"));
            t.setNome(rs.getString("NOME"));
            t.setData_fundacao(rs.getDate("DATA_FUNDACAO"));
            t.setTecnico(rs.getString("TECNICO"));
            t.setPresidente(rs.getString("PRESIDENTE"));
            t.setLocal_fundacao(rs.getString("LOCAL_FUNDACAO"));
            t.setTitulos(rs.getInt("TITULOS"));
            t.setNum_torcedores(rs.getInt("NUM_TORCEDORES"));
            t.setIdArquivo(rs.getInt("IDARQUIVO"));
            t.setPosicao(rs.getInt("POSICAO"));
        }
        stmt.close();
        connection.close();
        return t;
    }
    
    public ArrayList<Time> selecionarParticipantes() throws SQLException{
        String sql = "SELECT IDTIME, NOME, DATA_FUNDACAO, TECNICO, PRESIDENTE, LOCAL_FUNDACAO, TITULOS, NUM_TORCEDORES, IDARQUIVO, POSICAO FROM TIMES WHERE POSICAO IS NOT NULL ORDER BY POSICAO";
        ArrayList<Time> retorno = new ArrayList();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Time t = new Time();
            t.setId(rs.getInt("IDTIME"));
            t.setNome(rs.getString("NOME"));
            t.setData_fundacao(rs.getDate("DATA_FUNDACAO"));
            t.setTecnico(rs.getString("TECNICO"));
            t.setPresidente(rs.getString("PRESIDENTE"));
            t.setLocal_fundacao(rs.getString("LOCAL_FUNDACAO"));
            t.setTitulos(rs.getInt("TITULOS"));
            t.setNum_torcedores(rs.getInt("NUM_TORCEDORES"));
            t.setIdArquivo(rs.getInt("IDARQUIVO"));
            t.setPosicao(rs.getInt("POSICAO"));
            retorno.add(t);
        }
        stmt.close();
        connection.close();
        return retorno; 
    }
    
    public void alterarPosicao(Time t) throws SQLException{
        Connection connection = new ConnectionFactory().getConnection();
        
        String sql = "UPDATE TIMES SET POSICAO = ? WHERE IDTIME = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, t.getPosicao());
        stmt.setInt(2, t.getId());
        stmt.execute();
        stmt.close();
        
        String sql2 = "SELECT IDTIME, POSICAO FROM TIMES WHERE POSICAO > 0 AND IDTIME != ?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt2.setInt(1, t.getId());
        ResultSet rs = stmt2.executeQuery();
        while(rs.next()){
            Time t2 = new Time();
            t2.setId(rs.getInt("IDTIME"));
            if(rs.getInt("POSICAO") == t.getPosicao()){
                t2.setPosicao(rs.getInt("POSICAO") + 1);
                alterarPosicao(t2);
            }   
        }
        stmt2.close();        
        
    
        connection.close();
    }
}