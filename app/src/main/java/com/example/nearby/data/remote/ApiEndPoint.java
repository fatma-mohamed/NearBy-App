package com.example.nearby.data.remote;

import com.example.nearby.data.model.api.ExploreData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndPoint {

    @GET("venues/explore")
    Call<ExploreData> getNearbyVenues(@Query("ll") String latLng,
                                      @Query("radius") Integer radius,
                                      @Query("client_id") String client_id,
                                      @Query("client_secret") String client_secret,
                                      @Query("v") String v);

}
