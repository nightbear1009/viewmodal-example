package com.myapplication;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tedliang on 2017/6/18.
 */

public class AFragment extends LifecycleFragment {

    private TextView textview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.afragment, null);
        textview = view.findViewById(R.id.textview);
        SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        model.getSelected().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textview.setText(s);
            }
        });
        return view;
    }
}
