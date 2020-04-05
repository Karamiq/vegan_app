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
    Meal salad;
    Meal avocadoOnToast;
    Meal fatimaMeal;
    Item tomatoes;
    Item paprika;
    Item onion;
    Item potatoes;
    Item broccoli;
    Item oliveOil;
    Item avocado;
    Item lemon;
    Item chilliFlkes;
    Item oat;
    Item banana;
    Item water;
    Item almondMilk;
    Item soyMilk;
    Item vanilla;
    Item chiaSeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new User("Karam");
        veganDiet = new Diet("Vegan");
        dolmaMeal = new Meal("Dolma", "we mix tomatoes with paprika with onion and rice", R.drawable.dolma, 90);
        salad = new Meal("Salad", "cut everything into pieces and mix them together ", R.drawable.salad, 14);
        avocadoOnToast = new Meal("Avocado on Toast", "Cut the avocado in half" +
                " and carefully remove its stone, then scoop out the flesh into a bowl. Squeeze in " +
                "the lemon juice then mash with a fork to your desired texture. Season to taste with" +
                " sea salt, black pepper and chilli flakes. Toast your bread, drizzle over the oil " +
                "then pile the avocado on top.", R.drawable.avocadoontoast, 15);
        fatimaMeal = new Meal("fatima Meal", "Put the ingredients in the mixer " +
                "until it becomes texture like cake. Then Heat the Tefal " +
                "frying pan without oil Reduce the temperature and put the mixture in the pan and wait " +
                "When bubbles appear, flip them over.. I love it with peanut butter and fruits",
                R.drawable.fatima, 15);

        // add items
        tomatoes = new Item("tomatoes", "vegetable", 100, R.drawable.vegan, true, true, true);
        paprika = new Item("paprika", "vegetable", 100, R.drawable.vegan, true, true, true);
        onion = new Item("onion", "vegetable", 100, R.drawable.vegan, true, true, true);
        potatoes = new Item("potatoes", "vegetable", 100, R.drawable.vegan, true, true, true);
        broccoli = new Item("Brocooli", "Vegetable", 100, R.drawable.vegan, true, true, true);
        oliveOil = new Item("Olive Oil", "oil", 100, R.drawable.vegan, true, true, true, true);
        avocado = new Item("Avocado", "Vegetable", 100, R.drawable.vegan, true, true, true, true);
        lemon = new Item("Lemon", "Vegetable", 100, R.drawable.vegan, true, true, true, true);
        chilliFlkes = new Item("Chilli Flakes ", "Vegetable", 10, R.drawable.vegan, true, true, true, true);
        oat = new Item("Oat", "Vegetable", 10, R.drawable.vegan, true, true, true, true);
        banana = new Item("Banana", "Vegetable", 10, R.drawable.vegan, true, true, true, true);
        water = new Item("Water", "Liquid", 10, R.drawable.vegan, true, true, true, true);
        almondMilk = new Item("Almond Milk", "Milk", 10, R.drawable.vegan, true, true, true, true);
        soyMilk = new Item("Soy Milk ", "Milk", 10, R.drawable.vegan, true, true, true, true);
        vanilla = new Item("Vanilla ", "Spice", 10, R.drawable.vegan, true, true, true, true);
        chiaSeed = new Item("Chia Seed", "Vegetable", 10, R.drawable.vegan, true, true, true, true);


        // add items to meal Salad
        salad.addItem(tomatoes);
        salad.addItem(paprika);
        salad.addItem(onion);

        // add items to Meal Dolma
        dolmaMeal.addItem(tomatoes);
        dolmaMeal.addItem(paprika);
        dolmaMeal.addItem(onion);
        dolmaMeal.addItem(potatoes);

        // add items to Meal avocadoOnToast
        avocadoOnToast.addItem(avocado);
        avocadoOnToast.addItem(oliveOil);
        avocadoOnToast.addItem(lemon);
        avocadoOnToast.addItem(chilliFlkes);

        // add to fatima meal
        fatimaMeal.addItem(oat);
        fatimaMeal.addItem(banana);
        fatimaMeal.addItem(water);
        fatimaMeal.addItem(almondMilk);
        fatimaMeal.addItem(vanilla);
        fatimaMeal.addItem(chiaSeed);


        // add meals to Vegan Diet
        veganDiet.addMeal(dolmaMeal);
        veganDiet.addMeal(salad);
        veganDiet.addMeal(avocadoOnToast);
        veganDiet.addMeal(fatimaMeal);

        user.addDiet(veganDiet);

        user.setSelectedDiet(veganDiet);

        for (int i = 0; i < user.getDietByName("Vegan").getMealByName("Dolma").getItems().size() - 1; i++) {
            System.out.println(user.getDietByName("Vegan").getMealByName("Dolma").getItems().get(i));
        }

        switchActivity();
    }

    public void switchActivity() {
        Intent intent = new Intent(this, AddMeal.class);
        intent.putExtra("user", user);
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

    public void onclickSaveUser(View v) {

    }

}
