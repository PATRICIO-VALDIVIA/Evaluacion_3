package com.example.evaluacion_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_act);

        videoview = (VideoView) findViewById(R.id.videoView);

        String v ="android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri x = Uri.parse(v);
        MediaController media = new MediaController(this);
        videoview.setMediaController(media);
        videoview.setVideoURI(x);
        videoview.requestFocus();
        videoview.setZOrderOnTop(true);
        videoview.start();

    }


    public void gestion(View view) {
        Intent b = new Intent(MenuActivity.this, firebaseActivity.class);
        startActivity(b);
    }



    public void promo(View view) {

        ArrayList<String> clientes = new ArrayList<String>();
        clientes.add("Ramiro");
        clientes.add("Rosa");
        clientes.add("Robert");
        Intent c = new Intent(MenuActivity.this, promocionesActivity.class);
        c.putExtra("listadoclientes", clientes);
        startActivity(c);
    }
}
