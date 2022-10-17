package com.example.seas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.seas.databinding.ActivitySignTextBinding;
import com.example.seas.interfaces.OnSignTextClick;

import java.util.ArrayList;
import java.util.List;

public class SignTextActivity extends MainActivity implements OnSignTextClick {
    List<Sign> signList = new ArrayList<>();
    ActivitySignTextBinding binding;
    TextView txtViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignTextBinding.inflate(getLayoutInflater());
        txtViewResult = binding.stTVresult;
        setContentView(binding.getRoot());

        allocateActivityTitle(getString(R.string.menu_sign_text));
        setDataSigns();

        RecyclerView recyclerView = binding.stRecyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        recyclerView.setAdapter(new CardStAdapter(signList, this));

        //Listen audio
    }

    private void setDataSigns (){
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
        signList.add(new Sign(R.drawable.img_blanco, -1, ' '));
    }

    @Override
    public void onClick(String mean) {
        String result = txtViewResult.getText() + mean;
        txtViewResult.setText(result);
    }
}



