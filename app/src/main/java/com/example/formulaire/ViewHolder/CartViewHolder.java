package com.example.formulaire.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.example.formulaire.Interfaces.ItemClickListner;
import com.example.formulaire.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtEventName, txtEventPrice, txtEventQuantity;
    private ItemClickListner itemClickListner;

    public CartViewHolder( View itemView)
    {
        super(itemView);

        txtEventName = itemView.findViewById(R.id.cart_event_name);
        txtEventPrice = itemView.findViewById(R.id.cart_event_price);
        txtEventQuantity = itemView.findViewById(R.id.cart_event_quantity);
    }

    @Override
    public void onClick(View v)
    {
        itemClickListner.onClick(v, getAdapterPosition(),false );
    }

    public void setItemClickListner(ItemClickListner itemClickListner)
    {
        this.itemClickListner = itemClickListner;
    }
}
