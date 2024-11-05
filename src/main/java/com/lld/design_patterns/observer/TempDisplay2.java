package com.lld.design_patterns.observer;

public class TempDisplay2 implements DisplayEntity, Observer{
    @Override
    public void display(Double temp) {
        System.out.println("Display 2 : New updated temperature is " + temp);
    }

    @Override
    public void update(double value) {
        display(value);
    }
}
