package com.lld.multiThreadedPubSub;
public interface Subscriber {
    void onMessage(String topic, String message);
}