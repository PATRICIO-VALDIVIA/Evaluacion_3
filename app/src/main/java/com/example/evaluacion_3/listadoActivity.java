package com.example.evaluacion_3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import clase.fireclass;

public class listadoActivity extends AppCompatActivity {

    private ListView list;
    private Button borrar;
    private ArrayList<fireclass> listfireclass = new ArrayList<fireclass>();

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    fireclass fireclassSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_act);

        list = (ListView)findViewById(R.id.lv);
        borrar = (Button)findViewById(R.id.button6);

        iniciarbsd();

        databaseReference.child("fireclass").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot objSnapshot : snapshot.getChildren())
                {
                 fireclass ñ = objSnapshot.getValue(fireclass.class);
                 listfireclass.add(ñ);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listfireclass);
                    list.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fireclassSelected = (fireclass) parent.getItemAtPosition(position);
            }
        });
    }

    public void eliminar(View v)
    {
        fireclass nuevo = new fireclass();
        nuevo.setId(fireclassSelected.getId());
        databaseReference.child("fireclass").child(nuevo.getId()).removeValue();

        Toast.makeText(this, "Se ha borrado al cliente", Toast.LENGTH_LONG).show();
    }

    public void iniciarbsd(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}
