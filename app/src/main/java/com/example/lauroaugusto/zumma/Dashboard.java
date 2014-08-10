package com.example.lauroaugusto.zumma;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends FragmentActivity implements ActionBar.TabListener{

    List<Pizzaria> listPizzarias;
    ActionBar actionBar;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        /* recupera a view da acivity e cria as fragments com o adapter */
        viewPager = (ViewPager) findViewById(R.id.activity_dashbord);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));



        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /* pega a mudança da tab view*/
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                actionBar.setSelectedNavigationItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        ActionBar.Tab tabListaPizzaria = actionBar.newTab().setText("Pizzarias").setTabListener(this);
        ActionBar.Tab tabPizzariaFavorita = actionBar.newTab().setText("Pizzaria Favorita").setTabListener(this);
        ActionBar.Tab tabPizzaFavorita = actionBar.newTab().setText("Pizza Favorita").setTabListener(this);

        actionBar.addTab(tabListaPizzaria);
        actionBar.addTab(tabPizzariaFavorita);
        actionBar.addTab(tabPizzaFavorita);

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

    /* pega a mudança da tab view*/
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
        Log.d("Zumma","OnTabSelected em "+"posição: "+ tab.getPosition()+"Nome"+ tab.getText());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.d("Zumma","OnTabUnSelected em "+"posição: "+ tab.getPosition()+"Nome"+ tab.getText());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.d("Zumma","OnTabReSelected em "+"posição: "+ tab.getPosition()+"Nome"+ tab.getText());
    }
}

class ViewPagerAdapter extends FragmentPagerAdapter{

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int item) {
        Fragment fragment=null;

        if(item == 0){
            fragment = new PizzariaLista();
        }
        if(item == 1){
            fragment = new PizzariaFavorita();
        }
        if (item == 2){
            fragment = new PizzaFavorita();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
