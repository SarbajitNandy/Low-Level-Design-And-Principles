package com.lld.multiThreadedPubSub;

public class Publisher {
    private final MessageQueue messageQueue;

    public Publisher(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    public void publish(String topicName, String message) {
        Topic topic = messageQueue.getTopic(topicName);
        if (topic != null) {
            topic.publish(message);
        } else {
            System.out.println("Topic not found: " + topicName);
        }
    }
}
