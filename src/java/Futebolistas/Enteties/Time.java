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
    private int id, titulos, num_torcedores, idArquivo, posicao;
    private Date data_fundacao;

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    private int jogos, vitorias, empates, derrotas, pontos, golsMarcados, golsSofridos, saldo;

    public int getDerrotas() {
        return derrotas;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public void setGolsMarcados(int golsMarcados) {
        this.golsMarcados = golsMarcados;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public void setGolsSofridos(int golsSofridos) {
        this.golsSofridos = golsSofridos;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

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
