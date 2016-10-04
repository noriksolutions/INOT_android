package com.example.saikrishna.bulb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by SaiKrishna on 8/11/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context myContext;

    public ImageAdapter(Context applicationContext) {
        myContext = applicationContext;
    }

    @Override
    public int getCount() {
        return thumb.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(myContext);
        iv.setLayoutParams(new GridView.LayoutParams(155, 155));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setPadding(8,8,8,8);
        iv.setImageResource(thumb[position]);
        return iv;
    }

    public static Integer[] mThumbIds = {
            R.drawable.bulb1, R.drawable.bulb2
    };


    public static Integer[] thumb = {
            R.drawable.bulb1,
            R.drawable.bulb1,
            R.drawable.bulb1,
            R.drawable.bulb1,
            R.drawable.bulb1,
            R.drawable.bulb1,
            R.drawable.bulb1,
            R.drawable.bulb1,
            R.drawable.bulb1,
            R.drawable.bulb1
    };
}