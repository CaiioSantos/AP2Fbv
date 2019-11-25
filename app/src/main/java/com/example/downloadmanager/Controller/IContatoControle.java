package com.example.downloadmanager.Controller;

import com.example.downloadmanager.Model.Contatos;

import java.util.ArrayList;

public interface IContatoControle {

    void cadastrarContato (Contatos contatos);
    void atualizarContato (Contatos contatos);
    void deletarContato (Contatos contatos);
    Contatos pesquisarContato(String email);
    ArrayList listarContatos();
}
