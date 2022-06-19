package com.example.accidentcontrol_final;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.accidentcontrol_final.Adaptador.InsidentesAdaptador;
import com.example.accidentcontrol_final.Modelo.Insidentes;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ListarIndencias extends AppCompatActivity {
    RecyclerView mRecycler;
    InsidentesAdaptador mAdapter;
    FirebaseFirestore  mFirebaseStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_indencias);

        mFirebaseStore = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.recyListaInsidentes);

        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirebaseStore.collection("Insidentes");

        FirestoreRecyclerOptions<Insidentes> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Insidentes>().setQuery(query, Insidentes.class).build();
        mAdapter = new InsidentesAdaptador(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
    }



    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}