package com.example.aplicacion_prueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    TextView app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String ubicacion = "fuentes/varsity_regular.ttf";
        Typeface tf = Typeface.createFromAsset(MainActivity.this.getAssets(),ubicacion);

        app_name = findViewById(R.id.app_name);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        System.out.println("tu token es: " +token);
                        Toast.makeText(MainActivity.this,"tu token es: "+  token
                                , Toast.LENGTH_SHORT).show();
                    }
                });

        app_name.setTypeface(tf);

        FirebaseMessaging.getInstance().subscribeToTopic("PruebaC5");
    }
}