package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    

    public void add(Usuario u) throws SQLException{
        String sql = "INSERT INTO USUARIOS (NOME, EMAIL, SENHA, ISADMINISTRADOR) VALUES (?,?,?,?)";
        Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setBoolean(4, u.getIsAdministrador());
            
            stmt.execute();
            stmt.close();
            connection.close();   
    }
    
    public Usuario autenticar(String email, String senha) throws SQLException{
        String sql = "SELECT ID, NOME, EMAIL, ISADMINISTRADOR FROM USUARIOS WHERE EMAIL = ? AND SENHA = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, email);
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        Usuario u = null;
        if(rs.next()){
            u = new Usuario(rs.getInt("ID"), rs.getString("NOME"), rs.getString("EMAIL"), rs.getBoolean("ISADMINISTRADOR"));
        }
        stmt.close();
        connection.close();
        return u;
    } 
    
    public void remover(int id) throws SQLException{
        String sql = "DELETE FROM USUARIOS WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
        connection.close();
        
    }
    
    public Usuario selectUserbyID(int id) throws SQLException{
        String sql =  "SELECT ID, EMAIL, ISADMINISTRADOR, NOME FROM USUARIOS WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        Usuario u = null;
        if(rs.next()){
            u = new Usuario(rs.getInt("ID"), rs.getString("NOME"), rs.getString("EMAIL"), rs.getBoolean("ISADMINISTRADOR"));
        }
        stmt.close();
        connection.close();
        return u;
    }
    
    public Boolean verificarEmail(String email) throws SQLException{
        Boolean encontrado = false;
        
        String sql = "SELECT ID FROM USUARIOS WHERE EMAIL = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            encontrado = true;
        }
        stmt.close();
        connection.close();
        
        return encontrado;
    }
    
}

