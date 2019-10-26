package com.example.nearby.data.model;

public class Location {
    public String address;
    public String crossStreet;

    public Location(String address, String crossStreet) {
        this.address = address;
        this.crossStreet = crossStreet;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public String getAddress() {
        return address;
    }

    public String getCrossStreet() {
        return crossStreet;
    }
}
