package com.example.seas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TableLayout;

public class TextSignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_sign);

        EditText edtWrite = findViewById(R.id.st_eTwrite);
        int[] nChar = new int[1];
        int[] oldLengthStr = {0};

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
                if (str.length() > oldLengthStr[0]){
                    getChar(str, nChar);
                    //add sign

                    oldLengthStr[0] +=1;
                }
                else{
                    //remove sign

                    oldLengthStr[0] -= 1;
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
}