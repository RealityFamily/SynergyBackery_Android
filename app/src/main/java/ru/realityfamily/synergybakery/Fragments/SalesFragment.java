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

import ru.realityfamily.synergybakery.Adapters.SalesAdapter;
import ru.realityfamily.synergybakery.Models.Sale;
import ru.realityfamily.synergybakery.R;

public class SalesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sales_fragment, container, false);

        RecyclerView rv = v.findViewById(R.id.sale_RecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setAdapter(new SalesAdapter(Sale.GetSales()));

        return v;
    }
}
