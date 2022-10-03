package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.Arquivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author victo
 */
public class ArquivoDAO {
    public void add(Connection connection, Arquivo arquivo) throws SQLException{
        String sql = "INSERT INTO ARQUIVOS (CONTEUDO, MIMETYPE) VALUES (?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setBytes(1, arquivo.getConteudo());
        stmt.setString(2, arquivo.getMimetype());      
        int rows = stmt.executeUpdate();
        
        if(rows == 0){
            throw new SQLException("ERRO AO CRIAR ARQUIVO!");
        }
        else{
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                arquivo.setId(rs.getInt(1));
            }
            else{
                throw new SQLException("ERRO AO OBTER ID DO ARQUIVO!");
            }
        }
    }
    
    public Arquivo getArquivoByID(int id) throws SQLException{
        String sql = "SELECT IDARQUIVO, CONTEUDO, MIMETYPE FROM ARQUIVOS WHERE IDARQUIVO = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Arquivo arquivo = new Arquivo();

        if(rs.next()){
            arquivo.setId(rs.getInt("IDARQUIVO"));
            arquivo.setConteudo(rs.getBytes("CONTEUDO"));
            arquivo.setMimetype(rs.getString("MIMETYPE"));
        }
        
        return arquivo;
    }
}
