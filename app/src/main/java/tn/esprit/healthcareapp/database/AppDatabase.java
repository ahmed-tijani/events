package tn.esprit.healthcareapp.database;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;


import tn.esprit.healthcareapp.dao.ArticleDao;
import tn.esprit.healthcareapp.entities.Article;


@androidx.room.Database(entities = {Article.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase databaseInstance;

    public abstract ArticleDao articleDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (databaseInstance == null) {
            databaseInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "healthcaredb")
                    .allowMainThreadQueries()
                    .build();
        }
        return databaseInstance;
    }
}

