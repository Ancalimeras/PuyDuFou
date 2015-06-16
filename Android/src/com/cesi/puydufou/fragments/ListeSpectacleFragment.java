package com.cesi.puydufou.fragments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import classes.Ksoap;

import com.cesi.puydufou.R;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListeSpectacleFragment extends Fragment {
	
	private ListView list;
	private String response;
	
	private List<String> listSpectacles;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View detailJobView = inflater.inflate(R.layout.fragment_liste_spectacle, container, false);
		
		list = (ListView) detailJobView.findViewById(R.id.list);
		
		try {
			response =  new Ksoap("hello", "hello").execute().get().toString();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Toast.makeText(getActivity(), "ksoap response: " + response, Toast.LENGTH_LONG).show();
		
		listSpectacles = new ArrayList<String>();
		
		
		String[] values = new String[] {"Spectacle 1", "Spectacle 2", "Spectacle 3", "Spectacle 4"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
		
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
			    Toast.makeText(getActivity(),
			      "Click ListItem Number " + position, Toast.LENGTH_LONG)
			      .show();
			  }
			});
		
        return detailJobView;
	}

}
