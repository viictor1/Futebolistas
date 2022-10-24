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
public class Jogadora_Time {
    private int id, id_time, id_jogadora, numero_atual;
    private String posicao, nome;
    private Date data_inicio, data_fim;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Jogadora_Time() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    public int getId_jogadora() {
        return id_jogadora;
    }

    public void setId_jogadora(int id_jogadora) {
        this.id_jogadora = id_jogadora;
    }

    public int getNumero_atual() {
        return numero_atual;
    }

    public void setNumero_atual(int numero_atual) {
        this.numero_atual = numero_atual;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }



    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
}
