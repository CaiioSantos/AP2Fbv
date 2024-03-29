package com.example.downloadmanager.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.downloadmanager.Adapter.ContatosAdapter;
import com.example.downloadmanager.Model.Contatos;
import com.example.downloadmanager.R;
import com.example.downloadmanager.UI.AdicionarContato;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

//import com.example.downloadmanager.ContatosAdapter.ContatosAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Contatos> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* setTitle("Contatos");
        listView = findViewById(R.id.activityMainListView);
        list = new ArrayList<>();

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adicionarContato = new Intent(getApplicationContext(), AdicionarContato.class);
                startActivity(adicionarContato);

            }
        });

        for (int i=0; i<100; i++){
            list.add(new Contatos("Tua Mãe", "tua.mae.e.minha@hotmail.com", R.drawable.image1));
        }





        listView.setAdapter(new ContatosAdapter(this, list));

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == R.id.download) {
            Intent ListaMusica = new Intent(getApplicationContext(), AdicionarContato.class);
            startActivity(ListaMusica);
        }
        return super.onOptionsItemSelected(item);

    }*/



}

    public void TelaContato(View view) {
        Intent intent = new Intent(getApplicationContext(), ListaDeContatos.class);
        startActivity(intent);
    }
}
