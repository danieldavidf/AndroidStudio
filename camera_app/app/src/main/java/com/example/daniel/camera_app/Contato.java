package com.example.daniel.camera_app;

import android.graphics.Bitmap;

public class Contato {
    String nome;
    String telefone;
    Bitmap foto;

    public Contato(String nome, String telefone, Bitmap foto) {
        this.nome = nome;
        this.telefone = telefone;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }
}



