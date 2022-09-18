/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maluc
 */
public class TimeDAO {
    public void add(Time time) throws SQLException{
        String sql = "INSERT INTO TIMES (NOME, DATA_FUNDACAO, TECNICO, PRESIDENTE, LOCAL_FUNDACAO, TITULOS, NUM_TORCEDORES) VALUES (?,?,?,?,?,?,?)";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, time.getNome());
        stmt.setString(2, time.getData_fundacao());
        stmt.setString(3, time.getTecnico());
        stmt.setString(4, time.getPresidente());
        stmt.setString(5, time.getLocal_fundacao());
        stmt.setInt(6, time.getTitulos());
        stmt.setInt(7, 0);
        
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public ArrayList<Time> selecionarTodos() throws SQLException{
        String sql = "SELECT IDTIME, NOME, DATA_FUNDACAO, TECNICO, PRESIDENTE, LOCAL_FUNDACAO, TITULOS, NUM_TORCEDORES FROM TIMES";
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
            retorno.add(t);
        }
        stmt.close();
        connection.close();
        return retorno;      
    }
}