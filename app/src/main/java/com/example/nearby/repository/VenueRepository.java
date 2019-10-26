package com.example.nearby.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.nearby.BuildConfig;
import com.example.nearby.data.model.api.ExploreData;
import com.example.nearby.data.model.api.ExploreVenue;
import com.example.nearby.data.remote.ApiEndPoint;
import com.example.nearby.network.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.nearby.data.remote.ApiConstants.RADIUS;
import static com.example.nearby.data.remote.ApiConstants.VERSION;

public class VenueRepository {
    private static final String TAG = VenueRepository.class.getSimpleName();
    private ApiEndPoint apiEndPoint;

    public VenueRepository() {
        apiEndPoint = RetrofitClientInstance.getRetrofitInstance().create(ApiEndPoint.class);
    }

    public MutableLiveData<ArrayList<ExploreVenue>> getNearbyVenues (
            String latLng) {
        final MutableLiveData<ArrayList<ExploreVenue>> data = new MutableLiveData<>();
        apiEndPoint.getNearbyVenues(latLng,
                RADIUS,
                BuildConfig.CLIENT_ID,
                BuildConfig.CLIENT_SECRET,
                VERSION)
                .enqueue(new Callback<ExploreData>() {
                    @Override
                    public void onResponse(Call<ExploreData> call, Response<ExploreData> response) {
                        if (response.body() != null) {
                            data.setValue(response.body().getResponse().getGroups().get(0).getItems());
                        }
                    }

                    @Override
                    public void onFailure(Call<ExploreData> call, Throwable t) {
                        data.setValue(null);
                        try {
                            throw t;
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                });
        return data;
    }
}
