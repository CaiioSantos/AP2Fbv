package com.example.downloadmanager.Model;

public class Contatos {
    private String nome;
    private String email;

    public Contatos(String nome, String email) {
        this.nome = nome;
        this.email = email;
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



    @Override
    public String toString() {
        return "Contatos{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
