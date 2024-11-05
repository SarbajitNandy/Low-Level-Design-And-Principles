package com.lld.design_patterns.strategy;

public class MuteQuack implements QuackBehaviour {

    public void quack() {
        System.out.println("<<silence>>");
    }
}

