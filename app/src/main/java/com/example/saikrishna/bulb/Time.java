package com.example.saikrishna.bulb;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SaiKrishna on 8/14/2016.
 */
public class Time extends Fragment {



    public static Time newInstance(){
        Time fragment = new Time();
        return fragment;
    }

    public Time(){
    }
    String number;
    Button ont,oft,set;
    TextView onte,offte;
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.time, container, false);
        final SmsManager sms = SmsManager.getDefault();
        set = (Button) rootView.findViewById(R.id.send);
        onte=(TextView) rootView.findViewById(R.id.ontime);
        offte=(TextView) rootView.findViewById(R.id.offtime);
        number = container.getTag().toString();

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       //         sms.sendTextMessage(number, null, "SETLGHTONOFF"+onte.getText().toString()+offte.getText().toString(), null, null);
                Toast.makeText(getActivity(), "SMS Sent: SETLGHTONOFF"+onte.getText().toString()+offte.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        ont = (Button) rootView.findViewById(R.id.sot);
        ont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new OnPickerFragment();
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

        oft = (Button) rootView.findViewById(R.id.soft);
        oft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new OfPickerFragment();
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

        return rootView;
    }
    }
