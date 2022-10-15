package com.example.seas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

class global{ //Clase para poder utilizar una variable global
    public static int menu=0; //Variable para poder seleccionar las señas a presentar

}

public class Menu_activity extends AppCompatActivity {
    Button btnAbc;
    Button btnMesesyTiempo;
    Button btnSaludos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnAbc=(Button)findViewById(R.id.btnAbc);
        btnMesesyTiempo=(Button)findViewById(R.id.btnMesesyTiempo);
        btnSaludos=(Button)findViewById(R.id.btnSaludos);

        btnAbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.menu=1;
                Cambio();
            }
        });

        btnMesesyTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.menu=2;
                Cambio();
            }
        });

        btnSaludos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.menu=3;
                Cambio();
            }
        });

    }

    private void Cambio(){ //Metodo para cambiar a la presentacion de señas
        Intent c = new Intent(Menu_activity.this, Basics.class);
        startActivity(c);
    }
}