package com.example.evaluacion_3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import clase.precios;

public class promocionesActivity extends AppCompatActivity {

    private Spinner spin;
    private EditText promo, valorenvi;
    private Button calcupromo;
    private TextView nombreclient, preciototal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promociones_act);

        spin = (Spinner) findViewById(R.id.spinner);
        promo = (EditText) findViewById(R.id.editTextTextPersonName6);
        valorenvi = (EditText) findViewById(R.id.editTextTextPersonName7);
        calcupromo = (Button) findViewById(R.id.button7);
        nombreclient = (TextView) findViewById(R.id.textView);
        preciototal = (TextView)findViewById(R.id.textView2);

        ArrayList<String> listaclientes = (ArrayList<String>) getIntent().getSerializableExtra("listadoclientes");
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaclientes);
        spin.setAdapter(adaptador);

        calcupromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valor = promo.getText().toString();
                String clientes = spin.getSelectedItem().toString();
                String resultado = valorenvi.getText().toString();
                int total;
                precios v = new precios();

                if(valor.equals("Pizzas promo")) {
                    total = v.getPizzas_promo() + Integer.parseInt(resultado);
                    String o = String.valueOf(total);
                    nombreclient.setText("Señor/a "+ clientes + " el final segun promocion y envio es: ");
                    preciototal.setText("$" + o );
                }

                if(valor.equals("Master pizza")) {
                    total = v.getMaster_Pizza() + Integer.parseInt(resultado);
                    String o = String.valueOf(total);
                    nombreclient.setText("Señor/a "+ clientes + " el final segun promocion y envio es: ");
                    preciototal.setText("$" + o );
                }

                if(valor.equals("Pizza max")) {
                    total = v.getPizza_max() + Integer.parseInt(resultado);
                    String o = String.valueOf(total);
                    nombreclient.setText("Señor/a "+ clientes +" el final segun promocion y envio es: ");
                    preciototal.setText("$" + o );
                }


            }
        });
    }
}
