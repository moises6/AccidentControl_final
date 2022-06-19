package com.example.accidentcontrol_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistrarInsidentes extends AppCompatActivity {

    EditText tipo, descripcion, fecha;
    Button guadar;
    private FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_insidentes);

        this.setTitle("Crear Insidentes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mfirestore = FirebaseFirestore.getInstance();


        descripcion = findViewById(R.id.txtDescripcion);
        fecha = findViewById(R.id.txtFecha);
        guadar = findViewById(R.id.btnRegistrar);
        tipo = findViewById(R.id.txtInsidente);

        guadar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Isidentes = tipo.getText().toString().trim();
                String Descripciones = descripcion.getText().toString().trim();
                String Fechas = fecha.getText().toString().trim();


                if (Isidentes.isEmpty() && Descripciones.isEmpty() && Fechas.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingrese los datos", Toast.LENGTH_SHORT).show();
                }else {
                    posInsidentes (Isidentes, Descripciones, Fechas);
                }

            }
        });
    }

    private void posInsidentes(String isidentes, String descripciones, String fechas) {
        Map< String, Object > map = new HashMap<>();
        map.put("Tipo Insidente", isidentes);
        map.put("Descripcion", descripciones);
        map.put("Fecha",fechas);




        mfirestore.collection("Insidentes").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al ingresar datos", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
       onBackPressed();
       return false;
    }
}