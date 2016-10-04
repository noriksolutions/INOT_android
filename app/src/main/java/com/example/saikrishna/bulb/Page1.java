package com.example.saikrishna.bulb;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.pubnub.api.Callback;
import com.pubnub.api.*;
import com.pubnub.api.PubnubError;
import keys.PubnubKeys;
/**
 * Created by SaiKrishna on 8/13/2016.
 */

public class Page1 extends Fragment {

    String number;
    public static Page1 newInstance(){
        Page1 fragment = new Page1();
        return fragment;
    }
    public Page1(){
    }
    public Pubnub pubnub = new Pubnub(PubnubKeys.PUBLISH_KEY, PubnubKeys.SUBSCRIBE_KEY);
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page1, container, false);

        final ImageView imageview = (ImageView) rootView.findViewById(R.id.bulb);
        imageview.setTag(1);

        imageview.setOnClickListener(new View.OnClickListener() {

               public Callback callback = new Callback() {
                public void successCallback(String channel, Object response) {
                    System.out.println(response.toString());
                }
                public void errorCallback(String channel, PubnubError error) {
                    System.out.println(error.toString());
                }
            };

            @Override
            public void onClick(View v) {
                number = container.getTag().toString();
                SmsManager sms = SmsManager.getDefault();
                Page2 p2 = new Page2();
                if(Integer.parseInt(imageview.getTag().toString()) == 1 ){
                    Page2.status.setText("All the bulbs are ON");
                }else{
                    Page2.status.setText("All the bulbs are OFF");
                }
                if (Integer.parseInt(imageview.getTag().toString()) == 1 && number!=null) {
                    imageview.setBackgroundResource(R.drawable.bulb2);
                    String mess = "FORCEADMINLGTON";
                    pubnub.publish(PubnubKeys.CHANNEL_NAME, mess , callback);
                    sms.sendTextMessage(number, null, mess, null, null);
                    Toast.makeText(getActivity(),  "SMS Sent: "+ mess, Toast.LENGTH_LONG).show();
                    imageview.setTag(2);
                } else if(number!=null) {
                    imageview.setBackgroundResource(R.drawable.bulb1);
                    String mess = "FORCEADMINLGTOFF";
                    pubnub.publish(PubnubKeys.CHANNEL_NAME, mess , callback);
                    sms.sendTextMessage(number, null, mess, null, null);
                    Toast.makeText(getActivity().getApplicationContext(), "SMS Sent: "+ mess, Toast.LENGTH_SHORT).show();
                    imageview.setTag(1);
                }else {
                    Toast.makeText(getActivity().getApplicationContext(), "Enter Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }
}
