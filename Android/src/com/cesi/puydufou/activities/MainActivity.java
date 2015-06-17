package com.cesi.puydufou.activities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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
import com.cesi.puydufou.fragments.PlanFragment;

import com.facebook.CallbackManager;
import com.facebook.FacebookDialog;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.widget.ShareDialog;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class MainActivity extends Activity {

	static final int REQUEST_IMAGE_CAPTURE = 1;
	static final int REQUEST_TAKE_PHOTO = 1;
	String mCurrentPhotoPath;
	
	CallbackManager callbackManager;
    ShareDialog shareDialog;
    
    ImageView img;
    
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btn_Services).setOnClickListener(onClickListener);
        findViewById(R.id.btn_Plan).setOnClickListener(onClickListener);
        findViewById(R.id.btn_Share).setOnClickListener(onClickListener);
        findViewById(R.id.btn_Programme).setOnClickListener(onClickListener);
        
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        
        img = (ImageView) findViewById(R.id.imgViewAccueil);
        
// android:src="@drawable/accueil"
        
    }
    
    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragment);
        fragmentTransaction.commit();
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
                	setFragment(new PlanFragment());
                    break;

                case R.id.btn_Share:
                    //TODO: PRENDRE PHOTO 
                	
                	/* Intent intent = new Intent(
                			 
                            android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, 0); */
               
                	//dispatchTakePictureIntent();
                	//galleryAddPic();
                	
                	//Ouverture du partage facebook
                	if (ShareDialog.canShow(ShareLinkContent.class)) {
                	    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                	            .setContentTitle("Puy du fou")
                	            .setContentDescription(
                	                    "L'histoire n'attend que vous!")
                	            .setContentUrl(Uri.parse("http://www.puydufou.com/"))
                	            .build();
                	    
                	 shareDialog.show(linkContent);
                	}
                	
                    break;
                    
                case R.id.btn_Programme:
                    Intent programmeActivity = new Intent(MainActivity.this, ProgrammeActivity.class);
                    startActivity(programmeActivity);
                    break;

            }

        }
    };
           
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    // TODO Auto-generated method stub

	    Bitmap bit= (Bitmap) data.getExtras().get("data");
	
	    img.setImageBitmap(bit);
	    

    };

}
