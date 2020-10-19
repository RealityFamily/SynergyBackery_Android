package ru.realityfamily.synergybakery.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.realityfamily.synergybakery.Components.MyImageView;
import ru.realityfamily.synergybakery.Models.Product;
import ru.realityfamily.synergybakery.R;

public class ProductAdapter extends BaseAdapter {
    private List<Product> elements;
    private Context context;

    public ProductAdapter(List<Product> elements, Context context) {
        this.elements = elements;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elements.size();
    }

    @Override
    public Object getItem(int i) {
        return elements.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.product_card, null);

        ((TextView) v.findViewById(R.id.product_name)).setText(elements.get(i).getName());
        ((TextView) v.findViewById(R.id.product_price)).setText(((Float) elements.get(i).getPrice()).toString() + " руб.");
        ((TextView) v.findViewById(R.id.product_size)).setText(elements.get(i).getSize());
        ((MyImageView) v.findViewById(R.id.product_image)).setImageResource(elements.get(i).getImage());

        return v;
    }
}
