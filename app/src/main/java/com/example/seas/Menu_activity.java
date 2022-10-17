package com.example.seas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.seas.databinding.ActivityMenuBinding;

class global{ //Clase para poder utilizar una variable global
    public static int menu = 0; //Variable para poder seleccionar las señas a presentar
}

public class Menu_activity extends MainActivity {
    Button btnAbc;
    Button btnMesesyTiempo;
    Button btnSaludos;
    ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnAbc = binding.btnAbc;
        btnMesesyTiempo = binding.btnMesesyTiempo;
        btnSaludos = binding.btnSaludos;

        allocateActivityTitle(getString(R.string.menu_basic_sign));

        btnAbc.setOnClickListener(view -> {
            global.menu=1;
            Cambio();
        });

        btnMesesyTiempo.setOnClickListener(view -> {
            global.menu=2;
            Cambio();
        });

        btnSaludos.setOnClickListener(view -> {
            global.menu=3;
            Cambio();
        });

    }

    private void Cambio(){ //Metodo para cambiar a la presentacion de señas
        Intent c = new Intent(Menu_activity.this, Basics.class);
        startActivity(c);
    }
}