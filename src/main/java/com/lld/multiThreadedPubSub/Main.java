package com.lld.multiThreadedPubSub;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        MessageQueue queue = new MessageQueue();

        // create topics
        Topic book = queue.createTopic("Books");
        Topic movie = queue.createTopic("Movies");

        // Subscribers
        Subscriber sub1 = new Subscriber() {
            @Override
            public void onMessage(String topicName, String message) {
                System.out.println("Sub1 -> From topic: " + topicName + ": mesage: " + message);
            }
        };
        Subscriber sub2 = new Subscriber() {
            @Override
            public void onMessage(String topicName, String message) {
                System.out.println("Sub2 -> From topic: " + topicName + ": mesage: " + message);
            }
        };


        // register
        book.subscribe(sub1);
        movie.subscribe(sub2);
        movie.subscribe(sub1);

        Publisher pub= new Publisher(queue);

        pub.publish("Books", "Sherlok Holms");
        pub.publish("Books", "Boymkesh");
        pub.publish("Movies", "Grey");

        Thread.sleep(1000);
    }

}
