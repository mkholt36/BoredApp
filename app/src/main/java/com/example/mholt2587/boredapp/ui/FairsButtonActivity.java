package com.example.mholt2587.boredapp.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
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

public class FairsButtonActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fairs);

        mlistView = (ListView) findViewById(R.id.list_view);

        String apiKey = "5xJSw2RDDwRYkLIca72pBX3fOlSXGZEjFCLrtSak";

        final String nationalParksUrl = "https://developer.nps.gov/api/v1/events?&api_key=" + apiKey;


        if (isNetworkAvailable()) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(nationalParksUrl)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {

                }

                @Override
                public void onResponse(Response response) throws IOException {
                    try {
                        final String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try{
                                        getCurrentDetails(jsonData);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    Log.d(TAG, "successful response");
                                }
                            });

                        } else {
                            alertUserAboutError();
                        }
                    }
                    catch (IOException e){
                        Log.e(TAG, "Exception caught: ", e);
                    }
                }
            });
            Log.d(TAG, "network available");
        }
        else{
            Toast.makeText(this, getString(R.string.network_unavailable_message),
                    Toast.LENGTH_LONG).show();
            Log.d(TAG, "network unavailable");
        }

        Log.d(TAG, nationalParksUrl);
        Log.d(TAG, "Main UI is running!");
    }

    private void getCurrentDetails(String jsonData) throws JSONException {
        JSONObject parksData = new JSONObject(jsonData);

        JSONArray dataJSON = parksData.getJSONArray("data");
        CurrentData[] currentdatas = new CurrentData[dataJSON.length()];

        String[] titleArray = new String[dataJSON.length()];

        for (int i = 0; i < dataJSON.length(); i++) {
            JSONObject currentdataJSON = dataJSON.getJSONObject(i);

            //get title
            String title = currentdataJSON.getString("title");

            //get location
            String location = currentdataJSON.getString("location");

            //get frequency, startDate, and endDate (from a JSONObject)
            String frequency = currentdataJSON.getJSONObject("recurrence").getString("frequency");
            String startDate = currentdataJSON.getJSONObject("recurrence").getString("startDate");
            String endDate = currentdataJSON.getJSONObject("recurrence").getString("endDate");

            //get time
            String time = currentdataJSON.getString("time");

            String image = "https://www.nationalparks.org/sites/default/files/styles/large_list_image_2x/public/shutterstock_142351951.jpg?itok=Jr0mv7SL&timestamp=1474998760";

            CurrentData currentdata = new CurrentData(title, location, frequency, startDate, endDate, time, image);
            currentdatas[i] = currentdata;
            titleArray[i] = currentdatas[i].getTitle();
        }

        DataAdapter adapter = new DataAdapter(this, currentdatas);
        mlistView.setAdapter(adapter);

        for (int i = 0; i < dataJSON.length(); i++){
            Log.d(TAG, currentdatas[i].getTitle());
            Log.d(TAG, currentdatas[i].getLocation());
            Log.d(TAG, currentdatas[i].getFrequency());
            Log.d(TAG, currentdatas[i].getStartDate());
            Log.d(TAG, currentdatas[i].getEndDate());
            Log.d(TAG, currentdatas[i].getTime());
            Log.d(TAG, currentdatas[i].getImage());
            Log.d(TAG, "here!!");
        }

    } //end of getCurrentDetails method





    private boolean isNetworkAvailable(){
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return isAvailable;
    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }

}
