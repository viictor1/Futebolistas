/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Model;

import Futebolistas.DAO.TimeDAO;
import Futebolistas.Enteties.Time;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maluc
 */
public class TimeModel {
    public void add(Time time) throws SQLException{
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
        dao.add(time);
    }
    public ArrayList<Time> selecionarTodos() throws SQLException{
        TimeDAO dao = new TimeDAO();
        return dao.selecionarTodos();
    }
    public void alterarTorcedores(String idTime, int num) throws SQLException{
        TimeDAO dao = new TimeDAO();
        dao.alterarTorcedores(idTime, num);
    }
    public Time getTimeByID(String id) throws SQLException{
        TimeDAO dao = new TimeDAO();
        Time t = dao.selectTimeByID(id);
        return t;
    }
    public void atualizarTime(Time t, String id) throws SQLException{
        TimeDAO dao = new TimeDAO();
        dao.atualizarTime(t, id);
    }
}
