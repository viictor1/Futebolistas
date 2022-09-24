/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Futebolistas.Enteties;

/**
 *
 * @author maluc
 */
public class Time {
    private String nome, data_fundacao, tecnico, presidente, local_fundacao;
    private int id, titulos, num_torcedores;

    public Time(String nome, String data_fundacao, String tecnico, String presidente, String local_fundacao, int titulos, int num_torcedores) {
        this.nome = nome;
        this.data_fundacao = data_fundacao;
        this.tecnico = tecnico;
        this.presidente = presidente;
        this.local_fundacao = local_fundacao;
        this.titulos = titulos;
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

    public String getData_fundacao() {
        return data_fundacao;
    }

    public void setData_fundacao(String data_fundacao) {
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
