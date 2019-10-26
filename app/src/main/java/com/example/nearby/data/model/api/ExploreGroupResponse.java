package com.example.nearby.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ExploreGroupResponse {
    @SerializedName("name")
    private String name;

    @SerializedName("items")
    private ArrayList<ExploreVenue> items;

    public ExploreGroupResponse(String name, ArrayList<ExploreVenue> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ExploreVenue> getItems() {
        return items;
    }

    public void setItems(ArrayList<ExploreVenue> items) {
        this.items = items;
    }
}
