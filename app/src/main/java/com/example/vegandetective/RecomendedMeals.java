package com.example.vegandetective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.vegandetective.model.Diet;
import com.example.vegandetective.model.Item;
import com.example.vegandetective.model.Meal;
import com.example.vegandetective.model.MealAdapter;
import com.example.vegandetective.model.User;

import java.util.ArrayList;

public class RecomendedMeals extends AppCompatActivity {
    ArrayList<Item> items = new ArrayList<Item>();
    ListView listView;
    ArrayList<Meal> mealsTemp = new ArrayList<>();
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomended_meals);

        listView = (ListView) findViewById(R.id.meal_recommended_view);


        user = (User) getIntent().getSerializableExtra("user");




        assert user != null;
        final MealAdapter mealAdapter = new MealAdapter(this, R.layout.meal_list_view, user.getAllRecommendedMeals());
        this.listView.setAdapter(mealAdapter);
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, ItemListView.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }


}
