package com.cesi.puydufou.fragments;

import com.cesi.puydufou.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RestaurationFragment extends Fragment{
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View detailJobView = inflater.inflate(R.layout.fragment_restauration, container, false);

        return detailJobView;
	}

}
