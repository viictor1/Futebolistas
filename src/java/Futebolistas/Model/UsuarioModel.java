/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Model;

import Futebolistas.DAO.TimeDAO;
import Futebolistas.DAO.UsuarioDAO;
import Futebolistas.Enteties.Usuario;
import java.sql.SQLException;

public class UsuarioModel {
    public void add(Usuario u) throws SQLException{
        UsuarioDAO dao = new UsuarioDAO();        
        if(u.getNome() == null || u.getNome().equals("")){
            return;
        }
        if(u.getEmail() == null || u.getEmail().equals("")){
            return;
        }
        if(u.getSenha() == null || u.getSenha().equals("")){
            return;
        }   
        if(dao.verificarEmail(u.getEmail()) == true){
            return;
        }
        if(u.getTime() == 0){
            return;
        }
        dao.add(u);   
    }
    
    public void alterarSenha(int id, String senha) throws SQLException{
        UsuarioDAO dao = new UsuarioDAO();
        if(senha == null || senha.equals("")){
            return;
        }
        dao.alterarSenha(id, senha);
    }
    
    public Usuario autenticar(String email, String senha) throws SQLException{
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.autenticar(email, senha);
        return u;
    }
    
    public void remover(int id) throws SQLException{
        UsuarioDAO dao = new UsuarioDAO();
        dao.remover(selectUsuariobyID(id));      
    }
    
    public Usuario selectUsuariobyID(int id) throws SQLException{
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.selectUserbyID(id);
        return u;
    }
    
    public void alterarTime(int id, int id_antigo, int id_novo) throws SQLException{
        UsuarioDAO daoU = new UsuarioDAO();
        TimeDAO daoT = new TimeDAO();
        daoU.alterarTime(id, id_novo);
        if(id_antigo != 0 && daoT.getNumTorcedores(id_antigo) > 0){
            daoT.alterarTorcedores(id_antigo, -1);
        }   
        daoT.alterarTorcedores(id_novo, 1);
    }
    
    public void removerTorcedores(int id) throws SQLException{ //remover todos os torcedores quando apagar time
        UsuarioDAO dao = new UsuarioDAO();
        dao.removerTorcedores(id);
    }
}