package com.example.seas;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.seas.databinding.ActivityTextSignBinding;

import java.util.ArrayList;
import java.util.List;

public class TextSignActivity extends MainActivity {
    List<Sign> signList = new ArrayList<>();
    ActivityTextSignBinding binding;
    RecyclerView tsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTextSignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        allocateActivityTitle(getString(R.string.menu_text_sign));

        List<Sign> signTranslate = new ArrayList<>();
        EditText edtWrite = binding.stETwrite;
        Button btnMicro = binding.btnMicro;

        setDataSigns();

        tsRecyclerView = binding.tsRecyclerView;
        tsRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));


        int[] selectionStart = {0};
        int[] selectionEnd = {0};
        int[] strLengthBefore = {0};

        edtWrite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                selectionStart[0] = edtWrite.getSelectionStart();
                selectionEnd[0] = edtWrite.getSelectionEnd();
                strLengthBefore[0] = edtWrite.getText().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();
                int strLengthAfter = str.length();

                //Detect if user add or delete a char
                if (strLengthAfter > strLengthBefore[0]) {
                    //add sign
                    int id = getMeanId(getChar(str, selectionEnd[0]));
                    addSign(id, signTranslate, selectionEnd[0]);
                }
                if (strLengthAfter < strLengthBefore[0]) {
                    //remove sign
                    removeSign(selectionStart[0], selectionEnd[0], signTranslate);
                }
                binding.tsRecyclerView.setAdapter(new CardAdapter(signTranslate));
            }
        });

        //Get microphone String
        String strMicro = "  ";
        for (int i=0; i < strMicro.length(); i++){
            //getChar(strMicro, i);
            //add image sign
        }
    }

    private char getChar (String str, int nChar){
        return str.charAt(nChar);
    }

    private char getChar (String str, int[] nChar){
        char c = str.charAt(nChar[0]);

        nChar[0] +=1;
        return c;
    }

    private void addSign (int id, List<Sign> signTranslate, int tvPosition){
        signTranslate.add(tvPosition, signList.get(id));
    }

    private void removeSign (int selectionStart, int selectionEnd, List<Sign> signTranslate){
        if (selectionEnd > selectionStart) {
            signTranslate.subList(selectionStart, selectionEnd).clear();
        }
        else {
            signTranslate.remove(selectionEnd-1);
        }
    }

    private int getMeanId (char c) {
        int j=0;

        for (int i = 0; i<signList.size(); i++){
            char c1 = signList.get(i).mean;
            if (c1 == c || chToLowerCase(c1) == c){
                j=i;
                break;
            }
        }

        return j;
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


    private char chToLowerCase(char c1){
        int temp = (int)c1;
        temp = temp+32;
        c1=(char)temp;
        return c1;
    }
}