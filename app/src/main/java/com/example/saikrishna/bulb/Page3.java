package com.example.saikrishna.bulb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SaiKrishna on 8/13/2016.
 */
public class Page3 extends Fragment {


    EditText message1,phone1;
    Button send;
    public static Page3 newInstance(){
        Page3 fragment = new Page3();
        return fragment;
    }

    public Page3(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page3, container, false);
        message1 = (EditText) rootView.findViewById(R.id.message);
        phone1 = (EditText) rootView.findViewById(R.id.phone);
        send = (Button) rootView.findViewById(R.id.send);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = phone1.getText().toString();
                String mssg = message1.getText().toString();
                if(number.length()==10){
                    SmsManager sms = SmsManager.getDefault();
            //      sms.sendTextMessage(number, null, mssg, null, null);
                    Toast.makeText(getActivity(), "SMS Sent: "+mssg, Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(), "Invalid Number", Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootView;
    }
}

