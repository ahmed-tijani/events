package com.example.formulaire;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.formulaire.AppDataBase.AppDataBase;
import com.example.formulaire.Interfaces.DAOUser;
import com.example.formulaire.Model.Users;

import com.rey.material.widget.CheckBox;
import com.rey.material.widget.EditText;


// ... (import statements)

public class LoginActivity extends AppCompatActivity {

    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private TextView AdminLink, NotAdminLink;
    private CheckBox chkBoxRememberMe;
    private DAOUser userDao;

    private String parentDbName = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize RoomDatabase
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

        InputPhoneNumber = findViewById(R.id.login_phone_number_input);
        InputPassword = findViewById(R.id.login_password_input);
        LoginButton = findViewById(R.id.login_btn);
        loadingBar = new ProgressDialog(this);
        chkBoxRememberMe = findViewById(R.id.remember_me_chk);
        AdminLink = findViewById(R.id.admin_panel_link);
        NotAdminLink = findViewById(R.id.not_admin_panel_link);

        LoginButton.setOnClickListener(view -> LoginUser());

        AdminLink.setOnClickListener(view -> {
            LoginButton.setText("Login Admin");
            AdminLink.setVisibility(View.INVISIBLE);
            NotAdminLink.setVisibility(View.VISIBLE);
            parentDbName = "Admins";
        });

        NotAdminLink.setOnClickListener(view -> {
            LoginButton.setText("Login");
            AdminLink.setVisibility(View.VISIBLE);
            NotAdminLink.setVisibility(View.INVISIBLE);
            parentDbName = "Users";
        });
    }

    private void LoginUser() {
        String phone = InputPhoneNumber.getText().toString();
        String password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Veuillez entrer votre numéro de téléphone... ", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "S'il vous plaît entrez votre mot de passe...", Toast.LENGTH_SHORT).show();
        } else {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Veuillez patienter pendant que nous vérifions vos coordonnées.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            allowAccessToAccount(phone, password);
        }
    }

    private void allowAccessToAccount(final String phone, final String password) {
        if (chkBoxRememberMe.isChecked()) {
            // Use RoomDatabase to store user information
            new Thread(() -> {
                Users newUser = new Users();
                newUser.setPhone(phone);
                newUser.setPassword(password);

                userDao.insert(newUser);
            }).start();
        }

        // Use RoomDatabase for user authentication
        new Thread(() -> {
            Users user = userDao.getUserByPhone(phone);

            if (user != null && password.equals(user.getPassword())) {
                // Authentication successful
                runOnUiThread(() -> {
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this, "Connecté correctement", Toast.LENGTH_SHORT).show();

                    // Handle user authentication success, e.g., start the next activity
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                });
            } else {
                // Authentication failed
                runOnUiThread(() -> {
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this, "Le mot de passe n'est pas correct.", Toast.LENGTH_SHORT).show();
                });
            }
        }).start();
    }
}
