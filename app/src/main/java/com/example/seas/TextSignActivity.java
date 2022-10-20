package com.example.seas;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.seas.databinding.ActivityTextSignBinding;

import java.util.ArrayList;
import java.util.List;

public class TextSignActivity extends MainActivity {
    List<Sign> signList = new ArrayList<>();
    ActivityTextSignBinding binding;
    EditText edtWrite;
    Button btnMicro;
    RecyclerView tsRecyclerView;
    private static final int RECOGNIZER_RESULT = 1;
    int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTextSignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        allocateActivityTitle(getString(R.string.menu_text_sign));

        List<Sign> signTranslate = new ArrayList<>();
        edtWrite = binding.stETwrite;
        btnMicro = binding.btnMicro;

        setDataSigns();

        tsRecyclerView = binding.tsRecyclerView;
        tsRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

        int[] selectionStart = {0};
        int[] selectionEnd = {0};
        int[] strLengthBefore = {0};

        edtWrite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Detect if the edtText is empty
                if (signTranslate.size() == 0){
                    selectionStart[0] = 0;
                    selectionEnd[0] = 0;
                    strLengthBefore[0] = 0;
                }
                else {
                    selectionStart[0] = edtWrite.getSelectionStart();
                    selectionEnd[0] = edtWrite.getSelectionEnd();
                    strLengthBefore[0] = edtWrite.getText().length();
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();
                int strLengthAfter = str.length();

                //Detect if user add or delete text
                if (strLengthAfter > strLengthBefore[0]) {
                    int lastChar;
                    boolean textFromMicro = false;

                    //Detect if text is from micro
                    if (strLengthAfter - strLengthBefore[0] > 1){
                        textFromMicro = true;
                    }

                    //Detect if new char is between the text example hel|lo OR is the last char ex hello|
                    if (!textFromMicro && strLengthAfter - selectionEnd[0] > 1){//Char between text
                        lastChar = selectionEnd[0];
                    }
                    else {//Last char
                        lastChar = strLengthAfter - 1;
                    }

                    for (int i = selectionStart[0]; i <= lastChar; i++) {
                        int id = getMeanId(getChar(str, i));
                        addSign(id, signTranslate, i);
                    }
                }

                if (strLengthAfter < strLengthBefore[0]) {
                    removeSign(selectionStart[0], selectionEnd[0], signTranslate);
                }

                //Update cards in recyclerview
                binding.tsRecyclerView.setAdapter(new CardAdapter(signTranslate));
            }
        });

        //Get microphone String
        btnMicro.setOnClickListener(view -> {
            signTranslate.clear();
            Intent speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            speechIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voz a texto");
            startActivityForResult(speechIntent, RECOGNIZER_RESULT);
        });
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == RECOGNIZER_RESULT && resultCode == RESULT_OK){
            ArrayList<String> matches = null;
            if (data != null) {
                matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            }
            edtWrite.setText(matches.get(0));
        }
        super.onActivityResult(requestCode, resultCode, null);
    }

    private char getChar (String str, int nChar){
        return str.charAt(nChar);
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