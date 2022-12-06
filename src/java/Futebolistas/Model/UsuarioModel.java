/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Model;

import Futebolistas.CustomExceptions.ParameterException;
import Futebolistas.DAO.TimeDAO;
import Futebolistas.DAO.UsuarioDAO;
import Futebolistas.Enteties.Usuario;
import java.sql.SQLException;

public class UsuarioModel {
    public void add(Usuario u) throws SQLException, ParameterException{
        UsuarioDAO dao = new UsuarioDAO();        
        if(u.getNome() == null || u.getNome().equals("")){
            throw new ParameterException("Nome Obrigatório");
        }
        if(u.getEmail() == null || u.getEmail().equals("")){
            throw new ParameterException("Email Obrigatório");
        }
        if(u.getSenha() == null || u.getSenha().equals("")){
            throw new ParameterException("Senha Obrigatório");
        }   
        if(dao.verificarEmail(u.getEmail()) == true){
            throw new ParameterException("Email já cadastrado");
        }
        if(u.getTime() == 0){
            throw new ParameterException("Time Obrigatório");
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
    
    public Usuario autenticar(String email, String senha) throws SQLException, ParameterException{
        UsuarioDAO dao = new UsuarioDAO();
        if(email == null || email.equals("")){
            throw new ParameterException("Email Obrigatório");
        }
        if(senha == null || senha.equals("")){
            throw new ParameterException("Senha Obrigatório");
        } 
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
        daoU.alterarTime(id, id_novo, id_antigo);
    }
    
    public void removerTorcedores(int id) throws SQLException{ //remover todos os torcedores quando apagar time
        UsuarioDAO dao = new UsuarioDAO();
        dao.removerTorcedores(id);
    }
}