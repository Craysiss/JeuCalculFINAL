package com.example.jeucalculfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button boutonJouer;
    private Button boutonScore;
    private EditText EditTextPseudo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        EditTextPseudo = findViewById(R.id.text_pseudo);
        EditTextPseudo.setText(GameActivity.pseudo);

        boutonJouer = findViewById(R.id.btn_play);
        boutonJouer.setOnClickListener(view -> {
            GameActivity.pseudo=EditTextPseudo.getText().toString();
            Intent intent = new Intent(MainActivity.this,GameActivity.class);
            startActivity(intent);
        });

        boutonScore = findViewById(R.id.btn_highscore);
        boutonScore.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ScoreActivity.class);
            startActivity(intent);
        });
    }
}