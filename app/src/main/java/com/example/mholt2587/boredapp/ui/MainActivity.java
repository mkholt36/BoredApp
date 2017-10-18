package com.example.mholt2587.boredapp.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mholt2587.boredapp.R;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout background;
    Button randomButton, buttonSports, buttonYelp, buttonFacebook, buttonOutdoors, buttonMarkets, buttonPPR, buttonFairs;


    public void sendMessage(View view){
        Intent startNewActivity = new Intent(this, StoryActivity.class);
        startActivity(startNewActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = (ConstraintLayout) findViewById(R.id.background);
        randomButton = (Button) findViewById(R.id.randomButton);
        buttonSports = (Button) findViewById(R.id.buttonSports);
        buttonFacebook = (Button) findViewById(R.id.buttonFacebook);
        buttonYelp = (Button) findViewById(R.id.buttonYelp);
        buttonOutdoors = (Button) findViewById(R.id.buttonOutdoors);
        buttonMarkets = (Button) findViewById(R.id.buttonMarkets);
        buttonPPR = (Button) findViewById(R.id.buttonPPR);
        buttonFairs = (Button) findViewById(R.id.buttonFairs);

        randomButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                //click button code here
                //go to next page...
               // sendMessage();
                background.setBackgroundColor(Color.parseColor("#00ff00"));

                }

        });

        buttonSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click button code here
                //go to next page...
                background.setBackgroundColor(Color.parseColor("#0000ff"));
            }

        });

        buttonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click button code here
                //go to next page...
                background.setBackgroundColor(Color.parseColor("#ff0000"));
            }

        });

        buttonYelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click button code here
                //go to next page...
            }

        });

        buttonOutdoors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click button code here
                //go to next page...
            }

        });

        buttonMarkets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click button code here
                //go to next page...
            }

        });

        buttonPPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click button code here
                //go to next page...
            }

        });

        buttonFairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click button code here
                //go to next page...
            }

        });






 /*       String apiKey = "OkHCf4HExwOWu_BTa2P3QLyOEOeWMj040H2u7Fgi-d7m-CYyPyEoaet-QKfRgFJy_Ai31KNdKu_ke25XEy6dzAb6fu-A9cNn8RwftomjYE-xbgy9XoSk_BVmXiTEWXYx";

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
        }*/


    }


}
