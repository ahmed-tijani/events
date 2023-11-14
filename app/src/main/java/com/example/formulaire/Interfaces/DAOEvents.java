package com.example.formulaire.Interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.formulaire.Model.Events;

import java.util.List;

@Dao
public interface DAOEvents {
    @Insert
    void insert(Events events);

    @Update
    void update(Events events);

    @Delete
    void delete(Events events);

    @Query("SELECT * FROM events WHERE pid = :pid")
    Events getEventsByPid(String pid);

    @Query("SELECT * FROM events")
    List<Events> getAllEvents();
    @Query("SELECT * FROM events WHERE pid = :eventId")
    LiveData<Events> getEventById(String eventId);
}

