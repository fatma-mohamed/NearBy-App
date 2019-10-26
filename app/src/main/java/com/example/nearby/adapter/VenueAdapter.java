package com.example.nearby.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nearby.R;
import com.example.nearby.data.model.api.ExploreVenue;
import com.example.nearby.repository.VenueRepository;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.ViewHolder> {

    private Context context;
    ArrayList<ExploreVenue> venueArrayList;
    private VenueRepository venueRepository;

    public VenueAdapter(Context context) {
        this.context = context;
        venueRepository = new VenueRepository();
        this.venueArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public VenueAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.venue_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VenueAdapter.ViewHolder viewHolder, int i) {
        ExploreVenue exploreVenue=venueArrayList.get(i);
        viewHolder.name.setText(exploreVenue.getVenue().getName());
        viewHolder.address.setText(exploreVenue.getVenue().getLocation().getAddress());
        Picasso.get()
                .load(exploreVenue.getVenue().getPhotoUrl())
                .resize(80, 80)
                .placeholder(R.mipmap.ic_placeholder)
                .centerCrop()
                .into(viewHolder.photo);
    }

    @Override
    public int getItemCount() {
        return venueArrayList.size();
    }

    public void addItems(ArrayList<ExploreVenue> venues) {
        venueArrayList.addAll(venues);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView photo;
        private final TextView name;
        private final TextView address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            photo=(ImageView) itemView.findViewById(R.id.photo);
            name=(TextView) itemView.findViewById(R.id.name);
            address=(TextView) itemView.findViewById(R.id.address);
        }
    }
}
