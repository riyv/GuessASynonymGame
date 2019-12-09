package com.example.guessasynonym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //TextView timer = findViewById(R.id.timer);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butt();


    }
    public void butt() {
        Button easy = (Button) findViewById(R.id.easy);
        //timer = findViewById(R.id.timer);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gas.setTime(180000);
                startActivity(new Intent(MainActivity.this, gas.class));
                //timer.setText("2:00");
            }
        });

        Button medium = (Button) findViewById(R.id.medium);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gas.setTime(120000);
                startActivity(new Intent(MainActivity.this, gas.class));
            }
        });

        Button hard = (Button) findViewById(R.id.hard);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gas.setTime(60000);
                startActivity(new Intent(MainActivity.this, gas.class));
            }
        });


    }
}
