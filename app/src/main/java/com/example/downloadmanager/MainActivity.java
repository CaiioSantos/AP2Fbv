package com.example.downloadmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.downloadmanager.Adapter.ContatosAdapter;
import com.example.downloadmanager.Model.Contatos;

//import com.example.downloadmanager.ContatosAdapter.ContatosAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Contatos> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Contatos");
        listView = (ListView) findViewById(R.id.activityMainListView);
        list = new ArrayList<>();

        for (int i=0; i<100; i++){
            list.add(new Contatos("Tua Mãe", "tua.mae.e.minha@hotmail.com", R.drawable.image1));
        }





        listView.setAdapter(new ContatosAdapter(this, list));

//        listView.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, list.get(i).getNome() +
//                        list.get(i).getEmail(), Toast.LENGTH_SHORT) .show();
//            }

//        });
    }
}
