package com.example.evaluacion_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

import clase.fireclass;

public class firebaseActivity extends AppCompatActivity {

    private EditText ednombre, eddestino, edpromocion;
    private Button guardar, lista;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase_act);

        ednombre = (EditText) findViewById(R.id.editTextTextPersonName3);
        eddestino = (EditText) findViewById(R.id.editTextTextPersonName4);
        edpromocion = (EditText) findViewById(R.id.editTextTextPersonName5);
        guardar = (Button) findViewById(R.id.button4);
        lista = (Button) findViewById(R.id.button5);

        inicializarBase();

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lis = new Intent(firebaseActivity.this, listadoActivity.class);
                startActivity(lis);
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!ednombre.getText().toString().isEmpty())
                {
                    fireclass clase = new fireclass();
                    clase.setId(UUID.randomUUID().toString());
                    clase.setNombre(ednombre.getText().toString());
                    clase.setDestino(eddestino.getText().toString());
                    clase.setPromocion(edpromocion.getText().toString());

                    databaseReference.child("fireclass").child(clase.getId()).setValue(clase);

                    Toast.makeText(getBaseContext(), "Cliente guardado", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Debe rellenar los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void inicializarBase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }


}
