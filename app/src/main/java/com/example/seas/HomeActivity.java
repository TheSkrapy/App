package com.example.seas;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.seas.databinding.ActivityHomeBinding;

public class HomeActivity extends MainActivity {

    private AppBarConfiguration appBarConfiguration;
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

        allocateActivityTitle("Home");
    }

}