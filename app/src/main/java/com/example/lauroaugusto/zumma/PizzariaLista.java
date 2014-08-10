package com.example.lauroaugusto.zumma;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

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
        List<Pizzaria> pizzarias = buscarPizzarias();

        PizzariaAdapter pizzariasAdapter = new PizzariaAdapter(getActivity(), pizzarias);
        lvPizzarias.setAdapter(pizzariasAdapter);
        lvPizzarias.setOnItemClickListener(this);


        return view;
    }

    private List<Pizzaria> buscarPizzarias(){
        List<Pizzaria> pizzarias = new ArrayList();
        ObjectContainer oc = Db4oEmbedded.openFile(getActivity().getDir("data", 0) + "/" + "db.db4o");
        ObjectSet<Pizzaria> query = oc.query(Pizzaria.class);

        if (query.size() == 0)
        {
            // TODO: Buscar do seridor as pizzarias.

            for (int i = 0; i < 10; i++) {
                Pizzaria pizzaria = new Pizzaria("Loja " + (i + 1), R.drawable.ic_launcher, i + 1);
                pizzarias.add(pizzaria);
                oc.store(pizzaria);
            }
            oc.commit();
        }
        else
        {
            for (Pizzaria pizzaria : query) {
                pizzarias.add(pizzaria);
            }
        }
        oc.close();
        return pizzarias;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
