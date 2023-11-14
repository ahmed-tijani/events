package com.example.formulaire.AppDataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.formulaire.Interfaces.DAOCart;
import com.example.formulaire.Interfaces.DAOEvents;
import com.example.formulaire.Interfaces.DAOUser;
import com.example.formulaire.Model.Cart;
import com.example.formulaire.Model.Events;
import com.example.formulaire.Model.Users;

@Database(entities = {Events.class, Users.class, Cart.class}, version = 6, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DAOUser userDao();
    public abstract DAOEvents eventDao();
    public abstract DAOCart cartDao();

    private static volatile AppDataBase INSTANCE;

    public static synchronized AppDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }
}
