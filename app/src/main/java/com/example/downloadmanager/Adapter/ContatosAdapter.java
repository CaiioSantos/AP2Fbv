package com.example.downloadmanager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.downloadmanager.Model.Contatos;
import com.example.downloadmanager.R;

import java.util.ArrayList;

public class ContatosAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Contatos> list;

    public ContatosAdapter(Context context, ArrayList<Contatos> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        public ImageView imagem;
        public TextView nome;
        public TextView email;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.contatos_list_view, null);
            holder.imagem = view.findViewById(R.id.imgViewFoto);
            holder.nome =  view.findViewById(R.id.txtViewNome);
            holder.email = view.findViewById(R.id.txtViewEmail);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.imagem.setImageResource(Integer.parseInt(list.get(i).getFoto().toString()));
        holder.nome.setText(list.get(i).getNome());
        holder.email.setText(list.get(i).getEmail());

        return view;
    }
}
