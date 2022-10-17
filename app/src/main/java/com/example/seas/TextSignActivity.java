package com.example.seas;

import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.seas.databinding.ActivityTextSignBinding;

import java.util.ArrayList;
import java.util.List;

public class TextSignActivity extends MainActivity {
    List<Sign> signList = new ArrayList<>();
    ActivityTextSignBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTextSignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        allocateActivityTitle(getString(R.string.menu_text_sign));

        List<Sign> signTranslate = new ArrayList<>();

        createSigns();

        Activity textSignActivity = this;
        binding.tsRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

        EditText edtWrite = findViewById(R.id.st_eTwrite);
        int[] nChar = {0};
        //selection[0] SelectionStart
        //selection[1] SelectionEnd
        int[] selection = {0, 1};
        int end;
        edtWrite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                selection[0] = edtWrite.getSelectionStart();
                selection[1] = edtWrite.getSelectionEnd();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();

                //Detect if user add or delete a char
                if (nChar[0] >= 0) {
                    if (str.length() > nChar[0]) {
                        //add sign
                        int id = getMeanId(signList, getChar(str, nChar));
                        signTranslate.add(nChar[0] - 1, signList.get(id));
                    }
                    if (str.length() < nChar[0]){
                        //remove sign
                        if (selection[0] != selection[1]){
                            for (int i = selection[1] - 1; i >= selection[0]; i--) {
                                signTranslate.remove(i);
                                nChar[0] -= 1;
                            }
                        }
                        else {
                            for (int i = selection[1] - 1; i >= selection[0] - 1; i--) {
                                signTranslate.remove(i);
                                nChar[0] -= 1;
                            }
                        }
                    }
                    binding.tsRecyclerView.setAdapter(new CardAdapter(signTranslate));
                }
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

    private void addSign (){

    }

    private void removeSign (){

    }

    private int getMeanId (List<Sign> listOrigin, char c) {
        int j=0;
        for (int i = 0; i<listOrigin.size(); i++){
            char c1 = listOrigin.get(i).mean;
            if (c1 == c || chToLowerCase(c1) == c && c != ' '){
                j=i;
                break;
            }
            else {
                if (c == ' '){
                    j = -1;
                }
            }
        }

        return j;
    }

    private void createSigns (){
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