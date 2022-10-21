/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Enteties;

import java.sql.Date;

/**
 *
 * @author maluc
 */
public class Time {
    private String nome, tecnico, presidente, local_fundacao;
    private int id, titulos, num_torcedores, idArquivo;
    private Date data_fundacao;

    public Time(String nome, Date data_fundacao, String tecnico, String presidente, String local_fundacao) {
        this.nome = nome;
        this.data_fundacao = data_fundacao;
        this.tecnico = tecnico;
        this.presidente = presidente;
        this.local_fundacao = local_fundacao;
    }

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    public int getNum_torcedores() {
        return num_torcedores;
    }

    public void setNum_torcedores(int num_torcedores) {
        this.num_torcedores = num_torcedores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time() {
    }

    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_fundacao() {
        return data_fundacao;
    }

    public void setData_fundacao(Date data_fundacao) {
        this.data_fundacao = data_fundacao;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getLocal_fundacao() {
        return local_fundacao;
    }

    public void setLocal_fundacao(String local_fundacao) {
        this.local_fundacao = local_fundacao;
    }

    public int getTitulos() {
        return titulos;
    }

    public void setTitulos(int titulos) {
        this.titulos = titulos;
    }
    
    
}
