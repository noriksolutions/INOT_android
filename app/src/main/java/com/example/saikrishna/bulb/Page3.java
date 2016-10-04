package com.example.saikrishna.bulb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SaiKrishna on 8/13/2016.
 */
public class Page3 extends Fragment {



    Button summer, winter, rainy, filcker;
    TextView numb;
    public static Page3 newInstance(){
        Page3 fragment = new Page3();
        return fragment;
    }

    public Page3(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page3, container, false);
        summer = (Button) rootView.findViewById(R.id.summer);
        winter = (Button) rootView.findViewById(R.id.winter);
        rainy = (Button) rootView.findViewById(R.id.rainy);
        filcker = (Button) rootView.findViewById(R.id.filcker);
        final String number = container.getTag().toString();
        final String TAG = "myApp";

        summer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "summer " + number);
            }
        });

        winter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "winter " + number);
            }
        });

        rainy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "rainy " + number);
            }
        });

        filcker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "filcker " + number);
            }
        });
        return rootView;
    }
}

