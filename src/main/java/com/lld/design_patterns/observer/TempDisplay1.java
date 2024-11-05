package com.lld.design_patterns.observer;

public class TempDisplay1 implements DisplayEntity, Observer{
    @Override
    public void display(Double temp) {
        System.out.println("Display 1 : New updated temperature is " + temp);
    }

    @Override
    public void update(double value) {
        display(value);
    }
}
