package com.example.formulaire;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.Toast;

import com.example.formulaire.AppDataBase.AppDataBase;
import com.example.formulaire.Interfaces.DAOEvents;
import com.example.formulaire.Interfaces.DAOUser;
import com.example.formulaire.Model.Events;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.rey.material.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class AdminAddNewEventActivity extends AppCompatActivity
{
    private String CategoryName, Name, Place, Time, Date, Limit, Price, saveCurrentDate, saveCurrentTime;
    private Button AddNewEventButton;
    private ImageView InputEventImage;
    private EditText InputEventName, InputEventPlace, InputEventTime, InputEventDate, InputEventLimit,InputEventPrice;
    private static final int GalleryPick = 1;
    private Uri ImageUri;
    private String eventRandomKey, downloadImageUrl;
    private StorageReference EventImageRef;
    private DatabaseReference EventRef;
    private ProgressDialog loadingBar;
    private DAOEvents eventDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_event);

        // Initialize Room Database
        AppDataBase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "app-database").build();
        eventDao = appDatabase.eventDao();

        AddNewEventButton = findViewById(R.id.add_new_event);
        InputEventImage = findViewById(R.id.select_event_image);
        InputEventName = findViewById(R.id.txtNameOfEvent);
        InputEventPlace = findViewById(R.id.txtPlace);
        InputEventTime = findViewById(R.id.txtTime);
        InputEventDate = findViewById(R.id.txtDate);
        InputEventLimit = findViewById(R.id.txtAmountPpl);
        InputEventPrice = findViewById(R.id.price);

        InputEventImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fonction pour ouvrir la galerie
                OpenGallery();
            }
        });

        AddNewEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fonction pour valider les données de l'événement
                ValidateEventData();
            }
        });
    }



    private void OpenGallery()
    {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, GalleryPick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==GalleryPick && resultCode==RESULT_OK && data!=null)
        {
            ImageUri = data.getData();
            InputEventImage.setImageURI(ImageUri);
        }
    }

    private void ValidateEventData()
    {
        Name = InputEventName.getText().toString();
        Place = InputEventPlace.getText().toString();
        Time = InputEventTime.getText().toString();
        Date = InputEventDate.getText().toString();
        Limit = InputEventLimit.getText().toString();
        Price = InputEventPrice.getText().toString();

        if (ImageUri == null)
        {
            Toast.makeText(this, "Une photo de l'événement est requise", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Name))
        {
            Toast.makeText(this, "Veuillez entrer le nom de l'événement", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(Place))
        {
            Toast.makeText(this, "Veuillez entrer le lieu de l'événement", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(Time))
        {
            Toast.makeText(this, "Veuillez entrer l'heure ", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(Date))
        {
            Toast.makeText(this, "Veuillez entrer la date de l'événement", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(Limit))
        {
            Toast.makeText(this, "Veuillez entrer votre limite de places", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(Price))
        {
            Toast.makeText(this, "Veuillez saisir le prix d'entrée. Pour les événements gratuits, entrez 0", Toast.LENGTH_SHORT).show();

        }
        else
        {
            StoreEventInformation();
        }
    }

    private void StoreEventInformation()
    {
        loadingBar.setTitle("Ajouter un nouvel événement");
        loadingBar.setMessage("Veuillez patienter, nous ajoutons un nouvel événement");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        eventRandomKey = saveCurrentDate + saveCurrentTime;

        final StorageReference filePath = EventImageRef.child(ImageUri.getLastPathSegment() + eventRandomKey + ".jpg");
        final UploadTask uploadTask = filePath.putFile(ImageUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                String message = e.toString();
                Toast.makeText(AdminAddNewEventActivity.this, "Erreur: " + message, Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
            {
                Toast.makeText(AdminAddNewEventActivity.this, "Photo de l'événement téléchargée correctement " , Toast.LENGTH_SHORT).show();
                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception
                    {
                        if (!task.isSuccessful())
                        {
                            throw task.getException();

                        }

                        downloadImageUrl = filePath.getDownloadUrl().toString();
                        return filePath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task)
                    {
                        if(task.isSuccessful())
                        {
                            downloadImageUrl = task.getResult().toString();
                            Toast.makeText(AdminAddNewEventActivity.this, "Photo de l'événement enregistrée correctement",Toast.LENGTH_SHORT).show();
                            SaveProductInfoToDatabase();
                        }
                    }
                });
            }
        });

    }

    private void SaveProductInfoToDatabase()
    {
        HashMap<String, Object> eventMap = new HashMap<>();
        eventMap.put("pid", eventRandomKey);
        eventMap.put("category", CategoryName);
        eventMap.put("date", saveCurrentDate);
        eventMap.put("time", saveCurrentDate);
        eventMap.put("name", Name);
        eventMap.put("image", downloadImageUrl);
        eventMap.put("place", Place);
        eventMap.put("eTime", Time);
        eventMap.put("eDate", Date);
        eventMap.put("limit", Limit);
        eventMap.put("price", Price);

        EventRef.child(eventRandomKey).updateChildren(eventMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if(task.isSuccessful())
                        {
                            Intent intent = new Intent(AdminAddNewEventActivity.this, AdminCategoryActivity.class);
                            startActivity(intent);
                            loadingBar.dismiss();
                            Toast.makeText(AdminAddNewEventActivity.this,"Événement ajouté avec succès",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            loadingBar.dismiss();
                            String message = task.getException().toString();
                            Toast.makeText(AdminAddNewEventActivity.this,"Erreur: " + message,Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
