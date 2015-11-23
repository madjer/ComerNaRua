package com.example.madjerbo.comernarua.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madjerbo.comernarua.R;
import com.example.madjerbo.comernarua.entities.Foodtruck;
import com.example.madjerbo.comernarua.util.DownloadImageTask;
import com.example.madjerbo.comernarua.util.Helper;
import com.example.madjerbo.comernarua.util.Storage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by felipeaquino on 22/11/15.
 */
public class FoodtruckAdapter extends ArrayAdapter<Foodtruck> {
    Context context;
    List<Foodtruck> foodtrucks;

    public FoodtruckAdapter(Context context, List<Foodtruck> foodtrucks) {
        super(context, R.layout.foodtruck_list_item, foodtrucks);
        this.context = context;
        this.foodtrucks = foodtrucks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.foodtruck_list_item, parent, false);

        Foodtruck foodtruck = foodtrucks.get(position);
        TextView tituloTxt = (TextView) view.findViewById(R.id.itemTitle);
        TextView descricaoTxt = (TextView) view.findViewById(R.id.itemDesc);
        ImageView logoView = (ImageView) view.findViewById(R.id.logo);

        tituloTxt.setText(foodtruck.nome);
        descricaoTxt.setText(foodtruck.descricao);

        final Storage storage = new Storage(view.getContext());

        // Aqui ele faz o cache das imagens da lista pra ir buscar no servidor só uma vez..
        if (storage.getImageLogo(foodtruck.id) == null) {
            new DownloadImageTask(logoView, foodtruck.id, storage).execute(foodtruck.logo_thumb);
        } else {
            logoView.setImageBitmap(storage.getImageLogo(foodtruck.id));
        }



        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}