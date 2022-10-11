package com.example.seas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.seas.databinding.ActivityTextSignBinding;

import java.util.ArrayList;
import java.util.List;

public class Basics extends AppCompatActivity {
    List<Sign> signList = new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createSigns();
    }
    private void createSigns (){
        Sign sign1 = new Sign(R.drawable.img_bien, signList.size(),'A');
        signList.add(sign1);
        Sign sign2 = new Sign(R.drawable.img_como, signList.size(),'A');
        signList.add(sign2);
        Sign sign3 = new Sign(R.drawable.img_como, signList.size(),'A');
        signList.add(sign3);
        Sign sign4 = new Sign(R.drawable.img_cual, signList.size(),'A');
        signList.add(sign4);
        Sign sign5 = new Sign(R.drawable.img_cuando, signList.size(),'A');
        signList.add(sign5);
        Sign sign6 = new Sign(R.drawable.img_cuantos, signList.size(),'A');
        signList.add(sign6);
        Sign sign7 = new Sign(R.drawable.img_donde, signList.size(),'A');
        signList.add(sign7);
        Sign sign8 = new Sign(R.drawable.img_es, signList.size(),'A');
        signList.add(sign8);
        Sign sign9 = new Sign(R.drawable.img_gracias, signList.size(),'A');
        signList.add(sign9);
        Sign sign10 = new Sign(R.drawable.img_mal, signList.size(),'A');
        signList.add(sign10);
        Sign sign11 = new Sign(R.drawable.img_no, signList.size(),'A');
        signList.add(sign11);
        Sign sign12 = new Sign(R.drawable.img_para, signList.size(),'A');
        signList.add(sign12);
        Sign sign13 = new Sign(R.drawable.img_perdon, signList.size(),'A');
        signList.add(sign13);
        Sign sign14 = new Sign(R.drawable.img_por, signList.size(),'A');
        signList.add(sign14);
        Sign sign15 = new Sign(R.drawable.img_porfavor, signList.size(),'A');
        signList.add(sign15);
        Sign sign16 = new Sign(R.drawable.img_que, signList.size(),'A');
        signList.add(sign16);
        Sign sign17 = new Sign(R.drawable.img_quepaso, signList.size(),'A');
        signList.add(sign17);
        Sign sign18 = new Sign(R.drawable.img_quien, signList.size(),'A');
        signList.add(sign18);
        Sign sign19 = new Sign(R.drawable.img_si, signList.size(),'A');
        signList.add(sign19);
        Sign sign20 = new Sign(R.drawable.img_ya, signList.size(),'A');
        signList.add(sign20);

    }

}