package com.example.madjerbo.comernarua.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.madjerbo.comernarua.R;
import com.example.madjerbo.comernarua.entities.Foodtruck;

import java.util.List;

/**
 * Created by felipeaquino on 22/11/15.
 */
public class FoodtruckAdapter extends ArrayAdapter<Foodtruck> {
    Context context;
    List<Foodtruck> foodtrucks;

    public FoodtruckAdapter(Context context, List<Foodtruck> foodtrucks) {
        super(context, R.layout.food_truck_item_list, foodtrucks);
        this.context = context;
        this.foodtrucks = foodtrucks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.food_truck_item_list, parent, false);
        Foodtruck foodtruck = foodtrucks.get(position);

        ((TextView) view.findViewById(R.id.itemTitle)).setText(foodtruck.nome);

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}