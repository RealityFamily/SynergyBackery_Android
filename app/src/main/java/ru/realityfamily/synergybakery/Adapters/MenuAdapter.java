package ru.realityfamily.synergybakery.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.realityfamily.synergybakery.Models.Product;
import ru.realityfamily.synergybakery.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Map<String, List<Product>> menu;
    private Context context;

    public MenuAdapter(Context context, Map<String, List<Product>> menu) {
        this.context = context;
        this.menu = menu;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_elemet, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.categoryTitle.setText(new ArrayList<>(menu.keySet()).get(position));
        holder.products.setAdapter(new ProductAdapter(new ArrayList<>(menu.values()).get(position), context));
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTitle;
        GridView products;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitle = (TextView) itemView.findViewById(R.id.categoryTitle);
            products = (GridView) itemView.findViewById(R.id.gridContainer);
        }
    }
}
