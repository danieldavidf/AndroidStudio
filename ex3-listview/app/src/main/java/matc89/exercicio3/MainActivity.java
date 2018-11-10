package matc89.exercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int id = -1;
    ListView lv;
    EditText editTextDescricao;
    EditText editTextPrioridade;
    Button botaoAdicionar, botaoRemover;
    ArrayList<Tarefa> listaTarefas;
    TarefaAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();


        listaTarefas = new ArrayList<Tarefa>();
//        listaTarefas.add(new Tarefa("Arrumar a casa", "1"));
//        listaTarefas.add(new Tarefa("Atividade 3 MATC89", "10"));
//        listaTarefas.add(new Tarefa("Lavar louça", "3"));
//        listaTarefas.add(new Tarefa("Lavar o carro", "2"));

        myadapter = new TarefaAdapter(this, android.R.layout.simple_list_item_2, listaTarefas);
        lv.setAdapter(myadapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                listaTarefas.remove(pos);
                myadapter.notifyDataSetChanged();
            }
        });

    }

    private void inicializar(){
        lv = (ListView)findViewById(R.id.listView);
        editTextDescricao = (EditText)findViewById(R.id.editDescricao);
        editTextPrioridade = (EditText)findViewById(R.id.editPrioridade);
        botaoAdicionar = (Button)findViewById(R.id.buttonAdicionar);
        botaoRemover= (Button)findViewById(R.id.buttonRemover);
        botaoRemover.setEnabled(false);

        botaoAdicionar.setOnClickListener(this);
        botaoRemover.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAdicionar:
                String desc = editTextDescricao.getText().toString();
                String prio = editTextPrioridade.getText().toString();
                int priorid = Integer.parseInt(prio);

                int i;
                boolean jaTemEssaTarefa = false;
                for( i=0; i< listaTarefas.size(); i++ )
                    if (listaTarefas.get(i).getDescricao().equals(desc))
                        jaTemEssaTarefa = true;

                if (jaTemEssaTarefa)
                    Toast.makeText(this, "Tarefa já cadastrada.", Toast.LENGTH_SHORT).show();
                else {
                    if (priorid < 1 || priorid > 10){
                        Toast.makeText(this, "A prioridade deve estar entre 0 e 10.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        for( i=0; i< listaTarefas.size(); i++ ) {
                            if (priorid >= listaTarefas.get(i).getPrioridade())
                                continue;
                            else
                                break;
                        }
                        Tarefa novatarefa = new Tarefa(desc, priorid);
                        listaTarefas.add(i, novatarefa);
                        botaoRemover.setEnabled(true);
                        myadapter.notifyDataSetChanged();
                    }
                }

                break;

            case R.id.buttonRemover:
                listaTarefas.remove(0);
                if(listaTarefas.size() == 0)
                    botaoRemover.setEnabled(false);

                myadapter.notifyDataSetChanged();
                break;
        }
    }
}
