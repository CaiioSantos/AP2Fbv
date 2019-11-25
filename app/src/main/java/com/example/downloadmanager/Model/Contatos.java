package com.example.downloadmanager.Model;

public class Contatos {
    private String nome;
    private String email;
    private String foto;

    public Contatos(String nome, String email, String foto) {
        this.nome = nome;
        this.email = email;
        this.foto = foto;
    }

    public Contatos(String tua_mãe, String email, int image1) {

    }
    public Contatos (){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Contatos{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", foto=" + foto +
                '}';
    }
}
