package com.example.nearby.data.model;

import java.util.ArrayList;

public class Venue {
    public String id;
    public String name;
    public String photoUrl;
    public Location location;

    public Venue(String id, String name, String photoUrl, Location location) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
