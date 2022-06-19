package com.example.accidentcontrol_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Empleado extends AppCompatActivity {

    Button btmnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);

        btmnAgregar = findViewById(R.id.btnAgregar);

        btmnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegistrarInsidentes.class));

            }
        });
    }
}