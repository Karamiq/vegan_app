package com.example.vegandetective.model;

public class Product {
    private String item, description;
    private int calories;
    private int picture;
    private boolean isVegan, isVegetarian, isCarnivore;


    public Product(String item, String description, int calories, int picture, boolean isVegan, boolean isVegetarian, boolean isCarnivore) {
        this.description = description;
        this.item = item;
        this.isVegan = isVegan;
        this.calories = calories;
        this.picture = picture;
        this.isVegetarian = isVegetarian;
        this.isCarnivore = isCarnivore;


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

    public String getItem() {
        return this.item;
    }

    public int getPicture() {
        return this.picture;
    }

    public int getCalories() {
        return this.calories;
    }
}

