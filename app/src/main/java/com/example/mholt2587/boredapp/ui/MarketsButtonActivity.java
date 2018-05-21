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


public class MarketsButtonActivity extends AppCompatActivity{
    public static final String TAG = MarketsButtonActivity.class.getSimpleName();
    private ListView mListView;
    GPSTracker gps;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pools);

        mContext = this;

        mListView = (ListView) findViewById(R.id.list_view);

        String term = "pools";
        double latitude = 40.015;
        double longitude = -105.271;

        gps = new GPSTracker(mContext, MarketsButtonActivity.this);
        if (gps.canGetLocation()){
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
        }
        else {
            gps.showSettingsAlert();
        }

        final String yelpUrl = "https://api.yelp.com/v3/businesses/search?term=" + term + "&latitude=" + latitude +  "&longitude=" + longitude;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(yelpUrl)
                .header("Authorization", "Bearer OkHCf4HExwOWu_BTa2P3QLyOEOeWMj040H2u7Fgi-d7m-CYyPyEoaet-QKfRgFJy_Ai31KNdKu_ke25XEy6dzAb6fu-A9cNn8RwftomjYE-xbgy9XoSk_BVmXiTEWXYx")
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
                        Log.d(TAG, yelpUrl);
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



    private void getCurrentDetails(String jsonData) throws JSONException {


        JSONObject yelpJSON = new JSONObject(jsonData);
        JSONArray businessesJSON = yelpJSON.getJSONArray("businesses");
        Pool[] pools  = new Pool[businessesJSON.length()];
        String[] nameArray = new String[businessesJSON.length()];
        for (int i = 0; i < businessesJSON.length(); i++) {
            JSONObject poolJSON = businessesJSON.getJSONObject(i);

            String name = poolJSON.getString("name");
            String phone = poolJSON.optString("display_phone", "Phone not available");
            String website = poolJSON.getString("url");
            double rating = poolJSON.getDouble("rating");


            String imageUrl = poolJSON.getString("image_url");

            double latitude = (double) poolJSON.getJSONObject("coordinates").getDouble("latitude");

            double longitude = (double) poolJSON.getJSONObject("coordinates").getDouble("longitude");

            ArrayList<String> address = new ArrayList<>();
            JSONArray addressJSON = poolJSON.getJSONObject("location")
                    .getJSONArray("display_address");
            for (int y = 0; y < addressJSON.length(); y++) {
                address.add(addressJSON.get(y).toString());
            }

            ArrayList<String> categories = new ArrayList<>();
            JSONArray categoriesJSON = poolJSON.getJSONArray("categories");

            for (int y = 0; y < categoriesJSON.length(); y++) {
                categories.add(categoriesJSON.getJSONObject(y).getString("title"));
            }
            Pool pool = new Pool(name, phone, website, rating, imageUrl,
                    address, latitude, longitude, categories);
            pools[i] = pool;
            nameArray[i] = pools[i].getName();

        }

        PoolAdapter adapter = new PoolAdapter(this, pools);
        mListView.setAdapter(adapter);



        }



    }

