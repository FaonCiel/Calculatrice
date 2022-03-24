package com.example.calculatrice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatrice.End_Game;
import com.example.calculatrice.R;

import java.util.Random;

public class Calcul_activity extends AppCompatActivity {

    private Integer premierElement = 0;
    private Integer deuxiemeElement = 0;
    private Double Resultat = 0.0;
    private TypeOperationEnum typeOperation;
    private TextView textViewCalcul;
    private TextView textViewSaisieUtilisateur;
    private Integer saisieUtilisateur = 0;
    private Integer Score = 0;
    private Integer Vie = 3;
    private TextView textViewScore;
    private boolean Negatif = false;
    private TextView textViewVie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        textViewCalcul = findViewById(R.id.TextViewCalcul);
        textViewSaisieUtilisateur = findViewById(R.id.TextViewSaisieUtilisateur);
        textViewScore = findViewById(R.id.Button_Score);
        textViewVie = findViewById(R.id.Text_View_Score);
        Button bouton1 = findViewById(R.id.bouton_1);
        bouton1.setOnClickListener(view -> ajouteValeur(1));
        Button bouton2 = findViewById(R.id.bouton_2);
        bouton2.setOnClickListener(view -> ajouteValeur(2));
        Button bouton3 = findViewById(R.id.bouton_3);
        bouton3.setOnClickListener(view -> ajouteValeur(3));
        Button bouton4 = findViewById(R.id.bouton_4);
        bouton4.setOnClickListener(view -> ajouteValeur(4));
        Button bouton5 = findViewById(R.id.bouton_5);
        bouton5.setOnClickListener(view -> ajouteValeur(5));
        Button bouton6 = findViewById(R.id.bouton_6);
        bouton6.setOnClickListener(view -> ajouteValeur(6));
        Button bouton7 = findViewById(R.id.bouton_7);
        bouton7.setOnClickListener(view -> ajouteValeur(7));
        Button bouton8 = findViewById(R.id.bouton_8);
        bouton8.setOnClickListener(view -> ajouteValeur(8));
        Button bouton9 = findViewById(R.id.bouton_9);
        bouton9.setOnClickListener(view -> ajouteValeur(9));
        Button bouton0 = findViewById(R.id.bouton_0);
        bouton0.setOnClickListener(view -> ajouteValeur(0));
        Button Valider = findViewById(R.id.Valider);

        new Difficulty().getDifficulty();

        Valider.setOnClickListener(view -> Verif());
        Button moins = findViewById(R.id.Moins);
        moins.setOnClickListener(view -> estNegatif());
        New_Calcul();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        MenuItem toolbarVider = menu.findItem(R.id.toolbarVider);
        toolbarVider.setOnMenuItemClickListener(menuItem -> Nettoyer());
        return true;
    }

    private boolean Nettoyer() {
        textViewSaisieUtilisateur.setText("");
        saisieUtilisateur = 0;
        Negatif = false;
        return true;
    }


    private void New_Calcul() {
        premierElement = getRandomNumber(1, 100);
        deuxiemeElement = getRandomNumber(1, 100);
        typeOperation = randomSymbol(TypeOperationEnum.class);
        textViewSaisieUtilisateur.setText("");
        textViewScore.setText(getString(R.string.Score));
        textViewVie.setText(getString(R.string.Vie) + Vie);

        majTextView();
        calculResultat();

    }


    public int getRandomNumber(int min, int max) {

        return (new Random()).nextInt((max - min) + 1) + min;
    }

    public static <T extends Enum<?>> T randomSymbol(Class<T> clazz) {
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    private void majTextView() {
        String textAAfficher = "";
        textAAfficher = premierElement.toString() + " " + typeOperation.getSymbol().toString() + " " + deuxiemeElement.toString();
        textViewCalcul.setText(textAAfficher);
    }

    private void majTextViewUser(String Text) {
        textViewSaisieUtilisateur.setText(Text);
    }

    private void UpdateVie() {
        Vie--;
        textViewVie.setText("Vie :" + Vie);
    }

    private void UpdateScore() {
        Score++;
        textViewScore.setText(getString(R.string.Score) + Score);

    }

    private void ajouteValeur(int Nb) {
        if (!Negatif) {
            saisieUtilisateur = saisieUtilisateur * 10 + Nb;
            majTextViewUser(saisieUtilisateur.toString());
        } else {
            saisieUtilisateur = saisieUtilisateur * 10 - Nb;
            majTextViewUser(saisieUtilisateur.toString());
        }
    }

    private void estNegatif() {
        Negatif = true;
        saisieUtilisateur = saisieUtilisateur * -1;
    }

    private boolean calculResultat() {

        Double resultat = 0.0;
        if (typeOperation != null) {
            switch (typeOperation) {
                case ADD:
                    resultat = (double) (premierElement + deuxiemeElement);
                    break;
                case MULTIPLY:
                    resultat = (double) (premierElement * deuxiemeElement);
                    break;
                case SUBSTRACT:
                    resultat = (double) (premierElement - deuxiemeElement);
                    break;
                    /*
                        case DIVIDE:
                        resultat = (double) premierElement / deuxiemeElement;
                        break;
                    */
            }
        }
        return true;
    }

    private void Verif() {
        switch (typeOperation) {
            case ADD:
                Resultat = (double) (premierElement + deuxiemeElement);
                break;
            case MULTIPLY:
                Resultat = (double) (premierElement * deuxiemeElement);
                break;
            case SUBSTRACT:
                Resultat = (double) (premierElement - deuxiemeElement);
                break;
            /*
                case DIVIDE:
                Resultat = (double) premierElement/deuxiemeElement;
                break;
            */
        }
        if (Resultat == (double) saisieUtilisateur) {
            New_Calcul();
            UpdateScore();
            saisieUtilisateur = 0;
            Negatif = false;
        } else {
                if (Vie <= 0) {

                    Intent i = new Intent(this, End_Game.class);
                    i.putExtra("Score",Score);
                    startActivity(i);
                    finish();

                } else {
                Toast.makeText(this, getString(R.string.Erreur_res), Toast.LENGTH_LONG).show();
                saisieUtilisateur = 0;
                UpdateVie();
                majTextViewUser("");
            }
        }
    }
}

