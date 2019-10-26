package com.example.nearby.view_model;

import androidx.lifecycle.ViewModel;

import com.example.nearby.data.model.api.ExploreVenue;
import com.example.nearby.repository.VenueRepository;

import java.util.ArrayList;

public class VenueListViewModel extends ViewModel {
    private VenueRepository venueRepository;
    private ArrayList<ExploreVenue> venues;

    public VenueListViewModel() {
        venueRepository = new VenueRepository();
        this.venues = venueRepository.getNearbyVenues("30.02112,31.22338");
    }

    public ArrayList<ExploreVenue> getVenues() {
        return venues;
    }
}
