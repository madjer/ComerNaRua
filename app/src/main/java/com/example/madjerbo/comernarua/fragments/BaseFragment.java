package com.example.madjerbo.comernarua.fragments;

import android.support.v4.app.Fragment;

import com.example.madjerbo.comernarua.MainActivity;

public class BaseFragment extends Fragment {

    public MainActivity getBaseActivity() {
        return (MainActivity) getActivity();
    }

    public void openFragment(Fragment fragment) {
        getBaseActivity().openFragment(fragment);
    }
}
