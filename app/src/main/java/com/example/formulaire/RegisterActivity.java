package com.example.formulaire;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.formulaire.AppDataBase.AppDataBase;
import com.example.formulaire.Interfaces.DAOUser;
import com.example.formulaire.Model.Users;
import com.rey.material.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private Button createAccountButton;
    private EditText inputName, inputPhoneNumber, inputPassword;
    private ProgressDialog loadingBar;
    private DAOUser userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        createAccountButton = findViewById(R.id.register_btn);
        inputName = findViewById(R.id.register_username_input);
        inputPhoneNumber = findViewById(R.id.register_phone_number_input);
        inputPassword = findViewById(R.id.register_password_input);
        loadingBar = new ProgressDialog(this);

        AppDataBase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "app-database")
                .addMigrations(new Migration(1, 6) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        // Ajoutez ici les déclarations SQL nécessaires pour migrer de la version 1 à la version 6
                        // Par exemple, si vous avez ajouté une nouvelle colonne, vous pouvez utiliser quelque chose comme :
                        // database.execSQL("ALTER TABLE votre_table ADD COLUMN nouvelle_colonne TEXT");
                    }
                })
                .build();
        userDao = appDatabase.userDao();

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });
    }

    private void CreateAccount() {
        String name = inputName.getText().toString();
        String phone = inputPhoneNumber.getText().toString();
        String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter all required fields", Toast.LENGTH_SHORT).show();
        } else {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait while we verify your details.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            // Check if the user already exists in the database
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Users existingUser = userDao.getUserByPhone(phone);

                    if (existingUser == null) {
                        // User does not exist, create a new user
                        Users newUser = new Users();
                        newUser.setName(name);
                        newUser.setPhone(phone);
                        newUser.setPassword(password);

                        userDao.insert(newUser);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this, "Congratulations, your account has been created.", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        });
                    } else {
                        // User already exists
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this, "An account with phone number " + phone + " already exists.", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                                Toast.makeText(RegisterActivity.this, "Please try again with a different phone number.", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }).start();
        }
    }

/*
    private void validatePhoneNumber(final String name, final String phone, final String password) {
        // Check if the user already exists in the database
        new Thread(new Runnable() {
            @Override
            public void run() {
                Users existingUser = userDao.getUserByPhone(phone);

                if (existingUser == null) {
                    // User does not exist, create a new user
                    Users newUser = new Users();
                    newUser.setName(name);
                    newUser.setPhone(phone);
                    newUser.setPassword(password);

                    userDao.insert(newUser);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this, "Félicitations, votre compte a été créé.", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();

                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    // User already exists
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this, "Compte avec numéro " + phone + " existe déjà.", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                            Toast.makeText(RegisterActivity.this, "Veuillez réessayer avec un autre numéro de téléphone.", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        }).start();
    }
*/
}
