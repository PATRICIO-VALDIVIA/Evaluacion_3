package com.example.evaluacion_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt1, edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.editTextTextPersonName);
        edt2 = (EditText) findViewById(R.id.editTextTextPersonName2);
    }


        public void inicio(View view){
              String nombre = edt1.getText().toString();
              String contraseña = edt2.getText().toString();
                if(nombre.equals("Android") && contraseña.equals("123")) {
                    Intent a = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(a);
                }

            }

    }