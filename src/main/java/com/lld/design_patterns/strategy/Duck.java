package com.lld.design_patterns.strategy;

public abstract class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public void display() {
        System.out.println("I am just a Duck");
    }

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performSpeak() {
        quackBehaviour.quack();
    }
}
