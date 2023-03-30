package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
     int randomNumber;
    public void OnClickButton(View view ){
        EditText editText=findViewById(R.id.editTextNumber);
        int EnteredNumber =Integer.parseInt(editText.getText().toString());
        String message;
        if(EnteredNumber< randomNumber){
            message="Enter a higher number";
        } else if (EnteredNumber>randomNumber) {
            message="Enter a lower number";
        }else {
            message="Congratulations!,You got a right one.";
            Button playagainButton=findViewById(R.id.button2);
            playagainButton.setVisibility(View.VISIBLE);
            playagainButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    generaterandomnumber();
                    OnClickButton(v);
                    Button playagainButton=findViewById(R.id.button2);
                    playagainButton.setVisibility(View.INVISIBLE);

                }
            });

        }
        Snackbar.make(view,message,Snackbar.LENGTH_LONG).show();


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generaterandomnumber();

        // to visible the button
        Button playagainButton=findViewById(R.id.button2);
        playagainButton.setVisibility(View.INVISIBLE);

    }

    private void generaterandomnumber() {
        //to generate the number
        Random random=new Random();
        randomNumber=random.nextInt(20)+1;
    }
}