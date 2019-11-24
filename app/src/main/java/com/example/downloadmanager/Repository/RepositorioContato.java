package com.example.downloadmanager.Repository;

import com.example.downloadmanager.Model.Contatos;

import java.util.ArrayList;

public class RepositorioContato implements IRepositorioContato {
    private ArrayList<Contatos> contatosArrayList;
    private static RepositorioContato instancia;

    public static RepositorioContato getInstance(){
        if (instancia == null){
            instancia = new RepositorioContato();
        }
        return instancia;
    }
        private RepositorioContato(){
        if(this.contatosArrayList == null){
            this.contatosArrayList = new ArrayList<>();
            }
        }


    @Override
    public void cadastrarContato(Contatos contatos) {
        this.contatosArrayList.add(contatos);
    }

    @Override
    public void atualizarContato(Contatos contatos) {
        for (int i = 0; i <this.contatosArrayList.size() ; i++) {
            if (this.contatosArrayList.get(i).getEmail().equals(contatos)){
                this.contatosArrayList.set(i,contatos);
            }

        }
    }

    @Override
    public void deletarContatoc(Contatos contatos) {
        this.contatosArrayList.remove(contatos);
    }

    @Override
    public Contatos pesquisarContato(String email) {
        Contatos contatos = null;
        for (int i = 0; i <contatosArrayList.size() ; i++) {
            if (contatosArrayList.get(i).getEmail().equals(email)){
                contatos = this.contatosArrayList.get(i);
            }
        }
        return contatos;
    }

    @Override
    public ArrayList listarContatos() {
        return this.contatosArrayList;
    }
}
