package com.cesi.puydufou.fragments;

import com.cesi.puydufou.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PlanFragment extends Fragment{
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View detailJobView = inflater.inflate(R.layout.fragment_plan, container, false);

        
        
        return detailJobView;
	}

}
