package com.example.lauroaugusto.zumma;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lauroaugusto.zumma.R;

import java.util.ArrayList;
import java.util.List;

public class PizzariaLista extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {

    public PizzariaLista(){
    }
    View view;
    ListView lvPizzarias =null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pizzaria_lista,container,false);

        lvPizzarias = (ListView) view.findViewById(R.id.lvTarap);
        List<Pizzaria> pizzaria = gerarPizzarias();

        PizzariaAdapter pizzariasAdapter = new PizzariaAdapter(getActivity(), pizzaria);
        lvPizzarias.setAdapter(pizzariasAdapter);
        lvPizzarias.setOnItemClickListener(this);


        return view;
    }

    private List<Pizzaria> gerarPizzarias(){
        List<Pizzaria> pizzarias = new ArrayList();
        pizzarias.add(criaPizzaria("Loja1", R.drawable.ic_launcher, 0));
        pizzarias.add(criaPizzaria("Loja2", R.drawable.ic_launcher, 1));
        pizzarias.add(criaPizzaria("Loja3", R.drawable.ic_launcher, 2));
        pizzarias.add(criaPizzaria("Loja4", R.drawable.ic_launcher, 3));
        pizzarias.add(criaPizzaria("Loja5", R.drawable.ic_launcher, 4));
        pizzarias.add(criaPizzaria("Loja6", R.drawable.ic_launcher, 5));
        pizzarias.add(criaPizzaria("Loja7", R.drawable.ic_launcher, 6));
        pizzarias.add(criaPizzaria("Loja8", R.drawable.ic_launcher, 7));
        pizzarias.add(criaPizzaria("Loja9", R.drawable.ic_launcher, 8));
        pizzarias.add(criaPizzaria("Loja10", R.drawable.ic_launcher, 9));
        pizzarias.add(criaPizzaria("Loja11", R.drawable.ic_launcher, 10));
        pizzarias.add(criaPizzaria("Loja12", R.drawable.ic_launcher, 11));
        pizzarias.add(criaPizzaria("Loja13", R.drawable.ic_launcher, 12));
        pizzarias.add(criaPizzaria("Loja14", R.drawable.ic_launcher, 13));
        pizzarias.add(criaPizzaria("Loja15", R.drawable.ic_launcher, 14));

        return pizzarias;
    }

    private Pizzaria criaPizzaria(String nome, int idImg, int id){
        Pizzaria pizzaria = new Pizzaria(nome,idImg, id);
        return pizzaria;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
