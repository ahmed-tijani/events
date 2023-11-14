package com.example.formulaire.Interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.formulaire.Model.Cart;

import java.util.List;

@Dao
public interface DAOCart {
    @Insert
    void insert(Cart cart);

    @Update
    void update(Cart cart);

    @Delete
    void delete(Cart cart);

    @Query("SELECT * FROM cart WHERE eid = :eid")
    Cart getCartByEid(String eid);

    @Query("SELECT * FROM cart")
    List<Cart> getAllCarts();

}

