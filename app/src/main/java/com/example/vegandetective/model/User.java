package com.example.vegandetective.model;
import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable {
    private String username;
    private ArrayList<Diet> diets;

    public User(){

    }
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

    public ArrayList<Diet> getDiets(){
        return this.diets;
    }


}
