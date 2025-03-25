package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Scrivere la preferenza
        SharedPreferences sp = getSharedPreferences("Test", Context.MODE_PRIVATE);
        sp.edit().putString("modalita","dark").apply();

        // Leggere la preferenza
        SharedPreferences sp = getSharedPreferences("Test", Context.MODE_PRIVATE);
        String modalita = sp.getString("modalita","");


    }

    public void goToSecondActivityButtonClicked(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("nome","Pinco");
        intent.putExtra("cognome", "Pallino");
        intent.putExtra("eta",50);
        startActivity(intent);
    }
}