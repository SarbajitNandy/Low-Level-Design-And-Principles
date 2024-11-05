package com.lld.design_patterns.observer;

import java.util.List;

public interface Subject {
    void registerSubscriber(Observer o);
    void removeSubscriber(Observer o);
    void notifyAllSubscriber();
}
