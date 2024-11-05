package com.lld.design_patterns.strategy;

public class FlyNoWay implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
