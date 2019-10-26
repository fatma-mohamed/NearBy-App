package com.example.nearby.view_model;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nearby.data.model.api.ExploreData;
import com.example.nearby.data.model.api.ExploreVenue;
import com.example.nearby.repository.VenueRepository;

import java.util.ArrayList;


public class VenueListViewModel extends ViewModel {
    private static String TAG = VenueListViewModel.class.getSimpleName();
    private VenueRepository venueRepository;
    private LiveData<ArrayList<ExploreVenue>> data = new MutableLiveData<>();
    private String latLng;


    public VenueListViewModel() {
        venueRepository = new VenueRepository();
    }

    public LiveData<ArrayList<ExploreVenue>> getData() {
        this.data = venueRepository.getNearbyVenues(latLng);
        return data;
    }

    public String getLatLng() {
        return latLng;
    }

    public void setLatLng(String latLng) {
        this.latLng = latLng;
    }
}
