package ru.realityfamily.synergybakery.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.realityfamily.synergybakery.Adapters.MenuAdapter;
import ru.realityfamily.synergybakery.Models.Product;
import ru.realityfamily.synergybakery.R;

public class MenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_fragment, container, false);

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.menu_RecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setAdapter(new MenuAdapter(this.getContext(), Product.GetMenu()));

        return v;
    }
}
