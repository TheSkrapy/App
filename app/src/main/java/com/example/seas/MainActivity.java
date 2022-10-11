package com.example.seas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView card1 = findViewById(R.id.card1);
        card1.setOnClickListener(view ->
                startActivity(new Intent(view.getContext(),TextSignActivity.class))
        );
    }

}