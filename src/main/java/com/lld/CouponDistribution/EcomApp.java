package com.lld.CouponDistribution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class EcomApp {

    Map<User, Integer> users;
    LinkedList<User> queue;

    public EcomApp() {
        this.users = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    void addInQueue(User user) {
        queue.addFirst(user);
    }

    boolean deleteFromQueue(User user) {
        return queue.remove(user);
    }

    public void visited(User user) {
        int freq = users.getOrDefault(user, 0);

        if (freq==1) {
            deleteFromQueue(user);
        } else if (freq==0) {
            addInQueue(user);
        }
        users.put(user, freq+1);


    }

    public List<User> issueCoupon() {
        return List.of(queue.getFirst());
    }
}
