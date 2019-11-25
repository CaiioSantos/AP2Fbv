package com.example.downloadmanager.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.downloadmanager.Controller.ContatoControle;
import com.example.downloadmanager.Fachada.Fachada;
import com.example.downloadmanager.Model.Contatos;
import com.example.downloadmanager.R;

import java.io.File;
import java.util.ArrayList;

public class AdicionarContato extends AppCompatActivity {

    EditText edtNome;
    EditText edtEmail;
    private ArrayList<Contatos> contatosArrayList;
    ContatoControle  contatoControle;
    Button BtnSalvar;

    ImageView imageView;

    boolean recursoImagem = false;
    private String diretorioFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_contatos);
        setTitle("Adicionar Contato");


        edtNome = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        BtnSalvar = findViewById(R.id.btn_salvar);
        imageView =  findViewById(R.id.image_contato);


        BtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contatos contatos = new Contatos();
                Fachada fachada = new Fachada();

                contatos.setNome(edtNome.getText().toString());
                contatos.setEmail(edtEmail.getText().toString());
                contatos.setFoto((int) imageView.getTag());


                try{
                    if(!contatos.getNome().isEmpty()&& !contatos.getEmail().isEmpty()&& !contatos.getEmail().isEmpty()){
                        fachada.cadastrarContato(contatos);

                        Toast.makeText(getApplicationContext(), "Contato Adicionado",
                                Toast.LENGTH_SHORT).show();


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void boxDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name).setMessage("Selecione a fonte da Imagem:");
        builder.setPositiveButton("Camera", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                capturarImagem();
            }
        });
        builder.setNegativeButton("Biblioteca", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                carregarImagem();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void capturarImagem() {
        recursoImagem = true;

        diretorioFoto = getExternalFilesDir(null) + "/"+System.currentTimeMillis()+".jpg";

        Intent abrirCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        abrirCamera.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(this,this.getApplicationContext().getPackageName()+ ".provider", new File(diretorioFoto)));
        startActivityForResult(abrirCamera,24);
    }


    private void carregarImagem(){
        recursoImagem = false;

        Intent carregarimg = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(carregarimg ,1);
    }
}
