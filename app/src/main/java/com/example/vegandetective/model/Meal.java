package com.example.vegandetective.model;

import android.text.Editable;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Meal implements Serializable {


    private String mealName;
    private ArrayList<Item> items;
    private String description;
    private int image;
    private int durationInMinutes;
    private ArrayList<Integer> one;
    private ArrayList<Integer> two;
    private ArrayList<Integer> three;
    private ArrayList<Integer> four;
    private ArrayList<Integer> five;


    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


    public Meal(String mealName, String description, int image, int durationInMinutes) {
        this.mealName = mealName;
        this.items = new ArrayList<Item>();
        this.description = description;
        this.image = image;
        this.durationInMinutes = durationInMinutes;
    }

    public Meal(String mealName, String description, int durationInMinutes) {
        this.mealName = mealName;
        this.items = new ArrayList<Item>();
        this.description = description;
        this.durationInMinutes = durationInMinutes;
    }

    public void addNewItem(Item newItem) {
        ArrayList<Item> items_ = new ArrayList<>();
        if (this.items.contains(newItem)) {
            for (Item item : this.items) {
                if (!(item == newItem)) {
                    items_.add(item);
                }
            }
        }
        this.items = items_;
    }

    public void addItem(Item item){
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

    public String getDescription() {
        return this.description;
    }

    public int getImage() {
        return this.image;
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

    public int getDurationInMinutes() {
        return this.durationInMinutes;
    }


    public ArrayList<Item> getItems() {
        return this.items;
    }


    public void setImage(int image) {
        this.image = image;
    }
}
