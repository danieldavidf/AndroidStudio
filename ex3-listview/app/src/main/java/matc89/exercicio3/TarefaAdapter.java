package matc89.exercicio3;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TarefaAdapter extends ArrayAdapter {
    Activity activity;
    int layout;
    ArrayList<Tarefa> listaTarefas;

    public TarefaAdapter(Activity activity, int layout, ArrayList<Tarefa> listaTarefas){
        super(activity, layout, listaTarefas);

        this.activity = activity;
        this.layout = layout;
        this.listaTarefas = listaTarefas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(layout, null);

        TextView descricao = (TextView) convertView.findViewById(android.R.id.text1);
        TextView prioridade = (TextView) convertView.findViewById(android.R.id.text2);

        descricao.setText(listaTarefas.get(position).getDescricao());
        //prioridade.setText(listaTarefas.get(position).getPrioridade());
        prioridade.setText(String.valueOf("Prioridade: "+listaTarefas.get(position).getPrioridade()));

        return convertView;
    }
}
