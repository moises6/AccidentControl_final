package com.example.accidentcontrol_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Administrador extends AppCompatActivity {

    Button btnListarInsidentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        btnListarInsidentes= findViewById(R.id.btnLista);
        btnListarInsidentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ListarIndencias.class));
            }
        });
    }
}