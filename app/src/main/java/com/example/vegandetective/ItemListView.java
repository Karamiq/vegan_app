package com.example.vegandetective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vegandetective.model.Diet;
import com.example.vegandetective.model.Item;
import com.example.vegandetective.model.Meal;
import com.example.vegandetective.model.ItemAdapter;
import com.example.vegandetective.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ItemListView extends AppCompatActivity {
    ArrayList<Item> items = new ArrayList<Item>();
    ListView listView;
    TextView textView;
    Spinner spinner2;
    ArrayList<Meal> meals;
    ArrayList<Diet> diets;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_view);


        user = (User) getIntent().getSerializableExtra("user");


        listView = (ListView) findViewById(R.id.product_list_view);


        final ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.item_list_view, user.getAllItems());
        this.listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                                                Toast.makeText(ItemListView.this, user.getAllItems().get(position).getItemName(), Toast.LENGTH_SHORT).show();
                                                user.getAllItems().get(position).isSelectedChange();
                                                updateListView();


                                            }
                                        }
        );


    }

    public void updateListView() {
        final ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.item_list_view, user.getAllItems());
        this.listView.setAdapter(itemAdapter);
    }

    public ArrayList<Item> loadDate() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("items", null);
        Type type = new TypeToken<ArrayList<Item>>() {
        }.getType();
        return gson.<ArrayList<Item>>fromJson(json, type);

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
            Intent intent = new Intent(this, ItemListView.class);
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

    public void recommendMeMealsButton(View v) {
        Intent intent = new Intent(this, RecomendedMeals.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
