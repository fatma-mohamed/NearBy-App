package com.example.nearby.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.nearby.R;
import com.example.nearby.adapter.VenueAdapter;
import com.example.nearby.data.model.api.ExploreData;
import com.example.nearby.data.model.api.ExploreVenue;
import com.example.nearby.view_model.LocationViewModel;
import com.example.nearby.view_model.VenueListViewModel;

import java.util.ArrayList;


public class VenueList extends Fragment {

    private static final String TAG = VenueList.class.getSimpleName();
    private VenueListViewModel mViewModel;
    private LocationViewModel locationViewModel;
    private RecyclerView recycler_view;
    private LinearLayout error_view;
    private LinearLayout no_data_view;
    private LinearLayout progress_view;
    private LinearLayoutManager layoutManager;
    private VenueAdapter adapter;
    private Location lastLocation;

    public static VenueList newInstance() {
        return new VenueList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.venue_list_fragment, container, false);
        recycler_view = view.findViewById(R.id.recycler_view);
        error_view = view.findViewById(R.id.layout_error);
        no_data_view = view.findViewById(R.id.layout_no_data);
        progress_view = view.findViewById(R.id.layout_progress);

        layoutManager = new LinearLayoutManager(getContext());
        recycler_view.setLayoutManager(layoutManager);

        recycler_view.setHasFixedSize(true);

        adapter = new VenueAdapter(getContext());
        recycler_view.setAdapter(adapter);

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(VenueListViewModel.class);
        locationViewModel = new LocationViewModel(getActivity());

        startLocationUpdate();
    }

    private void startLocationUpdate() {
        locationViewModel.getLocationData().observe(getActivity(), new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                if(lastLocation != null && location != null) {
                    if(lastLocation.distanceTo(location) >= 500) {
                        mViewModel.setLatLng(location.getLatitude()+","+location.getLongitude());
                        getVenues();
                        lastLocation = location;
                    }
                } else {
                    if(location != null) {
                        mViewModel.setLatLng(location.getLatitude()+","+location.getLongitude());
                        lastLocation = location;
                        getVenues();
                    }
                }
            }
        });
    }

    private void stopLocationUpdate() {
        locationViewModel.getLocationData().removeObservers(getActivity());
    }

    private void getVenues() {
        mViewModel.getData().observe(getActivity(), new Observer<ArrayList<ExploreVenue>>() {
            @Override
            public void onChanged(ArrayList<ExploreVenue> venues) {
                if (venues == null || venues.size() == 0) {
                    recycler_view.setVisibility(View.GONE);
                    progress_view.setVisibility(View.GONE);
                    error_view.setVisibility(View.GONE);
                    no_data_view.setVisibility(View.VISIBLE);

                } else {
                    recycler_view.setVisibility(View.VISIBLE);
                    progress_view.setVisibility(View.GONE);
                    error_view.setVisibility(View.GONE);
                    no_data_view.setVisibility(View.GONE);
                    adapter.addItems(venues);
                }
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_change_mode:
                if (item.getTitle().toString().equals(getString(R.string.real_time))) {
                    item.setTitle(R.string.single_update);
                    stopLocationUpdate();
                } else {
                    item.setTitle(R.string.real_time);
                    startLocationUpdate();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
