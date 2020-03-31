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

public class ItemAdapter extends ArrayAdapter<Item> {

    private ArrayList<Item> dataSetItem;
    private Context myContext;
    private int rowLayout;

    public ItemAdapter(Context context, int rowLayout, ArrayList<Item> dataSetItem) {
        super(context, rowLayout, dataSetItem);
        this.dataSetItem = dataSetItem;
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
        Item currentItem = this.dataSetItem.get(position);

        TextView itemName = listItem.findViewById(R.id.item_name);
        itemName.setText(currentItem.getItemName());

//        TextView itemType = listItem.findViewById(R.id.item_type);
//        if (currentItem.isVegan()) {
//            itemType.setText(R.string.vegan);
//            //to do, set color green
//        } else if (currentItem.isVegetarian()) {
//            itemType.setText(R.string.vegetarian);
//        } else {
//            itemType.setText(R.string.carnivore);
//        }
//        TextView calories = listItem.findViewById(R.id.calories);
//        calories.setText(R.string.test);

        ImageView itemPicture = listItem.findViewById(R.id.product_picture);
        if(currentItem.isSelected())
        {
            itemPicture.setImageResource(R.drawable.selected);
        }


        return listItem;
    }


}
