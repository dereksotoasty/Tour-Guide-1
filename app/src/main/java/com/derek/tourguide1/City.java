package com.derek.tourguide1;

/**
 * Created by Derek on 2016-10-13.
 */

public class City {
    private String cityName;
    private int id;

    public City(String city, int uId){
        cityName = city;
        id = uId;
    }

    public void setCityName(String city){
        cityName = city;
    }

    public void setId(int uId){
        id = uId;
    }

    public String getCityName(){
        return cityName;
    }

    public int getId(){
        return id;
    }
}
