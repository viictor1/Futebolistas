package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Time;

/**
 *
 * @author victo
 */
public class JogoDAO {
    public void add(Jogo j) throws SQLException{
        String sql = "INSERT INTO JOGO (CAMPEONATO, TIME_VISITANTE, TIME_CASA, DATA_JOGO, FASE) VALUES (?,?,?,?,?)";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, j.getCampeonato());
        stmt.setInt(2, j.getTime_visitante());
        stmt.setInt(3, j.getTime_casa());
        stmt.setDate(4, j.getData_jogo());
        stmt.setString(5, j.getFase());
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
        String sql = "SELECT ID, TIME_VISITANTE, TIME_CASA, DATA_JOGO, FASE FROM JOGO WHERE GOL_CASA IS NULL";
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
            j.setFase(rs.getString("FASE"));
            retorno.add(j);
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
        String sql = "SELECT ID, TIME_VISITANTE, TIME_CASA, DATA_JOGO, FASE FROM JOGO WHERE ID = ?";
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
            j.setFase(rs.getString("FASE"));
        }
        
        stmt.close();
        connection.close();
        return j;
    }
    
    public int partidasJogadas(int idTime) throws SQLException{
        String sql = "SELECT ID, FASE FROM JOGO WHERE TIME_CASA = ? AND GOL_CASA IS NOT NULL";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idTime);      
        ResultSet rs = stmt.executeQuery();
        int num = 0;
        
        while(rs.next()){
            if("Primeira Fase".equals(rs.getString("FASE"))){
                num++;
            }
            
        }
        stmt.close();
        
        String sql2 = "SELECT ID, FASE FROM JOGO WHERE TIME_VISITANTE = ? AND GOL_VISITANTE IS NOT NULL";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt2.setInt(1, idTime);
        ResultSet rs2 = stmt2.executeQuery();
        while(rs2.next()){
            if("Primeira Fase".equals(rs2.getString("FASE"))){
                num++;
            }
            
        }
        stmt2.close();
        connection.close();
        return num;
    }
    
    public int vitorias(int idTime) throws SQLException{
        String sql = "SELECT ID, GOL_CASA, GOL_VISITANTE, FASE FROM JOGO WHERE TIME_CASA = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idTime);      
        ResultSet rs = stmt.executeQuery();
        int vitorias = 0;
        while(rs.next()){
            if(rs.getInt("GOL_CASA") > rs.getInt("GOL_VISITANTE")){
                if("Primeira Fase".equals(rs.getString("FASE"))){
                vitorias++;
            }
                
            }
        }
        stmt.close();
        
        String sql2 = "SELECT ID, GOL_CASA, GOL_VISITANTE, FASE FROM JOGO WHERE TIME_VISITANTE = ?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt2.setInt(1, idTime);
        ResultSet rs2 = stmt2.executeQuery();
        while(rs2.next()){
            if(rs2.getInt("GOL_CASA") < rs2.getInt("GOL_VISITANTE")){
                if("Primeira Fase".equals(rs2.getString("FASE"))){
                 vitorias++;
            }
               
            }
        }
        stmt2.close();
        connection.close();
        return vitorias;
    }
    
    public int empates(int idTime) throws SQLException{
        String sql = "SELECT ID, GOL_CASA, GOL_VISITANTE, FASE FROM JOGO WHERE TIME_CASA = ? OR TIME_VISITANTE = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idTime); 
        stmt.setInt(2, idTime);
        ResultSet rs = stmt.executeQuery();
        int empates = 0;
        while(rs.next()){
            if(rs.getInt("GOL_CASA") != 0 && rs.getInt("GOL_VISITANTE") != 0){
                if(rs.getInt("GOL_CASA") == rs.getInt("GOL_VISITANTE")){
                    if("Primeira Fase".equals(rs.getString("FASE"))){
                        empates++;
                    }
                
                }
            }
            
        }
        stmt.close();
        connection.close();
        return empates;
    }
    
    public int derrotas(int idTime) throws SQLException{
        String sql = "SELECT ID, GOL_CASA, GOL_VISITANTE, FASE FROM JOGO WHERE TIME_CASA = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idTime);      
        ResultSet rs = stmt.executeQuery();
        int derrotas = 0;
        while(rs.next()){
            if(rs.getInt("GOL_CASA") < rs.getInt("GOL_VISITANTE")){
                if("Primeira Fase".equals(rs.getString("FASE"))){
                    derrotas++;
                }
                
            }
        }
        stmt.close();
        
        String sql2 = "SELECT ID, GOL_CASA, GOL_VISITANTE, FASE FROM JOGO WHERE TIME_VISITANTE = ?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt2.setInt(1, idTime);
        ResultSet rs2 = stmt2.executeQuery();
        while(rs2.next()){
            if(rs2.getInt("GOL_CASA") > rs2.getInt("GOL_VISITANTE")){
                if("Primeira Fase".equals(rs2.getString("FASE"))){
                    derrotas++;
                }
                
            }
        }
        stmt2.close();
        connection.close();
        return derrotas;
    }
    
    public int golsMarcados(int idTime) throws SQLException{
        String sql = "SELECT ID, GOL_CASA, FASE FROM JOGO WHERE TIME_CASA = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idTime);      
        ResultSet rs = stmt.executeQuery();
        int gols = 0;
        while(rs.next()){
            if("Primeira Fase".equals(rs.getString("FASE"))){
                gols += rs.getInt("GOL_CASA");
            }
            
        }
        stmt.close();
        
        String sql2 = "SELECT ID, GOL_VISITANTE, FASE FROM JOGO WHERE TIME_VISITANTE = ?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt2.setInt(1, idTime);
        ResultSet rs2 = stmt2.executeQuery();
        while(rs2.next()){
            if("Primeira Fase".equals(rs2.getString("FASE"))){
                gols += rs2.getInt("GOL_VISITANTE");
            }
            
        }
        stmt2.close();
        connection.close();
        
        return gols;
    }
    
    public int golsSofridos(int idTime) throws SQLException{
        String sql = "SELECT ID, GOL_VISITANTE, FASE FROM JOGO WHERE TIME_CASA = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idTime);      
        ResultSet rs = stmt.executeQuery();
        int gols = 0;
        while(rs.next()){
            if("Primeira Fase".equals(rs.getString("FASE"))){
                gols += rs.getInt("GOL_VISITANTE");
            }
            
        }
        stmt.close();
        
        String sql2 = "SELECT ID, GOL_CASA, FASE FROM JOGO WHERE TIME_VISITANTE = ?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt2.setInt(1, idTime);
        ResultSet rs2 = stmt2.executeQuery();
        while(rs2.next()){
            if("Primeira Fase".equals(rs2.getString("FASE"))){
                gols += rs2.getInt("GOL_CASA");
            }
            
        }
        stmt2.close();
        connection.close();
        
        return gols;
    }
    
    public ArrayList<Jogo> selectHistorico() throws SQLException{
        String sql = "SELECT ID, TIME_VISITANTE, TIME_CASA, DATA_JOGO, FASE, GOL_CASA, GOL_VISITANTE FROM JOGO WHERE GOL_CASA IS NOT NULL";
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
            j.setFase(rs.getString("FASE"));
            j.setGol_casa(rs.getInt("GOL_CASA"));
            j.setGol_visitante(rs.getInt("GOL_VISITANTE"));
            retorno.add(j);
        }
        
        stmt.close();
        connection.close();
        return retorno;
    }
}
