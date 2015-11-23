package com.example.madjerbo.comernarua.fragments;

import android.support.v4.app.Fragment;

import com.example.madjerbo.comernarua.MainActivity;
import com.example.madjerbo.comernarua.api.ComerNaRuaService;
import com.example.madjerbo.comernarua.util.Helper;

import retrofit.RestAdapter;

public class BaseFragment extends Fragment {

    final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Helper.host).build();
    final ComerNaRuaService service = restAdapter.create(ComerNaRuaService.class);

    public MainActivity getBaseActivity() {
        return (MainActivity) getActivity();
    }

    public void openFragment(Fragment fragment) {
        getBaseActivity().openFragment(fragment);
    }
}
