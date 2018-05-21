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
 * Created by mholt2587 on 2/13/2018.
 */

public class PoolAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private Pool[] mDataSource;

    public PoolAdapter(Context context, Pool[] items){
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
        View rowView = mInflater.inflate(R.layout.list_item_pools, parent, false);
        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(R.id.pools_list_title);

// Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(R.id.pools_list_subtitle);

// Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(R.id.pools_list_detail);

// Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(R.id.pools_list_thumbnail);

        Pool pool = (Pool) getItem(position);

        titleTextView.setText(pool.getName());
        subtitleTextView.setText(String.valueOf(pool.getAddress()));
        detailTextView.setText(pool.getPhone());

        Picasso.with(mContext).load(pool.getImageUrl()).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        return rowView;
    }
}

