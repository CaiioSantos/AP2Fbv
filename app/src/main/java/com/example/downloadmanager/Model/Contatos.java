package com.example.downloadmanager.Model;

public class Contatos {
    private String nome;
    private String email;
    private int foto;

    public Contatos(String nome, String email, int foto) {
        this.nome = nome;
        this.email = email;
        this.foto = foto;
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

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
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
