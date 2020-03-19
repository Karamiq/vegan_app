package com.example.vegandetective.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.vegandetective.R;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> dataSetProduct;
    private Context myContext;
    private int rowLayout;

    public ProductAdapter(Context context, int rowLayout, ArrayList<Product> dataSetProduct) {
        super(context, rowLayout, dataSetProduct);
        this.dataSetProduct = dataSetProduct;
        this.myContext = context;
        this.rowLayout = rowLayout;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(myContext).inflate(rowLayout, parent, false);
        }
        Product currentProduct = this.dataSetProduct.get(position);

        TextView itemName = listItem.findViewById(R.id.item_name);
        itemName.setText(currentProduct.getItemName());

        TextView itemType = listItem.findViewById(R.id.item_type);
        if (currentProduct.isVegan()) {
            itemType.setText(R.string.vegan);
            //to do, set color green
        } else if (currentProduct.isVegetarian()) {
            itemType.setText(R.string.vegetarian);
        } else {
            itemType.setText(R.string.carnivore);
        }
        TextView calories = listItem.findViewById(R.id.calories);
        calories.setText(currentProduct.getCalories());

        ImageView itemPicture = listItem.findViewById(R.id.product_picture);
        itemPicture.setImageResource(currentProduct.getPicture());


        return listItem;
    }


}
