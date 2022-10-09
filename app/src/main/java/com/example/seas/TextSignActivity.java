package com.example.seas;

import androidx.annotation.NonNull;
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

public class TextSignActivity extends AppCompatActivity {
    List<Sign> signList = new ArrayList<>();
    ActivityTextSignBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTextSignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        List<Sign> signTranslate = new ArrayList<>();

        createSigns();

        Activity textSignActivity = this;
        binding.tsRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

        EditText edtWrite = findViewById(R.id.st_eTwrite);
        int[] nChar = {0};

        edtWrite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();

                //Detect if user add or delete a char
                if (str.length() > nChar[0]){
                    //add sign
                    signTranslate.add(signList.get(getMeanId(signList, getChar(str, nChar))));
                    binding.tsRecyclerView.setAdapter(new CardAdapter(signTranslate));
                }
                else{
                    //remove sign

                    nChar[0] -= 1;
                }

            }
        });

        //Get microphone String
        String strMicro = "  ";
        for (int i=0; i < strMicro.length(); i++){
            getChar(strMicro, i);
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
            if (listOrigin.get(i).mean == c){
                j=i;
                break;
            }
        }

        return j;
    }

    private void createSigns (){
        Sign sign1 = new Sign(R.drawable.ic_baseline_keyboard_voice_24, signList.size(), 'A');
        signList.add(sign1);
        Sign sign2 = new Sign(R.drawable.ic_baseline_keyboard_voice_24, signList.size(), 'B');
        signList.add(sign2);
        Sign sign3 = new Sign(R.drawable.ic_baseline_keyboard_voice_24, signList.size(), 'C');
        signList.add(sign3);
        Sign sign4 = new Sign(R.drawable.ic_baseline_keyboard_voice_24, signList.size(), 'D');
        signList.add(sign4);
        signList.add(sign1);
        signList.add(sign2);
    }


}