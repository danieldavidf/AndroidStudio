package com.example.daniel.camera_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ImageView img;
    Bitmap im;
    EditText nome;
    EditText telefone;
    private ContatoAdapter adapter;
    List<Contato> contatos=new ArrayList<Contato>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnsalvar = (Button)findViewById(R.id.button);
        list = (ListView)findViewById(R.id.listview);
        img=(ImageView)findViewById(R.id.imageView);
        nome=(EditText)findViewById(R.id.e1);
        telefone=(EditText)findViewById(R.id.telefone1);
        adapter=new ContatoAdapter(this,contatos);
        list.setAdapter(adapter);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            if (nome.getText().toString().isEmpty() || telefone.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "É necessário preencher ambos os campos.", Toast.LENGTH_SHORT).show();
            } else {
                contatos.add(new Contato(nome.getText().toString(), telefone.getText().toString(),im));
                adapter.notifyDataSetChanged();
                img.setImageResource(R.mipmap.ic_launcher);
                im=null;
                nome.setText("");
                telefone.setText("");
            }
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                contatos.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        im = (Bitmap)data.getExtras().get("data");
        img.setImageBitmap(im);
    }

    public void gravarVideo(View v) {
        Intent intent2 = new Intent(this, VideoActivity.class);
        startActivity(intent2);
    }
}
