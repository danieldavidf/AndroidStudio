package matc89.exercicio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewLabel;
    TextView textViewEdit;
    String frase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewEdit = (TextView) findViewById(R.id.editNome);
        textViewLabel = (TextView) findViewById(R.id.labelMensagem);

        if(savedInstanceState != null) {
            frase = savedInstanceState.getString("texto");
            textViewLabel.setText( frase );
        }
    }

    public void cumprimentar(View v) {
        frase = "Alô, " + textViewEdit.getText().toString() + "!";
        textViewLabel.setText( frase );
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("texto", frase);
    }

}
