package com.example.lauroaugusto.zumma;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PizzaFavorita extends android.support.v4.app.Fragment{

    public PizzaFavorita(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_pizza_favorita,container,false);
        return view;
    }
}
