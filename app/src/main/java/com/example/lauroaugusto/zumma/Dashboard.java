package com.example.lauroaugusto.zumma;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Dashboard extends Activity implements AdapterView.OnItemClickListener{

    ListView lvPizzarias =null;
    //List<Pizzaria> listPizzarias,


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        lvPizzarias = (ListView) findViewById(R.id.lvPizzarias);

        List<Pizzaria> pizzaria = gerarPizzarias();

        PizzariaAdapter pizzariasAdapter = new PizzariaAdapter(this, pizzaria);
        lvPizzarias.setAdapter(pizzariasAdapter);
        lvPizzarias.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        //Pizzaria p = (Pizzaria)adapterView.getItemAtPosition(position);

        //intent =  new Intent(this, LojaUm.class);
        //intent.putExtra("PARAMETRO", p);
        //startActivity(intent);
    }

    private List<Pizzaria> gerarPizzarias(){
        List<Pizzaria> pizzaria = new ArrayList<Pizzaria>();
        pizzaria.add(criaPizzaria("Loja1", R.drawable.ic_launcher, 0));
        pizzaria.add(criaPizzaria("Loja2", R.drawable.ic_launcher, 1));
        pizzaria.add(criaPizzaria("Loja3", R.drawable.ic_launcher, 2));
        pizzaria.add(criaPizzaria("Loja4", R.drawable.ic_launcher, 3));
        pizzaria.add(criaPizzaria("Loja5", R.drawable.ic_launcher, 4));
        pizzaria.add(criaPizzaria("Loja6", R.drawable.ic_launcher, 5));
        pizzaria.add(criaPizzaria("Loja7", R.drawable.ic_launcher, 6));
        pizzaria.add(criaPizzaria("Loja8", R.drawable.ic_launcher, 7));
        pizzaria.add(criaPizzaria("Loja9", R.drawable.ic_launcher, 8));
        pizzaria.add(criaPizzaria("Loja10", R.drawable.ic_launcher, 9));
        pizzaria.add(criaPizzaria("Loja11", R.drawable.ic_launcher, 10));
        pizzaria.add(criaPizzaria("Loja12", R.drawable.ic_launcher, 11));
        pizzaria.add(criaPizzaria("Loja13", R.drawable.ic_launcher, 12));
        pizzaria.add(criaPizzaria("Loja14", R.drawable.ic_launcher, 13));
        pizzaria.add(criaPizzaria("Loja15", R.drawable.ic_launcher, 14));

        return pizzaria;
    }

    private Pizzaria criaPizzaria(String nome, int idImg, int id){
        Pizzaria pizzaria = new Pizzaria(nome,idImg, id);
        return pizzaria;
    }

}
