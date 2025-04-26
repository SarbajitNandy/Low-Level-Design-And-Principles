package com.lld.multiThreadedPubSub;
import java.util.concurrent.ConcurrentHashMap;

public class MessageQueue {
    private final ConcurrentHashMap<String, Topic> topics = new ConcurrentHashMap<>();

    public Topic createTopic(String name) {
        return topics.computeIfAbsent(name, Topic::new);
    }

    public Topic getTopic(String name) {
        return topics.get(name);
    }
}