package com.lld.design_patterns.observer;
 
public class WeatherApp {
    public static void main(String[] args) throws InterruptedException {
        WeatherData data  =  new WeatherData();
        DisplayEntity dp1 = new TempDisplay1();
        DisplayEntity dp2 = new TempDisplay2();

        data.registerSubscriber(( Observer) dp1);
        data.registerSubscriber(( Observer) dp2);

        for(int i= 0;i<10;i++) {
            data.onChange((double) i);
            Thread.sleep(1000);
        }
    }
}
