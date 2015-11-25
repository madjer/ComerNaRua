package com.example.madjerbo.comernarua.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madjerbo.comernarua.R;
import com.example.madjerbo.comernarua.entities.Foodtruck;
import com.example.madjerbo.comernarua.util.DownloadImageTask;
import com.example.madjerbo.comernarua.util.Storage;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by felipeaquino on 22/11/15.
 */
public class FoodTruckDetailFragment extends BaseFragment implements OnMapReadyCallback {

    public String mTruckId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.foodtruck_detail, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        service.foodtruck(mTruckId, new Callback<Foodtruck>() {
            @Override
            public void success(Foodtruck foodtruck, Response response) {
                TextView nomeTxt = (TextView) view.findViewById(R.id.nome);
                TextView descricaoTxt = (TextView) view.findViewById(R.id.descricao);
                ImageView logo = (ImageView) view.findViewById(R.id.logo);

                nomeTxt.setText(foodtruck.nome);
                descricaoTxt.setText(foodtruck.descricao);

                final Storage storage = new Storage(view.getContext());

                // Aqui ele faz o cache das imagens da lista pra ir buscar no servidor só uma vez..
                if (storage.getImageLogo(foodtruck.id) == null) {
                    new DownloadImageTask(logo, foodtruck.id, storage).execute(foodtruck.logo_thumb);
                } else {
                    logo.setImageBitmap(storage.getImageLogo(foodtruck.id));
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(view.getContext(), "Erro ao acessar o servidor. ;(", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
    }

}
