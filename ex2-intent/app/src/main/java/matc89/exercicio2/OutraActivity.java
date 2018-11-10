package matc89.exercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OutraActivity extends AppCompatActivity {

    String nome;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        editText = (EditText)findViewById(R.id.editText);

        Intent intentOutra2 = getIntent();
        Bundle parametros = intentOutra2.getExtras();

        nome = parametros.getString("atualNome");
        editText.setText(nome, TextView.BufferType.EDITABLE);
    }

    public void mudarNome(View v) {
        String nome = editText.getText().toString();

        Intent intentOutra = new Intent(getApplicationContext(), MainActivity.class);
        Bundle parametros = new Bundle();
        parametros.putString("novoNome",nome);
        intentOutra.putExtras(parametros);
        startActivity(intentOutra);
    }

    public void voltar(View v) {
        finish();
    }
}
