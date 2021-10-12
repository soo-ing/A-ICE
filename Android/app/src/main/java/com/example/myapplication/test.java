package com.example.myapplication;

public class test {
    private static String temp1;
    private static String humi1;
    private static String weather;
    private static String roadstate;


    //
    public static String getRoad(){
        return roadstate;
    }
    public void setRoad(String roadstate){
        this.roadstate=roadstate;
    }
    public static String getTemp1() {
        return temp1;
    }
    public void setTemp1(String temp1) {
        this.temp1=temp1;
    }

    //
    public static String getHumi1() {
        return humi1;
    }
    public void setHumi1(String humi1) {
        this.humi1=humi1;
    }

    public static String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather=weather;
    }


}