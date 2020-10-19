package ru.realityfamily.synergybakery.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.realityfamily.synergybakery.Adapters.ClientAdapter;
import ru.realityfamily.synergybakery.R;

public class ClientFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.client_fragment, container, false);

        RecyclerView rv = v.findViewById(R.id.clientRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setAdapter(new ClientAdapter());
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));

        return v;
    }
}
