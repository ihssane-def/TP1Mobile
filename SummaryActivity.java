package com.example.registrationform;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Récupérer les données de l'Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String firstName = extras.getString("firstName");
            String email = extras.getString("email");
            String phone = extras.getString("phone");
            String training = extras.getString("training");

            // Afficher le récapitulatif
            TextView textSummary = findViewById(R.id.textSummary);
            String summary = "Nom : " + name + "\n" +
                    "Prénom : " + firstName + "\n" +
                    "Email : " + email + "\n" +
                    "Téléphone : " + phone + "\n" +
                    "Formation : " + training;
            textSummary.setText(summary);
        }
    }
}