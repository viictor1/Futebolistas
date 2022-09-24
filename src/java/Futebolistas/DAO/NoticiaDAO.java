package Futebolistas.DAO;

import Futebolistas.Connections.ConnectionFactory;
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
    public void add(Noticia n) throws SQLException{
        String sql = "INSERT INTO NOTICIAS (TITULO, AUTOR, TEXTO) VALUES (?,?,?)";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, n.getTitulo());
        stmt.setString(2, n.getAutor());
        stmt.setString(3, n.getTexto());
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public ArrayList<Noticia> selecionarTodos() throws SQLException{
        ArrayList<Noticia> retorno = new ArrayList();
        String sql = "SELECT ID, TITULO, AUTOR, TEXTO FROM NOTICIAS";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Noticia n = new Noticia();
            n.setId(rs.getInt("ID"));
            n.setTitulo(rs.getString("TITULO"));
            n.setAutor(rs.getString("AUTOR"));
            n.setTexto(rs.getString("TEXTO"));
            retorno.add(n);
        }
        
        stmt.close();
        connection.close();
        return retorno;
    }
}
