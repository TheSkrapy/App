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

        binding.card1.setOnClickListener(view ->
                startActivity(new Intent(view.getContext(),TextSignActivity.class))
        );
        binding.card2.setOnClickListener(view->
                startActivity(new Intent(view.getContext(), SignTextActivity.class))
        );
        binding.card3.setOnClickListener(view->
                startActivity(new Intent(view.getContext(), Menu_activity.class))
        );

        allocateActivityTitle(getString(R.string.menu_main));
    }

}