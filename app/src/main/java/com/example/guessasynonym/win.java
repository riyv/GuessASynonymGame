package com.example.guessasynonym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class win extends AppCompatActivity {
    private Button playAgain;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);

        playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(win.this, MainActivity.class);
                startActivity(goBack);
            }
        });



    }
}
