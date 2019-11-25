package com.example.downloadmanager.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.downloadmanager.Adapter.ContatosAdapter;
import com.example.downloadmanager.Fachada.Fachada;
import com.example.downloadmanager.Model.Contatos;
import com.example.downloadmanager.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListaDeContatos extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Contatos> listaContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_contatos);
        setTitle("Contatos");
        listView = findViewById(R.id.activityMainListView);
        //list = new ArrayList<>();

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adicionarContato = new Intent(getApplicationContext(), AdicionarContato.class);
                startActivity(adicionarContato);

            }
        });

        Fachada fachada = new Fachada();
        listaContato =fachada.listarContatos();





        listView.setAdapter(new ContatosAdapter(this, listaContato));

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, list.get(i).getNome() +
//                        list.get(i).getEmail(), Toast.LENGTH_SHORT) .show();
//            }
//
//        });


    }
}
