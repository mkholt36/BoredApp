package com.example.mholt2587.boredapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.mholt2587.boredapp.R;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class OutdoorsButtonActivity extends AppCompatActivity{
    public static final String TAG = OutdoorsButtonActivity.class.getSimpleName();

    private ListView mListView;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoors);
        GPSTracker gps;
        mContext = this;

        mListView = (ListView) findViewById(R.id.list_view);

        double latitude = 40.015;
        double longitude = -105.271;
        double radius = 25;

        gps = new GPSTracker(mContext, OutdoorsButtonActivity.this);
        if (gps.canGetLocation()){
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
        }
        else {
            gps.showSettingsAlert();
        }

        final String trailUrl = "https://trailapi-trailapi.p.mashape.com/?lat=" + latitude + "&limit=25&lon=" + longitude + "&radius=" + radius;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(trailUrl)
                .header("X-Mashape-Key", "WJoTMkfKoSmshRBT8SZKN0YPT7Nsp17UOmjjsneS67kZa1Kt1U")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {


            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "failure");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    final String jsonData = response.body().string();
                    Log.v(TAG, "THIS IS MY JSONDATA " + jsonData);

                    if (response.isSuccessful()) {
                        Log.d(TAG, trailUrl);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    getCurrentDetails(jsonData);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });


                        Log.v(TAG, jsonData);

                    }
                }
                catch (IOException e) {
                    Log.e(TAG, "Exception caught: ", e);
                }
            }
        });

        Log.d(TAG, "Main UI code is running!");
    }


    private void getCurrentDetails(String jsonData) throws JSONException{

        JSONObject mashapeJSON = new JSONObject(jsonData);
        JSONArray placesJSON = mashapeJSON.getJSONArray("places");
        Trail[] trails = new Trail[placesJSON.length()];
        for (int i = 0; i < placesJSON.length(); i++) {
            JSONObject trailJSON = placesJSON.getJSONObject(i);

            String city = trailJSON.getString("city");
            String state = trailJSON.getString("state");
            String country = trailJSON.getString("country");
            String name = trailJSON.getString("name");
            String unique_id = trailJSON.getString("unique_id");
            double lat = trailJSON.getDouble("lat");
            double lon = trailJSON.getDouble("lon");
            ArrayList<String> activity = new ArrayList<>();
            JSONArray activityJSON = trailJSON.getJSONArray("activities");

            for (int y = 0; y < activityJSON.length(); y++) {
                activity.add(activityJSON.getJSONObject(y).getString("activity_type_name"));
            }


            Trail trail = new Trail(city, state, country, name, unique_id, lat, lon, activity);
            trails[i] = trail;
        }

        TrailAdapter adapter = new TrailAdapter(this, trails);
        mListView.setAdapter(adapter);

        for (int i = 0; i < placesJSON.length(); i++){
            Log.d(TAG, trails[i].getCity());
            Log.d(TAG, trails[i].getState());
            Log.d(TAG, trails[i].getCountry());
            Log.d(TAG, trails[i].getName());
            Log.d(TAG, trails[i].getUnique_id());
            Log.d(TAG, String.valueOf(trails[i].getLat()));
            Log.d(TAG, String.valueOf(trails[i].getLon()));
            Log.d(TAG, String.valueOf(trails[i].getActivity()));

        }

    }
}

