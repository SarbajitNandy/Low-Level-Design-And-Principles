package com.lld.multiThreadedPubSub;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Topic {
    private final String name;
    private final BlockingQueue<String> messages = new LinkedBlockingQueue<>();
    private final List<Subscriber> subscribers = new CopyOnWriteArrayList<>();

    public Topic(String name) {
        this.name = name;
        startDispatcher();
    }

    public void publish(String message) {
        messages.offer(message);
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    private void startDispatcher() {
        Thread dispatcher = new Thread(() -> {
            try {
                while (true) {
                    String message = messages.take();
                    for (Subscriber subscriber : subscribers) {
                        subscriber.onMessage(name, message);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        dispatcher.setDaemon(true);
        dispatcher.start();
    }
}