package com.example.mholt2587.boredapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "OkHCf4HExwOWu_BTa2P3QLyOEOeWMj040H2u7Fgi-d7m-CYyPyEoaet-QKfRgFJy_Ai31KNdKu_ke25XEy6dzAb6fu-A9cNn8RwftomjYE-xbgy9XoSk_BVmXiTEWXYx";

        String yelpUrl = "https://api.yelp.com/v3/businesses/search";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(yelpUrl).build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                Log.v(TAG, response.body().string());
            }
        } catch (IOException e) {
            Log.e(TAG, "Exception caught: ", e);
        }


    }


}
