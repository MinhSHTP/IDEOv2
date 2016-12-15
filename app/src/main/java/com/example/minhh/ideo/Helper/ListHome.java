package com.example.minhh.ideo.Helper;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minhh.ideo.R;

import java.util.ArrayList;

/**
 * Created by minhh on 12/1/2016.
 */

public class ListHome extends ArrayAdapter<String>{
    Activity mContext;
    String[] mNameSport;
    int[] mImage;

    public ListHome(Activity context, String[] nameSport, int[] image) {
        super(context, R.layout.listview, nameSport);
        mContext = context;
        mNameSport = nameSport;
        mImage = image;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview, null, true);
        TextView txt = (TextView) rowView.findViewById(R.id.txt);
        ImageView img = (ImageView) rowView.findViewById(R.id.img);
        txt.setText(mNameSport[pos]);
        img.setImageResource(mImage[pos]);
        return rowView;
    }
}
