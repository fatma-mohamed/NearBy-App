package com.example.nearby.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PhotoResponse {

    @SerializedName("photos")
    private Photos photos;

    public PhotoResponse(Photos photos) {
        this.photos = photos;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}
