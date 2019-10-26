package com.example.nearby.data.model.api;

import com.example.nearby.data.model.Venue;
import com.google.gson.annotations.SerializedName;

public class ExploreVenue {
    @SerializedName("venue")
    public Venue venue;

    public ExploreVenue(Venue venue) {
        this.venue = venue;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
