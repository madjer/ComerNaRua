package com.example.madjerbo.comernarua;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.madjerbo.comernarua.api.ComerNaRuaService;
import com.example.madjerbo.comernarua.entities.Foodtruck;
import com.example.madjerbo.comernarua.fragments.FoodTruckListFragment;
import com.example.madjerbo.comernarua.util.Helper;
import com.google.android.gms.maps.MapFragment;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (savedInstanceState == null) {
            this.openFragment(new FoodTruckListFragment());
        }
    }

    public void openFragment(Fragment fragment) {

        MapFragment mMapFragment = MapFragment.newInstance();
        getSupportFragmentManager()
        .beginTransaction()
                .setCustomAnimations(
                        R.anim.transition_activity_enter,// transition_down_up_enter,
                        R.anim.transition_down_up_exit,
                        R.anim.transition_activity_enter,
                        R.anim.transition_down_up_exit
                )
                .addToBackStack(null)
                .replace(R.id.container, fragment)
                .commit();
    }
}
