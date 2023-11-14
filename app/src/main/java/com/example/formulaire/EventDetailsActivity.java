package com.example.formulaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.formulaire.AppDataBase.AppDataBase;
import com.example.formulaire.Interfaces.DAOEvents;
import com.example.formulaire.Interfaces.DAOUser;
import com.example.formulaire.Model.Cart;
import com.example.formulaire.Model.Events;
import com.example.formulaire.Prevalent.Prevalent;


import com.squareup.picasso.Picasso;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class EventDetailsActivity extends AppCompatActivity {

    private Button addToCartButton;
    private ImageView eventImage;
    private TextView eventCategory, eventDate, eventLimit, eventName, eventPlace, eventPrice;
    private String eventID = "";
    private DAOEvents eventDao;

    private ElegantNumberButton numberButton;

    private LiveData<Events> eventLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        eventID = getIntent().getStringExtra("pid");
        AppDataBase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "app-database").build();
        eventDao = appDatabase.eventDao();

        eventLiveData = eventDao.getEventById(eventID);

        addToCartButton = findViewById(R.id.event_add_to_cart_button);
        eventImage = findViewById(R.id.event_image_details);
        numberButton = findViewById(R.id.number_btn);
        eventName = findViewById(R.id.event_name_details);
        eventCategory = findViewById(R.id.event_category_details);
        eventLimit = findViewById(R.id.event_limit_details);
        eventPlace = findViewById(R.id.event_place_details);
        eventPrice = findViewById(R.id.event_price_details);
        eventDate = findViewById(R.id.event_date_details);

        eventLiveData.observe(this, new Observer<Events>() {
            @Override
            public void onChanged(Events event) {
                if (event != null) {
                    setEventDetails(event);
                }
            }
        });

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCartList();
            }
        });
    }

    private void addToCartList() {
        // Get the selected event from the Room Database
        Events selectedEvent = eventLiveData.getValue();

        if (selectedEvent != null) {
            // Create a Cart object to represent the item in the cart
            Cart cartItem = new Cart();
            cartItem.setEid(selectedEvent.getPid());
            cartItem.setEname(selectedEvent.getName());
            cartItem.setPrice(selectedEvent.getPrice());
            cartItem.setDate(getCurrentDate());
            cartItem.setTime(getCurrentTime());
            cartItem.setCategory(selectedEvent.getCategory());
            cartItem.setEDate(selectedEvent.getEDate());
            cartItem.setQuantity(numberButton.getNumber());
            cartItem.setPlace(selectedEvent.getPlace());
            cartItem.setLimit(selectedEvent.getLimit());

            // Insert the cart item into the Room Database
            AppDataBase.getDatabase(getApplicationContext()).cartDao().insert(cartItem);

            Toast.makeText(this, "Dodano do karty", Toast.LENGTH_SHORT).show();

            // Navigate back to the HomeActivity or wherever you want to go
            Intent intent = new Intent(EventDetailsActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    // Helper method to get the current date
    private String getCurrentDate() {
        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        return currentDate.format(calForDate.getTime());
    }

    // Helper method to get the current time
    private String getCurrentTime() {
        Calendar calForTime = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        return currentTime.format(calForTime.getTime());
    }

    private void getEventDetails(String eventID) {
        DAOEvents eventDao = AppDataBase.getDatabase(getApplicationContext()).eventDao();

        LiveData<Events> eventLiveData = eventDao.getEventById(eventID);

        eventLiveData.observe(this, new Observer<Events>() {
            @Override
            public void onChanged(Events event) {
                if (event != null) {
                    setEventDetails(event);
                }
            }
        });
    }

    private void setEventDetails(Events event) {
        eventName.setText("Nazwa wydarzenia: " + event.getName());
        eventCategory.setText("Kategoria: " + event.getCategory());
        eventLimit.setText("Limit miejsc: " + event.getLimit());
        eventPlace.setText("Miejsce: " + event.getPlace());
        eventPrice.setText("Cena biletu: " + event.getPrice() + " zł");
        eventDate.setText("Data: " + event.getDate());
        Picasso.get().load(event.getImage()).placeholder(R.drawable.logo).into(eventImage);
    }

}
