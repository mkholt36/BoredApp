package com.example.mholt2587.boredapp.ui;

import java.util.ArrayList;

/**
 * Created by mholt2587 on 4/17/2018.
 */

public class Trail {
    private String city;
    private String state;
    private String country;
    private String name;
    private String unique_id;
    private double lat;
    private double lon;
    private ArrayList<String> activity = new ArrayList<>();


    public Trail(String city, String state, String country, String name, String unique_id, double lat, double lon, ArrayList<String> activity){
        this.city = city;
        this.state = state;
        this.country = country;
        this.name = name;
        this.unique_id = unique_id;
        this.lat = lat;
        this.lon = lon;
        this.activity = activity;

    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public ArrayList<String> getActivity() {
        return activity;
    }
}
