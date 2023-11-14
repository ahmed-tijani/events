package com.example.formulaire.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart")
public class Cart {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "eid")
    private String eid;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "ename")
    private String ename;

    @ColumnInfo(name = "price")
    private String price;

    @ColumnInfo(name = "quantity")
    private String quantity;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "eDate")
    private String eDate;

    @ColumnInfo(name = "place")
    private String place;

    @ColumnInfo(name = "limit")
    private String limit;

    public Cart() {
    }

    @Ignore
    public Cart(String eid, String ename, String price, String quantity, String category, String eDate, String place, String limit,String date, String time) {
        this.eid = eid;
        this.ename = ename;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.eDate = eDate;
        this.place = place;
        this.limit = limit;
        this.date =date;
        this.time = time;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEDate() {
        return eDate;
    }

    public void setEDate(String eDate) {
        this.eDate = eDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }


    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

}
