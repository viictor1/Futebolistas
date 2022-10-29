/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Enteties;

import java.sql.Date;

/**
 *
 * @author victo
 */
public class Jogo {
    private int id, campeonato, time_visitante, time_casa, gol_casa, gol_visitante;
    private Date data_jogo;
    
    String nome_casa, nome_visitante;
    int img_casa, img_visitante;

    public String getNome_casa() {
        return nome_casa;
    }

    public void setNome_casa(String nome_casa) {
        this.nome_casa = nome_casa;
    }

    public String getNome_visitante() {
        return nome_visitante;
    }

    public void setNome_visitante(String nome_visitante) {
        this.nome_visitante = nome_visitante;
    }

    public int getImg_casa() {
        return img_casa;
    }

    public void setImg_casa(int img_casa) {
        this.img_casa = img_casa;
    }

    public int getImg_visitante() {
        return img_visitante;
    }

    public void setImg_visitante(int img_visitante) {
        this.img_visitante = img_visitante;
    }

    public int getId() {
        return id;
    }

    public Jogo() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(int campeonato) {
        this.campeonato = campeonato;
    }

    public int getTime_visitante() {
        return time_visitante;
    }

    public void setTime_visitante(int time_visitante) {
        this.time_visitante = time_visitante;
    }

    public int getTime_casa() {
        return time_casa;
    }

    public void setTime_casa(int time_casa) {
        this.time_casa = time_casa;
    }

    public int getGol_casa() {
        return gol_casa;
    }

    public void setGol_casa(int gol_casa) {
        this.gol_casa = gol_casa;
    }

    public int getGol_visitante() {
        return gol_visitante;
    }

    public void setGol_visitante(int gol_visitante) {
        this.gol_visitante = gol_visitante;
    }

    public Date getData_jogo() {
        return data_jogo;
    }

    public void setData_jogo(Date data_jogo) {
        this.data_jogo = data_jogo;
    }
    
    
}
