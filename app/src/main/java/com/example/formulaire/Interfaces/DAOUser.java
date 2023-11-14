package com.example.formulaire.Interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.formulaire.Model.Users;

@Dao
public interface DAOUser {
    @Insert
    void insert(Users user);

    @Update
    void update(Users user);

    @Delete
    void delete(Users user);

    @Query("SELECT * FROM users WHERE phone = :phone")
    Users getUserByPhone(String phone);
}
