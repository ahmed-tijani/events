package tn.esprit.healthcareapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import tn.esprit.healthcareapp.database.AppDatabase;
import tn.esprit.healthcareapp.entities.Article;


public class articleActivity extends AppCompatActivity {

    private EditText editTexttitre, editTextdatedebut, editTextdatefin;
    private AppDatabase appDatabase;
    private Calendar selectedDateTime;
    private EditText activeEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rdv);

        appDatabase = AppDatabase.getAppDatabase(this);

        editTexttitre = findViewById(R.id.titre);
        editTextdatedebut = findViewById(R.id.datedebut);
        editTextdatefin = findViewById(R.id.datefin);

        Button addButton = findViewById(R.id.button_addRdv);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titre = editTexttitre.getText().toString();
                String datedebut = editTextdatedebut.getText().toString();
                String datefin = editTextdatefin.getText().toString();

                if (titre.isEmpty() || datedebut.isEmpty() || datefin.isEmpty()) {
                    Toast.makeText(articleActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Article rdv = new Article();
                    rdv.setTitle(titre);
                    rdv.setStartRdv(datedebut);
                    rdv.setEndRdv(datefin);
                    appDatabase.articleDao().insertRdv(rdv);

                    String message = "Nom de l'événement: " + titre + "\nDatedebut: " + datedebut + "\nDatefin: " + datefin;
                    Toast.makeText(articleActivity.this, message, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(articleActivity.this, RetrieveArticActivity.class);
                    startActivity(intent);
                }
            }
        });

        editTextdatedebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePickerDialog(editTextdatedebut);
            }
        });

        editTextdatefin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePickerDialog(editTextdatefin);
            }
        });
    }

    private void showDateTimePickerDialog(EditText editText) {
        activeEditText = editText;

        final Calendar currentDate = Calendar.getInstance();
        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH);
        int day = currentDate.get(Calendar.DAY_OF_MONTH);
        int hour = currentDate.get(Calendar.HOUR_OF_DAY);
        int minute = currentDate.get(Calendar.MINUTE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                articleActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        selectedDateTime = Calendar.getInstance();
                        selectedDateTime.set(Calendar.YEAR, year);
                        selectedDateTime.set(Calendar.MONTH, monthOfYear);
                        selectedDateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        TimePickerDialog timePickerDialog = new TimePickerDialog(
                                articleActivity.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                        selectedDateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                        selectedDateTime.set(Calendar.MINUTE, minute);

                                        updateEditTextWithDateTime(activeEditText, selectedDateTime);
                                    }
                                },
                                hour,
                                minute,
                                true
                        );
                        timePickerDialog.show();
                    }
                },
                year,
                month,
                day
        );

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    private void updateEditTextWithDateTime(EditText editText, Calendar dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        editText.setText(dateFormat.format(dateTime.getTime()));
    }

    public void showDateTimePickerDialog(View view) {
    }
}
