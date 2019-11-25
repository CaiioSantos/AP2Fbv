package com.example.downloadmanager.Controller;

import com.example.downloadmanager.Model.Contatos;
import com.example.downloadmanager.Repository.RepositorioContato;

import java.util.ArrayList;

public class ContatoControle implements IContatoControle {
    private static ContatoControle instancia;
    private RepositorioContato repositorioContato = RepositorioContato.getInstance();

    public static ContatoControle getInstance(){
        if (instancia == null){
            instancia = new ContatoControle();
        }
        return instancia;
    }

    @Override
    public void cadastrarContato(Contatos contatos) {
            this.repositorioContato.cadastrarContato(contatos);

    }

    @Override
    public void atualizarContato(Contatos contatos) {
            this.repositorioContato.atualizarContato(contatos);
    }

    @Override
    public void deletarContato(Contatos contatos) {
            this.repositorioContato.deletarContatoc(contatos);
    }

    @Override
    public Contatos pesquisarContato(String email) {
        return repositorioContato.pesquisarContato(email);
    }

    @Override
    public ArrayList listarContatos() {
        return this.repositorioContato.listarContatos();
    }
}
