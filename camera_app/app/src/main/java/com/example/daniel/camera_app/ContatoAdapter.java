package com.example.daniel.camera_app;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContatoAdapter extends ArrayAdapter<Contato> {
    private List<Contato> contatos;
    public ContatoAdapter(@NonNull Context context, List<Contato> contatos) {
        super(context, 0,contatos);
        this.contatos=contatos;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        Contato contato=contatos.get(position);
        if (contatos!=null){
            if (view==null){
                LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=inflater.inflate(R.layout.list_item,null);
                ViewHolder holder=new ViewHolder();
                holder.textNome=view.findViewById(R.id.name);
                holder.textTelefone=view.findViewById(R.id.telefone1);
                holder.image =view.findViewById(R.id.img1);
                view.setTag(holder);
            }
            ViewHolder holder=(ViewHolder)view.getTag();
            holder.textNome.setText(contato.getNome());
            holder.textTelefone.setText(contato.getTelefone());
            if(contato.getFoto()==null){
                holder.image.setImageResource(R.mipmap.ic_launcher);
            }else {
                if(contato.getFoto()!=null)holder.image.setImageBitmap(contato.getFoto());
            }
        }
        return view;
    }
    static class ViewHolder{
        public TextView textNome;
        public TextView textTelefone;
        public ImageView image;
    }
}
