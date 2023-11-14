package com.example.formulaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.formulaire.AppDataBase.AppDataBase;
import com.example.formulaire.Interfaces.DAOCart;
import com.example.formulaire.Model.Cart;
import com.example.formulaire.Prevalent.Prevalent;
import com.example.formulaire.ViewHolder.CartViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private void loadCartFromRoomDatabase() {
        // Utiliser AsyncTask pour charger les données depuis la base de données de manière asynchrone
        new LoadCartAsyncTask().execute();
    }
    private class LoadCartAsyncTask extends AsyncTask<Void, Void, List<Cart>> {

        @Override
        protected List<Cart> doInBackground(Void... voids) {
            // Charger les données depuis la base de données dans le thread arrière-plan
            return cartDao.getAllCarts();
        }

        @Override
        protected void onPostExecute(List<Cart> cartList) {
            super.onPostExecute(cartList);

            // Mettre à jour l'UI avec les données chargées depuis la base de données
            updateUI(cartList);
        }
    }

    private void updateUI(List<Cart> cartList) {
        // Mettre à jour l'UI avec les données de la liste du panier
        CartAdapter adapter = new CartAdapter(cartList);
        recyclerView.setAdapter(adapter);
    }

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button NextProcessBtn;
    private TextView txtTotalAmount;

    private DAOCart cartDao;
    private List<Cart> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cart_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        NextProcessBtn = findViewById(R.id.next_process_btn);
        txtTotalAmount = findViewById(R.id.total_price);

        // Initialize Room Database
        AppDataBase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "app-database").build();
        cartDao = appDatabase.cartDao();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Load data from Room Database
        loadCartFromRoomDatabase();
    }


}
