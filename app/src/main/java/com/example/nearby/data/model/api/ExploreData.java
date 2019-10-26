package com.example.nearby.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ExploreData {
    @SerializedName("response")
    private ExploreResponse response;

    public ExploreData(ExploreResponse response) {
        this.response = response;
    }

    public ExploreResponse getResponse() {
        return response;
    }

    public void setResponse(ExploreResponse response) {
        this.response = response;
    }
}
