/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Model;

import Futebolistas.DAO.TimeDAO;
import Futebolistas.Enteties.Arquivo;
import Futebolistas.Enteties.Time;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maluc
 */
public class TimeModel {
    public void add(Time time, Arquivo img) throws SQLException{
        TimeDAO dao = new TimeDAO();
        if(time.getNome() == null || time.getNome().equals("")){
            return;
        }
        if(time.getData_fundacao() == null || time.getData_fundacao().equals("")){
            return;
        }
        if(time.getTecnico() == null || time.getTecnico().equals("")){
            return;
        }
        if(time.getPresidente() == null || time.getPresidente().equals("")){
            return;
        }
        if(time.getLocal_fundacao() == null || time.getLocal_fundacao().equals("")){
            return;
        }
        if(time.getTitulos() < 0){
            return;
        }
        if(img.getConteudo().length == 0){
            return;
        }
        dao.add(time, img);
    }
    public ArrayList<Time> selecionarTodos() throws SQLException{
        TimeDAO dao = new TimeDAO();
        return dao.selecionarTodos();
    }
    public void alterarTorcedores(int idTime, int num) throws SQLException{
        TimeDAO dao = new TimeDAO();
        dao.alterarTorcedores(idTime, num);
    }
    public Time getTimeByID(int id) throws SQLException{
        TimeDAO dao = new TimeDAO();
        Time t = dao.selectTimeByID(id);
        return t;
    }
    public void atualizarTime(Time time, int id, Arquivo arquivo) throws SQLException{
        if(time.getNome() == null || time.getNome().equals("")){
            return;
        }
        if(time.getData_fundacao() == null || time.getData_fundacao().equals("")){
            return;
        }
        if(time.getTecnico() == null || time.getTecnico().equals("")){
            return;
        }
        if(time.getPresidente() == null || time.getPresidente().equals("")){
            return;
        }
        if(time.getLocal_fundacao() == null || time.getLocal_fundacao().equals("")){
            return;
        }
        if(time.getTitulos() < 0){
            return;
        }
        TimeDAO dao = new TimeDAO();
        dao.atualizarTime(time, id, arquivo);
    }
    
    public void remover(int id) throws SQLException{
        TimeDAO dao = new TimeDAO();
        UsuarioModel model = new UsuarioModel();
        model.removerTorcedores(id);
        dao.remover(id);
    }
}
