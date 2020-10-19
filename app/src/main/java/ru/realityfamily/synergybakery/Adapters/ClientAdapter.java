package ru.realityfamily.synergybakery.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.realityfamily.synergybakery.R;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {
    String[] settings = new String[] {"История заказов", "Любимые заказы",
            "Изменить личную информацию", "Привязать карту"};

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClientViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.client_setting_element, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        holder.settings.setText(settings[position]);
    }

    @Override
    public int getItemCount() {
        return settings.length;
    }

    public static class ClientViewHolder extends RecyclerView.ViewHolder {
        TextView settings;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);

            settings = itemView.findViewById(R.id.setting);
        }
    }
}
