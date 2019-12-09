package com.example.guessasynonym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lose extends AppCompatActivity {
    private Button playAgain;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose);

        playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(lose.this, MainActivity.class);
                startActivity(goBack);
            }
        });



    }
}
