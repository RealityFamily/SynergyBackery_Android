package ru.realityfamily.synergybakery.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.realityfamily.synergybakery.Adapters.CartAdapter;
import ru.realityfamily.synergybakery.Models.Product;
import ru.realityfamily.synergybakery.R;

public class CartFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cart_fragment, container, false);

        final List<Product> cart = Product.GetCart();
        final CartAdapter cartAdapter = new CartAdapter(cart);

        RecyclerView rv = v.findViewById(R.id.cart_RecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setAdapter(cartAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                cart.remove(viewHolder.getAdapterPosition());
                cartAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(rv);

        return v;
    }
}
