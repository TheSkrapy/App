package com.example.seas;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.navigation.ui.AppBarConfiguration;
import com.example.seas.databinding.ActivityHomeBinding;

public class HomeActivity extends MainActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         binding = ActivityHomeBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());

        CardView card1 = binding.card1;
        card1.setOnClickListener(view ->
                startActivity(new Intent(view.getContext(),TextSignActivity.class))
        );

        allocateActivityTitle(getString(R.string.menu_main));
    }

}