package ru.realityfamily.synergybakery.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.realityfamily.synergybakery.R;

public class Product {
    private String name;
    private float price;
    private String size;
    private int image;


    public Product(String name, float price, String size, int image) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public static Map<String, List<Product>> GetMenu() {
        Map<String, List<Product>> menu = new HashMap<>();
        List<Product> products = new ArrayList<>();
        String categoryTitle = "";

        categoryTitle = "Сытная выпечка";
        products.add(new Product("Пирожок с мясом", 60, "35 грамм", R.drawable.pirozhok_s_myasom));
        products.add(new Product("Пирожок с капустой", 55, "40 грамм", R.drawable.pirozhok_s_kapustoj));
        menu.put(categoryTitle, products);

        products = new ArrayList<>();

        categoryTitle = "Сладкая выпечка";
        products.add(new Product("Пирожок с вишней", 45, "35 грамм", R.drawable.pirozhok_s_vishnej));
        products.add(new Product("Пирожок с яблоком", 40, "30 грамм", R.drawable.pirozhok_s_yablokom));
        products.add(new Product("Булочка с корицей", 55, "40 грамм", R.drawable.sinabon));
        menu.put(categoryTitle, products);

        products = new ArrayList<>();;

        categoryTitle = "Напитки";
        products.add(new Product("Капучино", 200, "250 мл", R.drawable.coffee));
        products.add(new Product("Американо", 180, "200 мл", R.drawable.coffee));
        menu.put(categoryTitle, products);

        products = new ArrayList<>();

        return menu;
    }

    public static List<Product> GetCart() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Капучино", 200, "250 мл", R.drawable.coffee));
        products.add(new Product("Булочка с корицей", 55, "40 грамм", R.drawable.sinabon));

        return products;
    }
}
