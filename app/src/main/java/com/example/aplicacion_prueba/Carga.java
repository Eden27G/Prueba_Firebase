package com.example.aplicacion_prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Carga extends AppCompatActivity {

    TextView app_name, desarrollo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carga);

        //cambio de letra
        String ubicacion = "fuentes/varsity_regular.ttf";
        Typeface tf = Typeface.createFromAsset(Carga.this.getAssets(),ubicacion);

        app_name = findViewById(R.id.app_name);
        desarrollo = findViewById(R.id.desarrollo);

        final int DURACION = 5000;

        new Handler().postDelayed( new Runnable(){
           @Override
           public void run(){
               //CODIGO QUE SE EJECUTARA
               Intent intent =  new Intent( Carga.this,MainActivity.class);
               startActivity(intent);
               finish();
           }
        },DURACION);

        app_name.setTypeface(tf);
        desarrollo.setTypeface(tf);
    }
}