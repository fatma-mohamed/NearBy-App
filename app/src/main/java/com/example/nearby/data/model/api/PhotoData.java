package com.example.nearby.data.model.api;

import com.google.gson.annotations.SerializedName;

public class PhotoData {
    @SerializedName("response")
    private PhotoResponse response;

    public PhotoData(PhotoResponse response) {
        this.response = response;
    }

    public PhotoResponse getResponse() {
        return response;
    }

    public void setResponse(PhotoResponse response) {
        this.response = response;
    }
}
