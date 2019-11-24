package com.example.downloadmanager.Repository;

import com.example.downloadmanager.Model.Contatos;

import java.util.ArrayList;

public interface IRepositorioContato {


    void cadastrarContato (Contatos contatos);
    void atualizarContato (Contatos contatos);
    void deletarContatoc (Contatos contatos);
    Contatos pesquisarContato(String email);
    ArrayList listarContatos();

}
