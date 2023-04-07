package com.example.jeucalculfinal;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class GameActivity extends AppCompatActivity {


    private String calcul = "";
    private TextView textViewCalcul;
    private TextView textViewResultat;
    private TextView text_score_nb;
    private TextView text_nb_vie;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private Button buttonSup;
    private Button buttonVal;
    private Integer compteurTaille = 0;
    int resultat = 0;

    public static int score = 0;
    public static String pseudo = "Simon";
    int vies = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();



        textViewResultat = findViewById(R.id.textViewResultat);
        textViewCalcul = findViewById(R.id.textViewCalcul);
        text_nb_vie = findViewById(R.id.text_nb_vie);
        text_score_nb = findViewById(R.id.text_score_nb);


        buttonOne = findViewById(R.id.button_1);
        buttonOne.setOnClickListener(view -> ajouterNombre("1"));
        buttonTwo = findViewById(R.id.button_2);
        buttonTwo.setOnClickListener(view -> ajouterNombre("2"));
        buttonThree = findViewById(R.id.button_3);
        buttonThree.setOnClickListener(view -> ajouterNombre("3"));
        buttonFour = findViewById(R.id.button_4);
        buttonFour.setOnClickListener(view -> ajouterNombre("4"));
        buttonFive = findViewById(R.id.button_5);
        buttonFive.setOnClickListener(view -> ajouterNombre("5"));
        buttonSix = findViewById(R.id.button_6);
        buttonSix.setOnClickListener(view -> ajouterNombre("6"));
        buttonSeven = findViewById(R.id.button_7);
        buttonSeven.setOnClickListener(view -> ajouterNombre("7"));
        buttonEight = findViewById(R.id.button_8);
        buttonEight.setOnClickListener(view -> ajouterNombre("8"));
        buttonNine = findViewById(R.id.button_9);
        buttonNine.setOnClickListener(view -> ajouterNombre("9"));
        buttonZero = findViewById(R.id.button_0);
        buttonZero.setOnClickListener(view -> ajouterNombre("0"));
        buttonSup = findViewById(R.id.button_supprimer);
        buttonSup.setOnClickListener(view -> supprimerDernierCaractere());
        buttonVal = findViewById(R.id.button_valider);
        buttonVal.setOnClickListener(view -> VerifierResultat());

        GenererCalcul();
        VerifierResultat();

    }



    private boolean ajouterCharactere(String charactereAAjouter) {
        calcul += charactereAAjouter;
        textViewResultat.setText(calcul);
        return true;
    }


    private boolean supprimerDernierCaractere() {
        if (calcul.length() > 0) {
            calcul = calcul.substring(0, calcul.length() - 1);
            textViewResultat.setText(calcul);
            compteurTaille--;
            return true;
        } else {
            return false;
        }
    }


    private boolean ajouterNombre(String nombre) {
        if (compteurTaille >= 4) {
            Toast.makeText(this, getString(R.string.ERROR_TOO_LONG), Toast.LENGTH_LONG).show();
        } else {
            compteurTaille++;
            ajouterCharactere(nombre);
        }
        return true;
    }


    public String GenererCalcul() {
        Random random = new Random();
        int valeur1 = random.nextInt(11); // Générer un nombre entre 1 et 10
        int valeur2 = random.nextInt(11); // Générer un nombre entre 1 et 10
        int operation = random.nextInt(2); // Générer un entier entre 0 et 1
        char operateur;

        switch(operation) {
            case 0:
                operateur = '+';
                resultat = valeur1 + valeur2;
                break;
            default:
                operateur = '*';
                resultat = valeur1 * valeur2;
                break;

        }
        String calcul = valeur1 + " " + operateur + " " + valeur2 + " = ?";
        textViewCalcul.setText(calcul);
        return calcul;
    }

    private void VerifierResultat() {
        if (calcul.isEmpty()) {
            return;
        }

        Integer ResultatUtilisateur = Integer.parseInt(textViewResultat.getText().toString());



        if(resultat == ResultatUtilisateur) {
            score++;
            text_score_nb.setText(Integer.toString(score));
        }

        else {vies--;}


        text_nb_vie.setText(Integer.toString(vies));

        // Réinitialisation du calcul et du compteur de taille
        calcul = "";
        compteurTaille = 0;

        if(vies == 0){

            MyDBHelper dbHelper = new MyDBHelper(this);
            dbHelper.addScore(Integer.toString(score), pseudo);

            Intent intent = new Intent(GameActivity.this,OverActivity.class);
            startActivity(intent);
        }
        textViewResultat.setText(" ");
        // Génération d'un nouveau calcul
        GenererCalcul();
    }








}