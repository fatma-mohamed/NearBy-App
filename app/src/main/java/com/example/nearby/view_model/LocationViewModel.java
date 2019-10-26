package com.example.nearby.view_model;

import android.app.Activity;
import android.location.Location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.nearby.data.LocationLiveData;

public class LocationViewModel extends ViewModel {

    private LocationLiveData locationData;

    public LocationViewModel(Activity activity) {
        locationData = new LocationLiveData(activity);
    }

    public LiveData<Location> getLocationData() {
        return locationData;
    }
}
