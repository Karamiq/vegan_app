package com.example.vegandetective.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Meal implements Serializable {


    private String mealName;
    private ArrayList<Item> items;
    private String description;


    public Meal(String mealName,String description) {
        this.mealName = mealName;
        this.items = new ArrayList<Item>();
        this.description = description;

    }

    public void addProduct(Item item) {

        this.items.add(item);
    }

    public String getMealName() {
        return this.mealName;
    }


    public void removeProductByName(String itemName) {
        ArrayList<Item> productsTemp = new ArrayList<Item>();

        for (Item item : items) {
            if (!item.getItemName().equals(itemName)) {
                productsTemp.add(item);
            }
        }
        this.items = productsTemp;
    }


    public Item getProductByName(String itemName) {
        for (Item item : this.items) {
            if (item.getItemName().equals(itemName)) {
                return item;
            } else {
                return null;
            }
        }
        return null;
    }


    public ArrayList<Item> getItems() {
        return this.items;
    }
}
