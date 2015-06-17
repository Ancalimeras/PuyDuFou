package com.cesi.puydufou.activities;

import com.cesi.puydufou.R;
import com.cesi.puydufou.R.layout;
import com.cesi.puydufou.fragments.BoutiqueFragment;
import com.cesi.puydufou.fragments.HotelFragment;
import com.cesi.puydufou.fragments.RestaurationFragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;
import android.widget.Toast;

/**
 * Created by Bigdool on 15/06/2015.
 */
public class ServicesActivity extends Activity implements TabListener {

    private RestaurationFragment fragRestauration = new RestaurationFragment();
    private BoutiqueFragment fragBoutique = new BoutiqueFragment();
    private HotelFragment fragHotel = new HotelFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_services);

        //Configuration de la barre d'onglet
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        getActionBar().addTab(getActionBar()
                .newTab().setText("Restauration").setTabListener(this));
        getActionBar().addTab(getActionBar()
                .newTab().setText("Boutiques").setTabListener(this));
        getActionBar().addTab(getActionBar()
                .newTab().setText("Hôtels").setTabListener(this));

    }

    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {


        if(tab.getText().equals("Restauration")){
            ft.replace(R.id.fragmentContainer, fragRestauration);
        }
        else if(tab.getText().equals("Boutiques")){
            ft.replace(R.id.fragmentContainer, fragBoutique);
        }
        else if(tab.getText().equals("Hôtels")){
            ft.replace(R.id.fragmentContainer, fragHotel);
        }

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

        if(tab.getText().equals("Restauration")){
            ft.remove(fragRestauration);
        }
        else if(tab.getText().equals("Boutiques")){
            ft.remove(fragBoutique);
        }
        else if(tab.getText().equals("Hôtels")){
            ft.remove(fragHotel);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

}