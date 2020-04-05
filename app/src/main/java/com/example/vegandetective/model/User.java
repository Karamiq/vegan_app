package com.example.vegandetective.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class User implements Serializable {
    private String username;
    private ArrayList<Diet> diets;
    ArrayList<Item> tempItems;
    private Diet selectedDiet;


    public User(String username) {
        this.username = username;
        this.diets = new ArrayList<Diet>();
    }

    public void addDiet(Diet diet) {
        this.diets.add(diet);
    }

    public Diet getDietByName(String dietName) {
        for (Diet diet : this.diets) {
            if (diet.getDietName().equals(dietName)) {
                return diet;
            }
        }
        return null;
    }

    public void removeDietByName(String dietName) {
        ArrayList<Diet> dietsTemp = new ArrayList<Diet>();

        for (Diet diet : this.diets) {
            if (!diet.getDietName().equals(dietName)) {
                dietsTemp.add(diet);
            }
        }
        this.diets = dietsTemp;
    }


    public void changeUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Diet> getDiets() {
        return this.diets;
    }


    public void addTempItems(ArrayList<Item> items) {
        this.tempItems = items;
    }

    public ArrayList<Item> getTempItems() {
        return tempItems;
    }


    public Diet getSelectedDiet() {
        return this.selectedDiet;
    }

    public void setSelectedDiet(Diet diet) {
        this.selectedDiet = diet;
    }


    public ArrayList<Item> getAllItems() {
        ArrayList<Item> tempItems = new ArrayList<>();


        for (Meal meal : this.getAllMeals()) {
            tempItems.addAll(meal.getItems());
        }

        Set<Item> set = new HashSet<Item>(tempItems);
        tempItems.clear();
        tempItems.addAll(set);

        Collections.sort(tempItems);


        return tempItems;
    }

    public ArrayList<Meal> getAllMeals() {
        ArrayList<Meal> mealsTemp = new ArrayList<>();

        for (Diet diet : this.getDiets()) {
            if (diet == this.getSelectedDiet()) {
                return diet.getMeals();
            }
        }
        return mealsTemp;
    }

    public boolean checkIfNameExisted(Meal newMeal) {
        boolean status = false;

        for (Diet diet : this.diets) {
            if (diet == this.getSelectedDiet()) {
                for (Meal meal : diet.getMeals()) {
                    if (meal.getMealName().equals(newMeal.getMealName())) {
                        status = true;
                        break;
                    } else {
                        status = false;
                    }
                }
            }
        }
        return status;
    }

    public boolean checkIfNameExistedStr(String name) {
        for (Diet diet : this.diets) {
            if (diet == this.getSelectedDiet()) {
                for (Meal meal : diet.getMeals()) {
                    if (meal.getMealName().equals(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Meal> getMealsForSelectedDiet() {
        for (Diet diet : this.diets) {
            if (diet == this.getSelectedDiet()) {
                return diet.getMeals();
            }
        }
        return null;
    }

    public boolean addMealToCurrentDiet(Meal newMeal) {
        if (!checkIfNameExisted(newMeal)) {
            this.getMealsForSelectedDiet().add(newMeal);
            return true;
        } else {
            return false;
        }
    }


    public Meal getMealByName(String mealName) {
        for (Meal meal : this.getAllMeals()) {
            if (meal.getMealName().equals(mealName)) {
                return meal;
            }
        }
        return null;
    }


    public ArrayList<Meal> getAllRecommendedMeals() {
        ArrayList<Meal> mealsTemp = new ArrayList<>();

        for (Meal meal : this.getAllMeals()) {
            if (this.getSelectedItems().containsAll(meal.getItems())) {
                mealsTemp.add(meal);
            }
        }
        ;
        return mealsTemp;
    }


    public ArrayList<Item> getSelectedItems() {
        ArrayList<Item> tempItems = new ArrayList<>();

        for (Item item : this.getAllItems()) {
            if (item.isSelected()) {
                tempItems.add(item);
            }
        }
        return tempItems;
    }

    public ArrayList<Item> getUnSelectedItems() {
        ArrayList<Item> tempItems = new ArrayList<>();

        for (Item item : this.getAllItems()) {
            if (item.isSelected()) {
                tempItems.add(item);
            }
        }
        return tempItems;
    }


    public void setAllItemsUnSelected() {
        for (Item item : this.getAllItems()) {
            item.unSelectedChange();
        }
    }
    public void setAllItemsSelected() {
        for (Item item : this.getAllItems()) {
            item.selectedChange();
        }
    }

}
