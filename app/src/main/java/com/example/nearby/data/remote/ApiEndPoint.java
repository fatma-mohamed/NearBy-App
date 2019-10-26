package com.example.nearby.data.remote;

import com.example.nearby.data.model.api.ExploreData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface ApiEndPoint {

    @GET("venues/explore")
    Observable<ExploreData> getNearbyVenues(@Query("ll") String latLng,
                                            @Query("radius") Integer radius,
//                                          @Query("offset") Integer offset,
//                                          @Query("limit") Integer limit,
                                            @Query("client_id") String client_id,
                                            @Query("client_secret") String client_secret,
                                            @Query("v") String v);

}
