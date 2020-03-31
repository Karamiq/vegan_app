package com.example.vegandetective.model;

import java.io.Serializable;

public class Item implements Serializable {
    private String itemName, description;
    private int calories;
    private int picture;
    private boolean isVegan, isVegetarian, isCarnivore, isSelected;


    public Item(String itemName, String description, int calories, int picture, boolean isVegan, boolean isVegetarian, boolean isCarnivore) {
        this.description = description;
        this.itemName = itemName;
        this.isVegan = isVegan;
        this.calories = calories;
        this.picture = picture;
        this.isVegetarian = isVegetarian;
        this.isCarnivore = isCarnivore;
        this.isSelected = false;


    }

    public String getDescription() {
        return description;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public boolean isVegetarian() {
        if (this.isVegan) {
            return true;
        } else {
            return this.isVegetarian;
        }
    }

    public boolean isCarnivore() {
        return isCarnivore;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getPicture() {
        return this.picture;
    }

    public int getCalories() {
        return this.calories;
    }

    public void isSelectedChange() {
        if (this.isSelected) {
            this.isSelected = false;
        } else {
            this.isSelected = true;
        }
    }

    public boolean isSelected() {
        return this.isSelected;
    }
}

