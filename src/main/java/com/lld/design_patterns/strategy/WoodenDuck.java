package com.lld.design_patterns.strategy;

public class WoodenDuck extends Duck{
    WoodenDuck() {
        this.flyBehaviour = new FlyNoWay();
        this.quackBehaviour = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I am a wooden duck");
    }
}
