package com.lld.design_patterns.strategy;

public class FlyWithWings implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("I have wings to fly");
    }
}
