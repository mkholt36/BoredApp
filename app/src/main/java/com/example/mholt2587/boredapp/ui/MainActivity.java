package com.example.mholt2587.boredapp.ui;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mholt2587.boredapp.R;
import static android.R.id.message;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    ConstraintLayout background;
    Button randomButton, buttonSports, buttonYelp, buttonFacebook, buttonOutdoors, buttonMarkets, buttonPPR, buttonFairs;



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

    //when the random button is clicked, the user will be taken to a new screen specific to the random button
    public void sendMessage(View view){
        Intent startNewActivity = new Intent(this, StoryActivity.class);
        startNewActivity.putExtra(EXTRA_MESSAGE, message);
        startActivity(startNewActivity);
    }

    //when the sports button is clicked, the user will be taken to a new screen specific to the sports button
    public void sportsMessage (View view) {
        Intent sportsButton = new Intent(this, SportsButtonActivity.class);
        sportsButton.putExtra(EXTRA_MESSAGE, message);
        startActivity(sportsButton);
    }

    //when the fairs button is clicked user will be taken to a new screen specific to the fairs button
    public void fairsMessage(View view){
        Intent fairsButton = new Intent(this, FairsButtonActivity.class);
        fairsButton.putExtra(EXTRA_MESSAGE, message);
        startActivity(fairsButton);
    }

    //yelp button clicked to new screen
    public void yelpMessage(View view){
        Intent yelpButton = new Intent(this, YelpButtonActivity.class);
        yelpButton.putExtra(EXTRA_MESSAGE, message);
        startActivity(yelpButton);
    }

    //outdoors button clicked to new screen
    public void outdoorsMessage(View view){
        Intent outdoorsButton = new Intent(this, OutdoorsButtonActivity.class);
        outdoorsButton.putExtra(EXTRA_MESSAGE, message);
        startActivity(outdoorsButton);
    }

    //facebook button clicked to new screen
    public void facebookMessage(View view){
        Intent facebookButton = new Intent(this, FacebookButtonActivity.class);
        facebookButton.putExtra(EXTRA_MESSAGE, message);
        startActivity(facebookButton);
    }

    //markets button to new page
    public void marketsMessage(View view){
        Intent marketsButton = new Intent(this, MarketsButtonActivity.class);
        marketsButton.putExtra(EXTRA_MESSAGE, message);
        startActivity(marketsButton);
    }

    //ppr button to new Screen
    public void pprMessage(View view){
        Intent pprButton = new Intent(this, PPRButtonActivity.class);
        pprButton.putExtra(EXTRA_MESSAGE, message);
        startActivity(pprButton);
    }








}
