package com.example.saikrishna.bulb;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by SaiKrishna on 8/15/2016.
 */
public class OfPickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    TextView oftv,oftev;

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        oftv = (TextView) getActivity().findViewById(R.id.sofet);
        oftev = (TextView) getActivity().findViewById(R.id.offtime);

        oftv.setText(String.valueOf(hourOfDay) + "::" + String.valueOf(minute));
        oftev.setText(String.valueOf(hourOfDay)+ String.valueOf(minute));
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //Create and return a new instance of TimePickerDialog
        return new TimePickerDialog(getActivity(),this,hour,minute,
                DateFormat.is24HourFormat(getActivity()));
    }
}
