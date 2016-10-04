package com.example.saikrishna.bulb;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by SaiKrishna on 8/15/2016.
 */
public class OnPickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    TextView ontv,ontev;

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        ontv = (TextView) getActivity().findViewById(R.id.soet);
        ontev = (TextView) getActivity().findViewById(R.id.ontime);

        ontv.setText(String.valueOf(hourOfDay) + "::" + String.valueOf(minute));
        ontev.setText(String.valueOf(hourOfDay)+ String.valueOf(minute));
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //Create and return a new instance of TimePickerDialog
        return new TimePickerDialog(getActivity(),this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }
}
