package com.example.nearby.data.remote;

import com.example.nearby.data.model.api.ExploreData;
import com.example.nearby.data.model.api.PhotoData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoint {

    @GET("venues/explore")
    Call<ExploreData> getNearbyVenues(@Query("ll") String latLng,
                                      @Query("radius") Integer radius,
                                      @Query("client_id") String client_id,
                                      @Query("client_secret") String client_secret,
                                      @Query("v") String v);

    @GET("venues/{VENUE_ID}/photos")
    Call<PhotoData> getVenuePhoto(@Path("VENUE_ID") String venue_id,
                                  @Query("client_id") String client_id,
                                  @Query("client_secret") String client_secret,
                                  @Query("v") String v);

}
