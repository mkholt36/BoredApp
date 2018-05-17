package com.example.mholt2587.boredapp.ui;

public class CurrentData {

    private String title;
    private String location;
    private String frequency;
    private String startDate;
    private String endDate;
    private String time;
    private String image;

    public CurrentData(String title, String location, String frequency, String endDate, String startDate, String time, String image){
        this.title = title;
        this.location = location;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.image = image;

    }

    public String getTitle() {
        return title;
    }

    public String getImage() {return image;}

    public String getLocation() {
        return location;
    }

    public String getFrequency() { return frequency;}

    public String getStartDate() {return startDate;}

    public String getEndDate() {return endDate;}

    public String getTime() {
        return time;
    }


}
