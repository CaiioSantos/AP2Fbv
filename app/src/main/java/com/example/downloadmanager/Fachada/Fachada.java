package com.example.downloadmanager.Fachada;

import com.example.downloadmanager.Controller.ContatoControle;
import com.example.downloadmanager.Controller.IContatoControle;
import com.example.downloadmanager.Model.Contatos;

import java.util.ArrayList;

public class Fachada implements IContatoControle {
    private static Fachada instancia;
    private IContatoControle iContatoControle = ContatoControle.getInstance();
    private IContatoControle contatoControle;

    public static Fachada getInstance(){
        if (instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }

    public Fachada(){
        contatoControle = ContatoControle.getInstance();
    }


    @Override
    public void cadastrarContato(Contatos contatos) {
        this.contatoControle.cadastrarContato(contatos);
    }

    @Override
    public void atualizarContato(Contatos contatos) {
        this.contatoControle.atualizarContato(contatos);
    }

    @Override
    public void deletarContato(Contatos contatos) {
        this.contatoControle.cadastrarContato(contatos);
    }

    @Override
    public Contatos pesquisarContato(String email) {
        return null;
    }

    @Override
    public ArrayList listarContatos() {
        return null;
    }
}
