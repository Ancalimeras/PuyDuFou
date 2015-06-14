package com.cesi.puydufou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_Services).setOnClickListener(onClickListener);
        findViewById(R.id.btn_Plan).setOnClickListener(onClickListener);
        findViewById(R.id.btn_Programme).setOnClickListener(onClickListener);
        findViewById(R.id.btn_Share).setOnClickListener(onClickListener);

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
                    Intent programmeActivity = new Intent(MainActivity.this, ServicesActivity.class);
                    startActivity(programmeActivity);
                    break;

                case R.id.btn_Share:
                    //TODO: PRENDRE PHOTO + PARTAGE
                    break;

            }

        }
    };

}
