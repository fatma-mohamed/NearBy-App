package com.example.nearby.view;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.nearby.R;
import com.example.nearby.adapter.VenueAdapter;
import com.example.nearby.data.model.api.ExploreVenue;
import com.example.nearby.view_model.VenueListViewModel;

import java.util.ArrayList;

public class VenueList extends Fragment {

    private static final String TAG = VenueList.class.getSimpleName();
    private VenueListViewModel mViewModel;
    private RecyclerView recycler_view;
    private LinearLayout error_view;
    private LinearLayout no_data_view;
    private LinearLayout progress_view;
    private ProgressBar progress_bar;
    private LinearLayoutManager layoutManager;
    private VenueAdapter adapter;
    private ArrayList<ExploreVenue> venueArrayList = new ArrayList<>();

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
        progress_bar = view.findViewById(R.id.progress_bar);

        layoutManager = new LinearLayoutManager(getContext());
        recycler_view.setLayoutManager(layoutManager);

        recycler_view.setHasFixedSize(true);

        adapter = new VenueAdapter(getContext(), venueArrayList);
        recycler_view.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VenueListViewModel.class);
        getNearByPlaces();
    }

    private void getNearByPlaces() {
        try {
//            mViewModel.getVenues().observe(this, response -> {
//                if (response != null) {
//
//                    progress_bar.setVisibility(View.GONE);
//                    recycler_view.setVisibility(View.VISIBLE);
//                    ArrayList<ExploreVenue> articles = response;
//                    venueArrayList.addAll(articles);
//                    adapter.notifyDataSetChanged();
//                } else {
//
//                    progress_bar.setVisibility(View.GONE);
//                    no_data_view.setVisibility(View.VISIBLE);
//                }
//            });
            ArrayList<ExploreVenue> response = mViewModel.getVenues();
                if (response != null && response.size() > 0) {

                    progress_view.setVisibility(View.GONE);
                    recycler_view.setVisibility(View.VISIBLE);
                    venueArrayList.addAll(response);
                    adapter.notifyDataSetChanged();
                } else {
                    progress_view.setVisibility(View.GONE);
                    no_data_view.setVisibility(View.VISIBLE);
                }

        } catch (Exception e) {
            progress_view.setVisibility(View.GONE);
            error_view.setVisibility(View.VISIBLE);
        }
    }

}
