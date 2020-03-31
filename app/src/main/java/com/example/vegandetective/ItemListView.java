package com.example.vegandetective;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
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
import java.util.List;
import java.util.Set;

public class ItemListView extends AppCompatActivity {
    ArrayList<Item> items = new ArrayList<Item>();
    ListView listView;
    TextView textView;
    Spinner spinner2;
    ArrayList<Meal> meals;
    ArrayList<Diet> diets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //textView = (TextView) findViewById(R.id.textViewDiet);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_view);
        //ArrayList<Item> items = loadDate();

        //items = new ArrayList<>();

        //items = loadDate();


        User user = (User) getIntent().getSerializableExtra("user");


        assert user != null;
        for (Diet diet : user.getDiets()) {
            for (Meal meal : diet.getMeals()) {
                items.addAll(meal.getItems());
            }
        }
        Set<Item> set = new HashSet<Item>(items);
        items.clear();
        items.addAll(set);

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getItemName());
        }


        //Item product = (Item) getIntent().getSerializableExtra("product");
        //String size = Integer.toString(items.size());
        //items.add(product);

        listView = (ListView) findViewById(R.id.product_list_view);

        ArrayList<Item> selectedItems = new ArrayList<>();

        final ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.product_list_view, items);
        this.listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                                                Toast.makeText(ItemListView.this, items.get(position).getItemName(), Toast.LENGTH_SHORT).show();
                                                items.get(position).isSelectedChange();
                                                update();


                                            }
                                        }
        );

        //addItemsOnSpinner2();

    }

    public void update(){
        final ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.product_list_view, items);
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


//    public void addItemsOnSpinner2() {
//
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        List<String> list = new ArrayList<String>();
//        list.add("list 1");
//        list.add("list 2");
//        list.add("list 3");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(dataAdapter);
//    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
