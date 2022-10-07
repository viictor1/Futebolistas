package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
import Futebolistas.Enteties.Arquivo;
import Futebolistas.Enteties.Noticia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class NoticiaDAO {
    public void add(Noticia n, Arquivo arquivo) throws SQLException{
        ArquivoDAO dao = new ArquivoDAO();
        String sql = "INSERT INTO NOTICIAS (TITULO, AUTOR, TEXTO, IDARQUIVO) VALUES (?,?,?,?)";
        Connection connection = new ConnectionFactory().getConnection();
        try {
            connection.setAutoCommit(false);
            
            dao.add(connection, arquivo);
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, n.getTitulo());
            stmt.setString(2, n.getAutor());
            stmt.setString(3, n.getTexto());
            stmt.setInt(4, arquivo.getId());
            stmt.execute();
            stmt.close();
            connection.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            connection.rollback();
        } finally {
            connection.close();
        }
        
        
    }
    
    public void remover(int id) throws SQLException{
        ArquivoDAO dao = new ArquivoDAO();
        String sql = "DELETE FROM NOTICIAS WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        
        try {
            connection.setAutoCommit(false);
            Noticia n = getNoticiaByID(id);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            
            dao.remover(connection, n.getIdArquivo());
            connection.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            connection.rollback();
        } finally {
            connection.close();
        }
    }
    
    public Noticia getNoticiaByID(int id) throws SQLException{
        String sql = "SELECT ID, TITULO, AUTOR, TEXTO, IDARQUIVO FROM NOTICIAS WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Noticia n = new Noticia();
        
         if(rs.next()){ 
            n.setId(rs.getInt("ID"));
            n.setTitulo(rs.getString("TITULO"));
            n.setAutor(rs.getString("AUTOR"));
            n.setTexto(rs.getString("TEXTO"));
            n.setIdArquivo(rs.getInt("IDARQUIVO"));
        }
         
        stmt.close();
        connection.close();
        return n;
        
    }
    
    public ArrayList<Noticia> selecionarTodos() throws SQLException{
        ArrayList<Noticia> retorno = new ArrayList();
        String sql = "SELECT ID, TITULO, AUTOR, TEXTO, IDARQUIVO FROM NOTICIAS";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Noticia n = new Noticia();
            n.setId(rs.getInt("ID"));
            n.setTitulo(rs.getString("TITULO"));
            n.setAutor(rs.getString("AUTOR"));
            n.setTexto(rs.getString("TEXTO"));
            n.setIdArquivo(rs.getInt("IDARQUIVO"));
            retorno.add(n);
        }
        
        stmt.close();
        connection.close();
        return retorno;
    }
}
