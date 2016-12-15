package com.example.minhh.ideo.Helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minhh.ideo.R;

import java.util.ArrayList;

/**
 * Created by minhh on 11/23/2016.
 */

public class GridHome extends BaseAdapter {
    String[] result;
    Context context;
    private static LayoutInflater inflater = null;
    static ArrayList<Drawable> mImage = new ArrayList<Drawable>();
    public GridHome(Context mainActivity, String[] prgmNameList, ArrayList<Drawable> image) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        context = mainActivity;
        mImage = image;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.gridview, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textView);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView);

        holder.tv.setText(result[position]);
        holder.img.setImageDrawable(mImage.get(position));

        return rowView;
    }
}
