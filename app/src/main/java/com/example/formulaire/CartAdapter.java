package com.example.formulaire;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formulaire.Model.Cart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<Cart> cartList;

    public CartAdapter(List<Cart> cartList) {
        this.cartList = cartList;
    }


    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cartItem = cartList.get(position);

        // Set your data to the views in the ViewHolder
        holder.txtEventQuantity.setText("Ilosc = " + cartItem.getQuantity());
        holder.txtEventPrice.setText("Cena = " + cartItem.getPrice() + "PLN");
        holder.txtEventName.setText(cartItem.getEname());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView txtEventQuantity, txtEventPrice, txtEventName;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize your views here
            txtEventQuantity = itemView.findViewById(R.id.cart_event_quantity);
            txtEventPrice = itemView.findViewById(R.id.cart_event_price);
            txtEventName = itemView.findViewById(R.id.cart_event_name);
        }
    }
}
