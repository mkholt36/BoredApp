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

public class EventAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private CurrentEvents[] mDataSource;

    public EventAdapter(Context context, CurrentEvents[] items) {
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
        View rowView = mInflater.inflate(R.layout.list_item_event, parent, false);

        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(R.id.event_list_title);

        // Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(R.id.event_list_subtitle);

        // Get subtitle2 element
        TextView subtitle2TextView =
                (TextView) rowView.findViewById(R.id.event_list_subtitle2);

        // Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(R.id.event_list_detail);

        // Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(R.id.event_list_thumbnail);

        // 1
        CurrentEvents currentevent = (CurrentEvents) getItem(position);

        // 2
        titleTextView.setText(currentevent.getTitle());
        subtitleTextView.setText(currentevent.getAddress());
        subtitle2TextView.setText(currentevent.getExtended_address());
        detailTextView.setText(currentevent.getType());


        // 3
        Log.d("Test!",currentevent.getImage());
        //Picasso.with(mContext).load("https://chairnerd.global.ssl.fastly.net/images/performers-landscape/boris-b7d3a8/10411/huge.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        String eventPicture = String.valueOf(currentevent.getType());

        if(eventPicture.equals("concert")){
            Picasso.with(mContext).load("https://odysseyonline-img.rbl.ms/simage/https%3A%2F%2Fassets.rbl.ms%2F10580057%2F980x.jpg/2000%2C2000/zFZFeZ%2FxEbfpy14n/img.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("classical_orchestral_instrumental")){
            Picasso.with(mContext).load("https://www.seattlesymphony.org/~/media/images/landing%20page%20banner%20880x385/1415_abouttheseattlesymphony_banner.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("family")){
            Picasso.with(mContext).load("http://grandmother.info/wp-content/uploads/how-does-your-city-rate-on-the-family-friendly-index-family-friendly.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("theater")){
            Picasso.with(mContext).load("https://www.michaans.com/img/highlights/page/theaterscan_01.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("band")){
            Picasso.with(mContext).load("https://www.shoemakerjukebox.com/sites/www.shoemakerjukebox.com/files/hire-Live-Band.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else{
            Picasso.with(mContext).load("http://images.bwog.com/wp-content/uploads/2015/09/shutterstock_92569492.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }

        /*if(activityPicture.equals("[hiking]")){
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
        }*/

        return rowView;
    }





}
