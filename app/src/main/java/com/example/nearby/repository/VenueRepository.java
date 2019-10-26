package com.example.nearby.repository;

import android.util.Log;

import com.example.nearby.BuildConfig;
import com.example.nearby.data.model.api.ExploreVenue;
import com.example.nearby.data.model.api.ExploreData;
import com.example.nearby.data.remote.ApiEndPoint;
import com.example.nearby.network.RetrofitClientInstance;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.nearby.data.remote.ApiConstants.RADIUS;
import static com.example.nearby.data.remote.ApiConstants.VERSION;

public class VenueRepository {
    private static final String TAG = VenueRepository.class.getSimpleName();
    private ApiEndPoint apiEndPoint;

    public VenueRepository() {
        apiEndPoint = RetrofitClientInstance.getRetrofitInstance().create(ApiEndPoint.class);
    }

//    public Observable<ExploreVenue> getNearbyVenues (String latLng
//                                        ,Integer offset
//    ) {
//        final ArrayList<ExploreVenue> data = new ArrayList<>();
//        return apiEndPoint.getNearbyVenues(latLng, RADIUS,
////                offset, PAGINATION_LIMIT,
//                BuildConfig.CLIENT_ID,
//                BuildConfig.CLIENT_SECRET, VERSION)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());

//                .flatMap(Observable::from)
//                .map(ExploreData::new);
//                .enqueue(new Callback<ExploreData>() {
//                    @Override
//                    public void onResponse(Call<ExploreData> call, Response<ExploreData> response) {
//                        Log.d(TAG, "onResponse response:: " + response);
//
//                        if (response.body() != null) {
//                            data.addAll(response.body().getResponse().getGroups().get(0).getItems());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ExploreData> call, Throwable t) {
//                        try {
//                            throw t;
//                        } catch (Throwable throwable) {
//                            throwable.printStackTrace();
//                        }
//                    }
//                });
//        return data;
//    }
}
