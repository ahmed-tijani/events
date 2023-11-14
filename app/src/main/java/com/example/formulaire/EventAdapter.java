package com.example.formulaire;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formulaire.Model.Events;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Events> eventsList;

    public EventAdapter(List<Events> eventsList, HomeActivity homeActivity) {
        this.eventsList = eventsList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_items_layout, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Events event = eventsList.get(position);

        // Set your data to the views in the ViewHolder
        holder.txtEventName.setText(event.getName());
        holder.txtEventDetails.setText("Data: " + event.getEDate());
        holder.txtEventDate.setText("Cena: " + event.getPrice() + " zł");
        Picasso.get().load(event.getImage()).placeholder(R.drawable.logo).into(holder.imageView);

        // Add any other necessary setup for the views
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        // Declare your views here (e.g., TextView, ImageView)
        TextView txtEventName, txtEventDetails, txtEventDate;
        ImageView imageView;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize your views here
            txtEventName = itemView.findViewById(R.id.event_name_details);
            txtEventDetails = itemView.findViewById(R.id.event_category_details);
            txtEventDate = itemView.findViewById(R.id.event_date_details);
            imageView = itemView.findViewById(R.id.event_image_details);
        }
    }
}
