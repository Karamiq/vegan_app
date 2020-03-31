package com.example.vegandetective.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Diet implements Serializable {
    private String dietName;
    //private ArrayList<Item> products;
    private ArrayList<Meal> meals;


    public Diet(String dietName) {
        this.dietName = dietName;
        this.meals = new ArrayList<Meal>();

    }


    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }

    public String getDietName() {
        return dietName;
    }

    public void removeMealByName(String mealName) {
        ArrayList<Meal> mealTemp = new ArrayList<Meal>();

        for (Meal meal : this.meals) {
            if (!meal.getMealName().equals(mealName)) {
                mealTemp.add(meal);
            }
        }
        this.meals = mealTemp;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public Meal getMealByName(String mealName) {
        Meal mealtemp;
        for (Meal meal : this.meals) {
            if (meal.getMealName().equals(mealName)) {
                return meal;
            }
        }
        return null;
    }

}

