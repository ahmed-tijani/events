package com.example.formulaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    TextView affiche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        affiche = findViewById(R.id.affiche);

        affiche.setText(getIntent().getStringExtra("name") + " "+ getIntent().getStringExtra("lastname")  + " "+
                        getIntent().getStringExtra("hobbies")  + " "+
                getIntent().getStringExtra("genere")

                );



    }
}