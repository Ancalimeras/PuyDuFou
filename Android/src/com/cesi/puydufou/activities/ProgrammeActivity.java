package com.cesi.puydufou.activities;

import com.cesi.puydufou.R;
import com.cesi.puydufou.R.layout;
import com.cesi.puydufou.fragments.ListeSpectacleFragment;
import com.cesi.puydufou.fragments.PlanningAutoFragment;
import com.cesi.puydufou.fragments.PlanningPersoFragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;
import android.widget.Toast;


public class ProgrammeActivity extends Activity implements TabListener { 

	   private ListeSpectacleFragment frag1 = new ListeSpectacleFragment();
	   private PlanningPersoFragment frag2 = new PlanningPersoFragment(); 
	   private PlanningAutoFragment frag3 = new PlanningAutoFragment(); 
	   

	   @Override
	   public void onCreate(Bundle savedInstanceState) {       
	      super.onCreate(savedInstanceState);             
	      getWindow().requestFeature(Window.FEATURE_ACTION_BAR);       
	      setContentView(R.layout.activity_programme); 
	 
	      //Configuration de la barre d'onglet       
	      getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);       
	      getActionBar().addTab(getActionBar()
	         .newTab().setText("Liste").setTabListener(this));         
	      getActionBar().addTab(getActionBar() 
	         .newTab().setText("Créer").setTabListener(this));  
	      getActionBar().addTab(getActionBar() 
	         .newTab().setText("Auto").setTabListener(this));  
	   } 
	   
	   @Override 
	   public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
	      /*Toast.makeText(this, tab.getText() + " selected", 
	         Toast.LENGTH_SHORT).show();   */    

	      if(tab.getText().equals("Liste")){              
	         ft.replace(R.id.fragmentContainer, frag1);
	      }
	      else if(tab.getText().equals("Créer")){
	         ft.replace(R.id.fragmentContainer, frag2);
	      }
	      else if(tab.getText().equals("Auto")){ 
	          ft.replace(R.id.fragmentContainer, frag3);
	      }
	   } 

	   @Override
	   public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
	      /*Toast.makeText(this, tab.getText() + " unselected", 
	         Toast.LENGTH_SHORT).show(); */      

	      if(tab.getText().equals("Liste")){
	         ft.remove(frag1);
	      }
	      else if(tab.getText().equals("Créer")){
	         ft.remove(frag2);
	      }
	      else if(tab.getText().equals("Auto")){
	         ft.remove(frag3);
	      }
	   } 

	   @Override
	   public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
	      /*Toast.makeText(this, tab.getText() + " unselected", 
	            Toast.LENGTH_SHORT).show();*/
	   }
	}
