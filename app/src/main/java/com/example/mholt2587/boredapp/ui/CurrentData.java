package com.example.mholt2587.boredapp.ui;

public class CurrentData {


    private String fullName;
    private String location;
    private String url;
    private String image;

    public CurrentData(String fullName, String location, String url, String image){


        this.fullName = fullName;
        this.location = location;
        this.url = url;
        this.image = image;

    }



    public String getFullName(){
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl(){
        return url;
    }

    public String getImage(){
        return image;
    }

}
