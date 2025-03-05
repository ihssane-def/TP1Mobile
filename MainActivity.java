package com.example.registrationform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Récupérer les éléments
        EditText editName = findViewById(R.id.editName);
        EditText editFirstName = findViewById(R.id.editFirstName);
        EditText editEmail = findViewById(R.id.editEmail);
        EditText editPhone = findViewById(R.id.editPhone);
        Spinner spinnerTraining = findViewById(R.id.spinnerTraining);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        // Écouteur pour le bouton
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifier si les champs sont remplis
                if (editName.getText().toString().isEmpty() ||
                        editFirstName.getText().toString().isEmpty() ||
                        editEmail.getText().toString().isEmpty() ||
                        editPhone.getText().toString().isEmpty() ||
                        spinnerTraining.getSelectedItemPosition() == 0) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Récupérer les données
                String name = editName.getText().toString();
                String firstName = editFirstName.getText().toString();
                String email = editEmail.getText().toString();
                String phone = editPhone.getText().toString();
                String training = spinnerTraining.getSelectedItem().toString();

                // Créer un Intent pour passer à la seconde activité
                Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("firstName", firstName);
                intent.putExtra("email", email);
                intent.putExtra("phone", phone);
                intent.putExtra("training", training);
                startActivity(intent);
            }
        });
    }
}