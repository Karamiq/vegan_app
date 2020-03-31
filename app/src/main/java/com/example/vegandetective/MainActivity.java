package com.example.vegandetective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.vegandetective.model.Diet;
import com.example.vegandetective.model.Item;
import com.example.vegandetective.model.Meal;
import com.example.vegandetective.model.User;


public class MainActivity extends AppCompatActivity {

    //initialize user data


    User user;
    Diet veganDiet;
    Meal dolmaMeal;
    Meal makhlamaMeal;

    Item tomatoes;
    Item paprika;
    Item onion;
    Item potatoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new User("Karam");
        veganDiet = new Diet("Vegan");
        dolmaMeal = new Meal("Dolma", "we mix tomatoes with paprika with onion and rice");
        makhlamaMeal = new Meal("Khalecha", "We mix I don't know yet");

        tomatoes = new Item("tomatoes", "vegetable", 10, R.drawable.vegan, true, true, true);
        paprika = new Item("paprika", "vegetable", 10, R.drawable.vegan, true, true, true);
        onion = new Item("onion", "vegetable", 10, R.drawable.vegan, true, true, true);
        potatoes = new Item("potatoes", "vegetable", 10, R.drawable.vegan, true, true, true);

        makhlamaMeal.addProduct(tomatoes);
        makhlamaMeal.addProduct(paprika);
        makhlamaMeal.addProduct(onion);
        makhlamaMeal.addProduct(potatoes);

        dolmaMeal.addProduct(tomatoes);
        dolmaMeal.addProduct(paprika);
        dolmaMeal.addProduct(onion);

        veganDiet.addMeal(dolmaMeal);
        veganDiet.addMeal(makhlamaMeal);

        user.addDiet(veganDiet);

        for (int i = 0; i < user.getDietByName("Vegan").getMealByName("Dolma").getItems().size() - 1; i++) {
            System.out.println(user.getDietByName("Vegan").getMealByName("Dolma").getItems().get(i));
        }
    }

    public void switchActivity(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        intent.putExtra("user", (Parcelable) user);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.items) {
            Intent intent = new Intent(getApplicationContext(), ItemListView.class);
            intent.putExtra("user", user);
            startActivity(intent);
            finish();
        }
        if (id == R.id.add_item_activity) {
            Intent intent = new Intent(this, UpdateProductsActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onclickSaveUser(View v){

    }

}
