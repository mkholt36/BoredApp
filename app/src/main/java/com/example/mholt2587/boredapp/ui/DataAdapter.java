package com.example.mholt2587.boredapp.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mholt2587.boredapp.R;
import com.squareup.picasso.Picasso;

public class DataAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private CurrentData[] mDataSource;

    public DataAdapter(Context context, CurrentData[] items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //1
    @Override
    public int getCount() {
        return mDataSource.length;
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource[position];
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_data, parent, false);

        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(R.id.data_list_title);

        // Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(R.id.data_list_subtitle);


        // Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(R.id.data_list_detail);


        // Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(R.id.data_list_thumbnail);

        // 1
        CurrentData currentdata = (CurrentData) getItem(position);

        // 2
        titleTextView.setText(currentdata.getFullName());
        subtitleTextView.setText(currentdata.getUrl());
        detailTextView.setText(currentdata.getLocation());



        // 3 IMAGES
        Log.d("Test!!", currentdata.getImage());
        Picasso.with(mContext).load("https://www.nationalparks.org/sites/default/files/styles/large_list_image_2x/public/shutterstock_142351951.jpg?itok=Jr0mv7SL&timestamp=1474998760").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        return rowView;
    }
}