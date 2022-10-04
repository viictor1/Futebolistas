package Futebolistas.Enteties;

public class Usuario {
    private String nome, email, senha;
    private Boolean isAdministrador;
    private int id, time;

    public Usuario(String nome, String email, String senha, Boolean adm) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdministrador = adm;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Usuario(int id, String nome, String email, String senha, Boolean isAdministrador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdministrador = isAdministrador;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Usuario(String nome, String email, String senha, Boolean isAdministrador, int time) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdministrador = isAdministrador;
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getIsAdministrador() {
        return isAdministrador;
    }

    public void setIsAdministrador(Boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }

    public Usuario(int id, String nome, String email, String senha, Boolean isAdministrador, int time){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.time = time;
        this.isAdministrador = isAdministrador;
        this.id = id;
    }
}
