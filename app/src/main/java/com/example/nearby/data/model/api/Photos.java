package com.example.nearby.data.model.api;

import com.example.nearby.data.model.Photo;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Photos {
    @SerializedName("items")
    private ArrayList<Photo> items;

    public Photos(ArrayList<Photo> items) {
        this.items = items;
    }

    public ArrayList<Photo> getItems() {
        return items;
    }

    public void setItems(ArrayList<Photo> items) {
        this.items = items;
    }
}
