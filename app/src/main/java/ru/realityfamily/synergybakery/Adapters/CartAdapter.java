package ru.realityfamily.synergybakery.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.realityfamily.synergybakery.Components.MyImageView;
import ru.realityfamily.synergybakery.Models.Product;
import ru.realityfamily.synergybakery.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    List<Product> elements;

    public CartAdapter(List<Product> elements) {
        this.elements = elements;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_element, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.image.setImageResource(elements.get(position).getImage());
        holder.name.setText(elements.get(position).getName());
        holder.size.setText(elements.get(position).getSize());
        holder.price.setText(((Float) elements.get(position).getPrice()).toString() + " руб.");
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder{
        MyImageView image;
        TextView name;
        TextView size;
        TextView price;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (MyImageView) itemView.findViewById(R.id.cart_element_Image);
            name = itemView.findViewById(R.id.cart_element_name);
            size = itemView.findViewById(R.id.cart_element_size);
            price = itemView.findViewById(R.id.cart_element_price);
        }
    }
}
