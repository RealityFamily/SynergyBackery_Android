package ru.realityfamily.synergybakery.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.realityfamily.synergybakery.Components.MyImageView;
import ru.realityfamily.synergybakery.Models.Sale;
import ru.realityfamily.synergybakery.R;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.SaleViewHolder> {
    List<Sale> elements;

    public SalesAdapter(List<Sale> elements) {
        this.elements = elements;
    }

    @NonNull
    @Override
    public SaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SaleViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sale_element, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SaleViewHolder holder, int position) {
        holder.name.setText(elements.get(position).getName());
        if (elements.get(position).isCondition()) {
            holder.condition.setVisibility(View.VISIBLE);
            ((RelativeLayout.LayoutParams) holder.name.getLayoutParams())
                    .addRule(RelativeLayout.ABOVE, holder.condition.getId());
        } else {
            holder.condition.setVisibility(View.GONE);
            ((RelativeLayout.LayoutParams) holder.name.getLayoutParams())
                    .addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        }
        holder.image.setImageResource(elements.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public static class SaleViewHolder extends RecyclerView.ViewHolder {
        MyImageView image;
        TextView name;
        TextView condition;

        public SaleViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (MyImageView) itemView.findViewById(R.id.sale_Image);
            name = (TextView) itemView.findViewById(R.id.sale_Name);
            condition = (TextView) itemView.findViewById(R.id.sale_Condition);
        }
    }
}
