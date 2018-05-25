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
        else if(eventPicture.equals("broadway_tickets_national")){
            Picasso.with(mContext).load("https://theimpactnews.com/wp-content/uploads/2018/04/broadway-show.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("music_festival")){
            Picasso.with(mContext).load("https://studybreaks.com/wp-content/uploads/2018/03/music-festivals.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("mlb")){
            Picasso.with(mContext).load("http://images.performgroup.com/di/library/omnisport/69/57/world-series-game-7_gp6k13szyy311ccdiu87vcvkf.jpg?t=-1825695969&w=960&quality=70").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("comedy")){
            Picasso.with(mContext).load("https://stscsport.co.uk/courtside/wp-content/uploads/2018/04/sutton-comedy.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("minor_league_baseball")){
            Picasso.with(mContext).load("https://storage.googleapis.com/afs-prod/media/media:b3d5e6526b004054930a58567e12d7f2/800.jpeg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("soccer")){
            Picasso.with(mContext).load("https://nevadapreps.com/wp-content/uploads/2017/08/9141785_web1_thinkstockphotos-497466485.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else if(eventPicture.equals("dance_performance_tour")){
            Picasso.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/8/8b/Bend_and_Snap%2C_contemporary_dance_performance_at_Nazareth_College_Arts_Center%2C_Rochester%2C_New_York_-_20090925.jpg").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }
        else{
            Picasso.with(mContext).load("https://springintocorrimal.com.au/wp-content/uploads/2016/09/entertainment2.png").placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        }

        return rowView;
    }





}
