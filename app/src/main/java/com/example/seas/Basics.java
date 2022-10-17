package com.example.seas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Switch;

import com.example.seas.databinding.ActivityBasicsBinding;
import com.example.seas.databinding.ActivityTextSignBinding;

import java.util.ArrayList;
import java.util.List;

public class Basics extends MainActivity {
    List<Sign> signList = new ArrayList<>();
    private ActivityBasicsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasicsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //List<Sign> signTranslate = new ArrayList<>();

        allocateActivityTitle(getString(R.string.menu_basic_sign));

        //Evaluacion de metodo seleccionado
        switch (global.menu){
            case 1:
                createSignsABC();
                break;
            case 2:
                createSignsMyT();
                break;
            case 3:
                createSignsSal();
                break;
        }

        Activity Basics = this;
        binding.bsrecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        binding.bsrecycler.setAdapter(new CardAdapter(signList));
    }

    private void createSignsABC() { //Metodo para presentar el abecedario
        signList.add(new Sign(R.drawable.img_a, signList.size(), 'A'));
        signList.add(new Sign(R.drawable.img_b, signList.size(), 'B'));
        signList.add(new Sign(R.drawable.img_c, signList.size(), 'C'));
        signList.add(new Sign(R.drawable.img_d, signList.size(), 'D'));
        signList.add(new Sign(R.drawable.img_e, signList.size(), 'E'));
        signList.add(new Sign(R.drawable.img_f, signList.size(), 'F'));
        signList.add(new Sign(R.drawable.img_g, signList.size(), 'G'));
        signList.add(new Sign(R.drawable.img_h, signList.size(), 'H'));
        signList.add(new Sign(R.drawable.img_d, signList.size(), 'I'));
        signList.add(new Sign(R.drawable.img_j, signList.size(), 'J'));
        signList.add(new Sign(R.drawable.img_k, signList.size(), 'K'));
        signList.add(new Sign(R.drawable.img_l, signList.size(), 'L'));
        signList.add(new Sign(R.drawable.img_m, signList.size(), 'M'));
        signList.add(new Sign(R.drawable.img_n, signList.size(), 'N'));
        signList.add(new Sign(R.drawable.img_o, signList.size(), 'O'));
        signList.add(new Sign(R.drawable.img_p, signList.size(), 'P'));
        signList.add(new Sign(R.drawable.img_q, signList.size(), 'Q'));
        signList.add(new Sign(R.drawable.img_r, signList.size(), 'R'));
        signList.add(new Sign(R.drawable.img_s, signList.size(), 'S'));
        signList.add(new Sign(R.drawable.img_t, signList.size(), 'T'));
        signList.add(new Sign(R.drawable.img_u, signList.size(), 'U'));
        signList.add(new Sign(R.drawable.img_v, signList.size(), 'V'));
        signList.add(new Sign(R.drawable.img_w, signList.size(), 'W'));
        signList.add(new Sign(R.drawable.img_x, signList.size(), 'X'));
        signList.add(new Sign(R.drawable.img_y, signList.size(), 'Y'));
        signList.add(new Sign(R.drawable.img_z, signList.size(), 'Z'));

    }
    private void createSignsMyT() { //Metodo para presentar los meses y el tiempo
        signList.add(new Sign(R.drawable.img_enero, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_febrero, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_marzo, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_abril, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_mayo, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_junio, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_julio, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_agosto, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_septiembre, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_octubre, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_noviembre, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_diciembre, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_ahora, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_ahorita, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_hoy, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_manana, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_ayer, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_cuando, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_futuro, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_pasado, signList.size(), ' '));


    }

    private void createSignsSal() { //Metodo para presentar los saludos
        signList.add(new Sign(R.drawable.img_bien, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_como, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_con, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_cual, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_cuantos, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_donde, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_es, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_gracias, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_mal, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_no, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_para, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_por, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_porfavor, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_que, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_quepaso, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_quien, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_si, signList.size(), ' '));
        signList.add(new Sign(R.drawable.img_ya, signList.size(), ' '));

    }
}
