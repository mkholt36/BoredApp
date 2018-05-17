package com.example.mholt2587.boredapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mholt2587.boredapp.R;
import com.squareup.picasso.Picasso;

/**
 * Created by mholt2587 on 4/17/2018.
 */

public class TrailAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private Trail[] mDataSource;

    public TrailAdapter(Context context, Trail[] items){
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.length;
    }

    @Override
    public Object getItem(int position) {
        return mDataSource[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_trail, parent, false);
        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(R.id.trail_list_title);

// Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(R.id.trail_list_subtitle);

        TextView subtitle2TextView =
                (TextView) rowView.findViewById(R.id.trail_list_subtitle2);

        TextView latitudeTextView = (TextView) rowView.findViewById(R.id.trail_list_latitude);

        TextView longitudeTextView = (TextView) rowView.findViewById(R.id.trail_list_longitude);

// Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(R.id.trail_list_detail);

// Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(R.id.trail_list_thumbnail);

        Trail trail = (Trail) getItem(position);

        titleTextView.setText(trail.getName());
        subtitleTextView.setText(trail.getCity());
        subtitle2TextView.setText(trail.getState());
        latitudeTextView.setText(String.valueOf(trail.getLat()));
        longitudeTextView.setText(String.valueOf(trail.getLon()));
        detailTextView.setText(String.valueOf(trail.getActivity()));

        String activityPicture = String.valueOf(trail.getActivity());

        if(activityPicture.equals("[hiking]")){
            Picasso.with(mContext).load(R.mipmap.hiking).into(thumbnailImageView);
        }
        else if(activityPicture.equals("[mountain biking]")){
            Picasso.with(mContext).load(R.mipmap.mountain_biking).into(thumbnailImageView);
        }
        else if(activityPicture.equals("[snow sports]")){
            Picasso.with(mContext).load(R.mipmap.snow_sports).into(thumbnailImageView);
        }
        else if(activityPicture.equals("[mountain biking, hiking]")){
            Picasso.with(mContext).load(R.mipmap.hiking).into(thumbnailImageView);
        }
        else {
            Picasso.with(mContext).load(R.mipmap.multiple_activities).into(thumbnailImageView);
        }



        return rowView;
    }
}
