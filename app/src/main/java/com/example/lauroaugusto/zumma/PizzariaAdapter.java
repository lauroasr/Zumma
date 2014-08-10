package com.example.lauroaugusto.zumma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 + * Created by Jefferson on 04/08/2014.
 + */
public class PizzariaAdapter extends ArrayAdapter<Pizzaria> {

    private Context context;
    private List<Pizzaria> pizzarias = null;
    ImageView ivPizzaria;
    TextView tvNomePizzaria;
    TextView tvNumeroPizzaria;

    public PizzariaAdapter(Context context, List<Pizzaria>pizzaria) {
        super(context, 0, pizzaria);
        this.context = context;
        this.pizzarias = pizzaria;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pizzaria pizzaria = pizzarias.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.row_pizzaria, null);
        }
        init(convertView);
        ivPizzaria.setImageResource(pizzaria.getIdImg());
        tvNomePizzaria.setText(pizzaria.getNome());

        return convertView;
        }

    public void init(View view){
        ivPizzaria = (ImageView) view.findViewById(R.id.ivViewPizzaria);
        tvNomePizzaria = (TextView) view.findViewById(R.id.tvNomePizzaria);
        tvNumeroPizzaria = (TextView) view.findViewById(R.id.tvTelefone);
    }

    static class ViewHolder{
        ImageView ivPizzaria;
        TextView tvNomePizzaria;
        TextView tvNumeroPizzaria;
    }
}
