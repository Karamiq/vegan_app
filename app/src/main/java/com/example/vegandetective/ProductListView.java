package com.example.vegandetective;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vegandetective.model.Product;
import com.example.vegandetective.model.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductListView extends AppCompatActivity {

    ListView listView;
    ArrayList<Product> products = new ArrayList<>();
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_view);


        listView = (ListView) findViewById(R.id.product_list_view);
        products.add(new Product("banana", "fruit", 20, 1, true, false, false));
        products.add(new Product("cheese", "milk product", 100, 2, false, true, false));
        products.add(new Product("meat", "meat product", 1000, 3, false, false, true));

        final ProductAdapter productsAdapter = new ProductAdapter(this, R.layout.product_list_view, this.products);
        this.listView.setAdapter(productsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                                Toast.makeText(ProductListView.this, products.get(position).getItemName(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
        );
    }
}
