package com.example.user.navigatelifesaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Chat extends AppCompatActivity {

    String Catagory = "";
    int num = 0 ;
    Thread thread = null;
    int checkButton = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        final LinearLayout firstLin = (LinearLayout)findViewById(R.id.layout2);
        final LinearLayout secLin = (LinearLayout)findViewById(R.id.layout3);
        final LinearLayout thirdLay = (LinearLayout)findViewById(R.id.layout4);
        final LinearLayout forthLay = (LinearLayout)findViewById(R.id.layout5);


        secLin.setVisibility(View.INVISIBLE);
        firstLin.setVisibility(View.INVISIBLE);
        thirdLay.setVisibility(View.INVISIBLE);
        forthLay.setVisibility(View.INVISIBLE);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            Catagory = extras.getString("buttonPressed");
        }

        final Button btnFirst = (Button)findViewById(R.id.button);
        final Button btnSec = (Button)findViewById(R.id.button2);
        try {
            synchronized(this){
                wait(1000);
            }
        }
        catch(InterruptedException ex){
        }
        firstLin.setVisibility(View.VISIBLE);


        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkButton == 0)
                {
                    btnFirst.setText("Yes, I am over 55");
                    btnSec.setText("No, I am Not over 55");

                    try {
                        synchronized(this){
                            wait(400);
                        }
                    }
                    catch(InterruptedException ex){
                    }
                    secLin.setVisibility(View.VISIBLE);
                    checkButton++;
                }


                else if(checkButton == 1)
                {
                    btnFirst.setText("Yes, I was exposed to very loud noises");
                    btnSec.setText("No, I don't remember I was exposed to loud noise");

                    try {
                        synchronized(this){
                            wait(400);
                        }
                    }
                    catch(InterruptedException ex){
                    }
                    thirdLay.setVisibility(View.VISIBLE);
                    checkButton++;
                }

                else if(checkButton == 2)
                {
                    btnFirst.setText("Go out to see results");
                    btnSec.setVisibility(View.INVISIBLE);

                    try {
                        synchronized(this){
                            wait(400);
                        }
                    }
                    catch(InterruptedException ex){
                    }
                    forthLay.setVisibility(View.VISIBLE);
                    checkButton++;
                }
            }
        });

        btnSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkButton == 0)
                {
                    btnFirst.setText("Yes, I am over 55");
                    btnSec.setText("No, I am Not over 55");

                    try {
                        synchronized(this){
                            wait(400);
                        }
                    }
                    catch(InterruptedException ex){
                    }
                    thirdLay.setVisibility(View.VISIBLE);
                    checkButton++;
                }


                else if(checkButton == 1)
                {
                    btnFirst.setText("Yes, I am over 55");
                    btnSec.setText("No, I am Not over 55");
                    checkButton++;
                }
            }
        });
    }
}
