package ru.realityfamily.synergybakery.Models;

import java.util.ArrayList;
import java.util.List;

import ru.realityfamily.synergybakery.R;

public class Sale {
    private String name;
    private boolean condition;
    private int image;

    public Sale(String name, boolean condition, int image) {
        this.name = name;
        this.condition = condition;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static List<Sale> GetSales() {
        List<Sale> sales = new ArrayList<>();

        sales.add(new Sale("Возьми капучино и получи второй со скидкой 50%",
                true, R.drawable.double_coffee));
        sales.add(new Sale("Возьми сытный пирожок и получи сладкую выпечку в подарок",
                false, R.drawable.double_pirozhok));
        sales.add(new Sale("Возьми американо и получи сладкую выпечку в подарок",
                true, R.drawable.coffee_plus_pirozhok));

        return sales;
    }
}
