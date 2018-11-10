package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nome;
    String frase;
    TextView textViewLabel;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_main);

        textViewLabel = (TextView) findViewById(R.id.textView);

        Intent intentMain = getIntent();
        Bundle parametros = intentMain.getExtras();

        if(parametros != null) {
            nome = parametros.getString("novoNome");
            //Toast.makeText(MainActivity.this, "Olá, " + nome + "!", Toast.LENGTH_SHORT).show();
            if (nome.isEmpty())
                frase = "Oi!";
            else
                frase = "Oi, " + nome + "!";

            textViewLabel.setText( frase );
        }
    }

    public void trocarUsuario(View v) {
        Intent intentMain = new Intent(this, OutraActivity.class);

        Bundle params = new Bundle();
        params.putString("atualNome",nome);
        intentMain.putExtras(params);

        startActivity(intentMain);
    }
}