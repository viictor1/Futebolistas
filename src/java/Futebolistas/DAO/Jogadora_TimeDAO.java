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
    
    public ArrayList<Jogadora_Time> selectAtuais(int id) throws SQLException{
        String sql = "SELECT ID, ID_TIME, ID_JOGADORA, DATA_INICIO, DATA_FIM, NUMERO_ATUAL, POSICAO FROM JOGADORA_TIME WHERE ID_TIME = ?";
        ArrayList<Jogadora_Time> retorno = new ArrayList();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Jogadora_Time jt = new Jogadora_Time();
            jt.setId(rs.getInt("ID"));
            jt.setId_time(rs.getInt("ID_TIME"));
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
    

}
