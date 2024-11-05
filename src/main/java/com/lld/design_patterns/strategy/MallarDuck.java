package com.lld.design_patterns.strategy;

public class MallarDuck extends Duck{
    MallarDuck() {
        this.flyBehaviour = new FlyWithWings();
        this.quackBehaviour = new Squack();
    }

    @Override
    public void display() {
        System.out.println("I am a mallard duck");
    }
}
