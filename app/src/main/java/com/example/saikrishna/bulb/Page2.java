package com.example.saikrishna.bulb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.pubnub.api.*;

import org.w3c.dom.Text;

import keys.PubnubKeys;

public class Page2 extends Fragment {
    public static int flag = 0;
    public Pubnub pubnub = new Pubnub(PubnubKeys.PUBLISH_KEY, PubnubKeys.SUBSCRIBE_KEY);
    public static TextView status;
    public static Page2 newInstance(){
        Page2 fragment = new Page2();
        return fragment;
    }
    public Callback callback = new Callback() {
        public void successCallback(String channel, Object response) {
            System.out.println(response.toString());
        }
        public void errorCallback(String channel, PubnubError error) {
            System.out.println(error.toString());
        }
    };
    public Page2(){
    }
    String number;
    Switch all1;
    View rootView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.page2, container, false);
        // all1=(Switch) rootView.findViewById(R.id.onoff);
        final  SmsManager sms = SmsManager.getDefault();
        GridView gv = (GridView) rootView.findViewById(R.id.gridView1);
        gv.setAdapter(new ImageAdapter(getActivity().getApplicationContext()));
        GridView gv1 = (GridView) rootView.findViewById(R.id.gridView1);
        gv1.setAdapter(new ImageAdapter(getActivity().getApplicationContext()));
        status = (TextView) rootView.findViewById(R.id.status);
        status.setText("All the bulbs are OFF");
       // number = container.getTag().toString();
        //all1.setTextOn("ON");
       // all1.setTextOff("OFF");
       /* all1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()){}

                else {}

            }  });*/
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int num = ImageAdapter.thumb[position];

                String prompt;
                if(num == ImageAdapter.mThumbIds[1] && number!=null){
                    ImageView imageView = (ImageView) view;
                    prompt = "Bulb " + (position+1) + " is Off";
                    String mess = "INOT"+(position+1) + "OFF";
                    sms.sendTextMessage(number, null, mess, null, null);
                    pubnub.publish(PubnubKeys.CHANNEL_NAME, mess , callback);
                    ImageAdapter.thumb[position] = ImageAdapter.mThumbIds[0];
                    imageView.setImageResource(ImageAdapter.mThumbIds[0]);
                    Toast.makeText(getActivity(), "SMS Sent: "+mess, Toast.LENGTH_LONG).show();
                }else if(number!=null) {
                    ImageView imageView = (ImageView) view;
                    prompt = "Bulb " + (position+1) + " is On";
                    String mess = "INOT"+(position+1) + "ON";
                    pubnub.publish(PubnubKeys.CHANNEL_NAME, mess , callback);
                   sms.sendTextMessage(number, null, mess, null, null);
                    ImageAdapter.thumb[position] = ImageAdapter.mThumbIds[1];
                    imageView.setImageResource(ImageAdapter.mThumbIds[1]);
                    Toast.makeText(getActivity(), "SMS Sent: "+mess, Toast.LENGTH_LONG).show();
                }
                else {
                    prompt = "Enter Number";
                }
                Toast.makeText(getActivity().getApplicationContext(), prompt,Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
