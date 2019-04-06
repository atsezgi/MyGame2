package com.example.lenovo.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class FourtActivity extends AppCompatActivity {
    Random random = new Random();
    private Button first_number;
    private Button second_number;
    private TextView point;
    int randLeft = 0;
    int randRight = 0;
    int points = 0;
    int counter1 = 0;
    int counter2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourt);

        Button buttonFirstNumber = findViewById(R.id.first_number);
        buttonFirstNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1++;
                if (randLeft > randRight) {
                    points++;
                } else if(randLeft == randRight){
                    points+=0;}
                else {
                    points--;
                }


                point = findViewById(R.id.textPoint);
                point.setText(String.valueOf("Score: " + points));

                RandomNumberAssign();
                if((counter1 +counter2)>5){
                    FourthLevel();
                }

            }
        });
        Button buttonSecondNumber = findViewById(R.id.second_number);
        buttonSecondNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                if (randLeft < randRight) {
                    points++;
                }else if(randLeft == randRight){
                    points+=0;}
                else {
                    points--;
                }
                point = findViewById(R.id.textPoint);
                point.setText(String.valueOf("Score: " + points));
                RandomNumberAssign();
                if((counter1 +counter2)>5){
                    FourthLevel();
                }
            }
        });


    }

    public void FourthLevel(){
        Intent intent = new Intent(FourtActivity.this, FifthLevelActivity.class);
        startActivity(intent);

    }




    public void RandomNumberAssign() {
        first_number = findViewById(R.id.first_number);
        second_number = findViewById(R.id.second_number);

        int rndLeft = random.nextInt(40);
        int rndRight = random.nextInt(40);
        first_number.setText(String.valueOf(rndLeft));
        second_number.setText(String.valueOf(rndRight));
        randLeft = rndLeft;
        randRight = rndRight;

    }


}
