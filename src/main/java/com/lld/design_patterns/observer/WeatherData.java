package com.lld.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    List<Observer> observerList;

    double temperature;

    public WeatherData() {
        this.observerList = new ArrayList<>(10);
        temperature = 0d;
    }

    @Override
    public void registerSubscriber(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void removeSubscriber(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyAllSubscriber() {
        System.out.println("Notifying all observers");

        for(Observer obs : observerList) {
            obs.update(this.temperature);
        };

        System.out.println("All observers are notified.");
    }

    public void onChange(double newTemp) {
        System.out.println("New weather data has been fetched");
        System.out.println("Weather temperature : " + newTemp);

        this.temperature = newTemp;

        notifyAllSubscriber();
    }
}
