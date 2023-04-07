package com.example.jeucalculfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {


    private TextView textViewScore1;
    private TextView textViewScore2;

    private TextView textViewScore3;

    private TextView textViewScore4;

    private TextView textViewScore5;
    private TextView textViewPseudo1;
    private TextView textViewPseudo2;
    private TextView textViewPseudo3;
    private TextView textViewPseudo4;
    private TextView textViewPseudo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        getSupportActionBar().hide();
        MyDBHelper dbHelper = new MyDBHelper(this);

        textViewScore1 = findViewById(R.id.text_score_1);
        textViewScore2 = findViewById(R.id.text_score_2);
        textViewScore3 = findViewById(R.id.text_score_3);
        textViewScore4 = findViewById(R.id.text_score_4);
        textViewScore5 = findViewById(R.id.text_score_5);

        textViewPseudo1 = findViewById(R.id.text_pseudo1);
        textViewPseudo2 = findViewById(R.id.text_pseudo2);
        textViewPseudo3 = findViewById(R.id.text_pseudo3);
        textViewPseudo4 = findViewById(R.id.text_pseudo4);
        textViewPseudo5 = findViewById(R.id.text_pseudo5);





        ArrayList<ModalScore> data = dbHelper.fetchScore();
        textViewScore1.setText("Score : " + data.get(0).score);
        textViewScore2.setText("Score : " + data.get(1).score);
        textViewScore3.setText("Score : " + data.get(2).score);
        textViewScore4.setText("Score : " + data.get(3).score);
        textViewScore5.setText("Score : " + data.get(4).score);

        textViewPseudo1.setText(data.get(0).pseudo);
        textViewPseudo2.setText(data.get(1).pseudo);
        textViewPseudo3.setText(data.get(2).pseudo);
        textViewPseudo4.setText(data.get(3).pseudo);
        textViewPseudo5.setText(data.get(4).pseudo);
        /*
        for(int i =0; i < data.size(); i++){
            Log.d("SCORE INFO", "Score" + data.get(i).score + "Pseudo" + data.get(i).pseudo);
        }

        ArrayAdapter<ModalScore> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
*/
        //listView.setAdapter(adapter);

    }
}