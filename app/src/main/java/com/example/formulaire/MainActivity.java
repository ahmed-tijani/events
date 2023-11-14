package com.example.formulaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText name,lastName, email, password;
    CheckBox gaming,cinema,musique,foot;
    RadioButton homme,femme;
    Button submit ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        name= findViewById(R.id.nameET);
        lastName=findViewById(R.id.lastNameEt);
        email=findViewById(R.id.emailEt);
        password=findViewById(R.id.passwordEt);

        homme=findViewById(R.id.homme);
                femme=findViewById(R.id.femme);
        submit=findViewById(R.id.validier);
        submit.setOnClickListener(e -> {
            Intent intent = new Intent(this,ShowActivity.class);

            String hobbiees = "";
            String genre = "";
            if(homme.isChecked()){
                genre = " Homme";


            }else {
                genre = " Femme";


            }

            intent.putExtra("name",name.getText().toString());
            intent.putExtra("lastname",lastName.getText().toString());
            intent.putExtra("email",email.getText().toString());
            intent.putExtra("password",password.getText().toString());
            intent.putExtra("genere",genre);




            startActivity(intent);






        });

    }
}