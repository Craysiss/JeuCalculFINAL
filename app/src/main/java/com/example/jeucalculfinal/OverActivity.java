package com.example.jeucalculfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class OverActivity extends AppCompatActivity {

    private Button boutonRejouer;
    private Button boutonMenu;
    private TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
        getSupportActionBar().hide();
        textViewScore = findViewById(R.id.text_nb_score_over);
        textViewScore.setText(Integer.toString(GameActivity.score));

        boutonRejouer = findViewById(R.id.btn_rejouer);
        boutonRejouer.setOnClickListener(view -> {
            Intent intent = new Intent(OverActivity.this,GameActivity.class);
            startActivity(intent);
        });

        boutonMenu = findViewById(R.id.btn_direct_menu);
        boutonMenu.setOnClickListener(view -> {
            Intent intent = new Intent(OverActivity.this,MainActivity.class);
            startActivity(intent);
        });
    }
}