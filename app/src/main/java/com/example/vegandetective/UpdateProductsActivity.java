package com.example.vegandetective;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.vegandetective.model.Item;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class UpdateProductsActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText item_name;
    EditText description;
    EditText calories;
    private boolean isVegan = false;
    private boolean isVegetarian = false;
    private boolean isOmnivore = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_products);


        radioGroup = (RadioGroup) findViewById(R.id.diet_radio_buttons);
        item_name = (EditText) findViewById(R.id.add_item_name);
        description = (EditText) findViewById(R.id.add_item_desc);
        calories = (EditText) findViewById(R.id.add_item_calories);

    }


    public void submitNewItem(View v) {


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
                radioButton = (RadioButton) findViewById(id);
                switch (radioButton.getId()) {
                    case R.id.vegan_radio_button: {
                        isVegan = true;
                        isVegetarian = false;
                        isOmnivore = false;
                    }
                    break;
                    case R.id.vegetarian_radio_button: {
                        isVegetarian = true;
                        isVegan = false;
                        isOmnivore = false;
                    }
                    break;
                    case R.id.omnivore_radio_button: {
                        isOmnivore = true;
                        isVegetarian = false;
                        isVegan = false;
                    }

                }
            }
        });

        ArrayList<Item> items = loadDate();

        items.add(new Item(item_name.getText().toString(), description.getText().toString(), Integer.parseInt(calories.getText().toString()), R.drawable.vegan, isVegan, isVegetarian, isOmnivore));
        //items.add(new Item("banana", "fruit", 20, R.drawable.vegan, true, false, false));
        saveDate(items);


    }


    public void SwitchToHome(View v) {
        //this.setContentView(R.layout.details);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void saveDate(ArrayList<Item> items) {
        // https://www.youtube.com/watch?v=jcliHGR3CHo
        //ArrayList<Item> items = loadDate();
        SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(items);
        editor.putString("items", json);
        editor.apply();
    }

    public ArrayList<Item> loadDate() {

        SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("items", null);
        Type type = new TypeToken<ArrayList<Item>>() {
        }.getType();
        ArrayList<Item> products1 = gson.fromJson(json, type);

        if (products1 == null) {
            products1 = new ArrayList<>();
        }
        return products1;
    }

}
