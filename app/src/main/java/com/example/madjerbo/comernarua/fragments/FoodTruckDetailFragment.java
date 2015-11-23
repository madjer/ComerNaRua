package com.example.madjerbo.comernarua.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madjerbo.comernarua.R;
import com.example.madjerbo.comernarua.entities.Foodtruck;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by felipeaquino on 22/11/15.
 */
public class FoodTruckDetailFragment extends BaseFragment {

    public String mTruckId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.foodtruck_detail, container, false);

        service.foodtruck(mTruckId, new Callback<Foodtruck>() {
            @Override
            public void success(Foodtruck foodtruck, Response response) {
                TextView nomeTxt = (TextView) view.findViewById(R.id.nome);
                TextView descricaoTxt = (TextView) view.findViewById(R.id.descricao);

                nomeTxt.setText(foodtruck.nome);
                descricaoTxt.setText(foodtruck.descricao);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(view.getContext(), "Erro ao acessar o servidor. ;(", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
