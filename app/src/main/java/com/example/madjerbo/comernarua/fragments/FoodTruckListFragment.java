package com.example.madjerbo.comernarua.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.madjerbo.comernarua.R;
import com.example.madjerbo.comernarua.adapters.FoodtruckAdapter;
import com.example.madjerbo.comernarua.api.ComerNaRuaService;
import com.example.madjerbo.comernarua.entities.Foodtruck;
import com.example.madjerbo.comernarua.util.Helper;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by felipeaquino on 22/11/15.
 */
public class FoodTruckListFragment extends BaseFragment {

    final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Helper.host).build();
    final ComerNaRuaService service = restAdapter.create(ComerNaRuaService.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.foodtrucks_listview, container, false);
        final ListView listview = (ListView) view.findViewById(R.id.truckslistview);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodTruckDetailFragment detail = new FoodTruckDetailFragment();

                Foodtruck truck = ((Foodtruck) ((ListView) parent).getAdapter().getItem(position));
                detail.mTruckId = truck.id;

                openFragment(detail);
            }
        });

        service.foodtrucks(new Callback<List<Foodtruck>>() {
            @Override
            public void success(List<Foodtruck> foodtrucks, Response response) {
                FoodtruckAdapter adapter = new FoodtruckAdapter(view.getContext(), foodtrucks);
                listview.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(view.getContext(), "Erro ao acessar o servidor. ;(", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
