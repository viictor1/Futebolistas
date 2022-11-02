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
        if(time.getNome() == null || ("").equals(time.getNome())){
            return;
        }
        if(time.getData_fundacao() == null || ("").equals(time.getData_fundacao())){
            return;
        }
        if(time.getTecnico() == null || ("").equals(time.getTecnico())){
            return;
        }
        if(time.getPresidente() == null || ("").equals(time.getPresidente())){
            return;
        }
        if(time.getLocal_fundacao() == null || ("").equals( time.getLocal_fundacao())){
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
    
    public void atualizarTorcedores(int idTime) throws SQLException{
        TimeDAO dao = new TimeDAO();
        dao.atualizarTorcedores(idTime);
    }
    
    public void atualizarTitulos(int idTime) throws SQLException{
        TimeDAO dao = new TimeDAO();
        dao.atualizarTitulos(idTime);
    }
    
    public Time getTimeByID(int id) throws SQLException{
        TimeDAO dao = new TimeDAO();
        Time t = dao.selectTimeByID(id);
        return t;
    }
    public void atualizarTime(Time time, int id, Arquivo arquivo) throws SQLException{
        if(time.getNome() == null || ("").equals(time.getNome())){
            return;
        }
        if(time.getData_fundacao() == null || ("").equals(time.getData_fundacao())){
            return;
        }
        if(time.getTecnico() == null || ("").equals(time.getTecnico())){
            return;
        }
        if(time.getPresidente() == null || ("").equals(time.getPresidente())){
            return;
        }
        if(time.getLocal_fundacao() == null || ("").equals( time.getLocal_fundacao())){
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
    
    public ArrayList<Time> selecionarParticipantes() throws SQLException{
        TimeDAO dao = new TimeDAO();
        return dao.selecionarParticipantes();
    }
    
    public void alterarPosicao(Time t) throws SQLException{
        TimeDAO dao = new TimeDAO();
        dao.alterarPosicao(t);
    }
    
    public void sairDaCompeticao(int id) throws SQLException{
        TimeDAO dao = new TimeDAO();
        dao.sairDaCompeticao(id);
    }
}
