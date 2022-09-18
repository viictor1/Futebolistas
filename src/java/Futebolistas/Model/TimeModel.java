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
        dao.add(time);
    }
    public ArrayList<Time> selecionarTodos() throws SQLException{
        TimeDAO dao = new TimeDAO();
        return dao.selecionarTodos();
    }
}
