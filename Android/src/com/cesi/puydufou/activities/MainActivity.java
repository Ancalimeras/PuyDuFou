package com.cesi.puydufou.activities;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import classes.Ksoap;

import com.cesi.puydufou.R;
import com.cesi.puydufou.R.id;
import com.cesi.puydufou.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class MainActivity extends Activity {
	
	public RatingBar rate;
	private Context cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_Services).setOnClickListener(onClickListener);
        findViewById(R.id.btn_Plan).setOnClickListener(onClickListener);
        findViewById(R.id.btn_Programme).setOnClickListener(onClickListener);
        findViewById(R.id.btn_Share).setOnClickListener(onClickListener);
        
        cont = this;
        
        rate = (RatingBar) findViewById(R.id.ratingBar1);
        rate.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
    		public void onRatingChanged(RatingBar ratingBar, float rating,
    			boolean fromUser) {
     
    			//txtRatingValue.setText(String.valueOf(rating));
    			Toast.makeText(cont, String.valueOf(rating), Toast.LENGTH_LONG).show();
     
    		}
    	});
        
        //new Ksoap().execute();
        
        

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch(v.getId()){

                case R.id.btn_Services:
                    Intent serviceActivity = new Intent(MainActivity.this, ServicesActivity.class);
                    startActivity(serviceActivity);
                    break;

                case R.id.btn_Plan:
                    //TODO: FRAGMENT PLAN
                    break;

                case R.id.btn_Programme:
                    Intent programmeActivity = new Intent(MainActivity.this, ProgrammeActivity.class);
                    startActivity(programmeActivity);
                    break;

                case R.id.btn_Share:
                    //TODO: PRENDRE PHOTO + PARTAGE
                    break;

            }

        }
    };

}
