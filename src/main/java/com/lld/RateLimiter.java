package com.lld;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {
    public int REQUEST_LIMIT = 100;
    public Long TIME_LIMIT = 1000L;
    public class HitCounter {
        public Queue<Long> queue;
        public HitCounter() {
            queue = new LinkedList<>();
        }
        public boolean hit(long timestamp) {
            /* when a timestamp hit, we should poll all the timestamp before TIME_LIMIT*/
            while (!queue.isEmpty() && queue.peek() - timestamp >= TIME_LIMIT) queue.poll();
            if (queue.size() < REQUEST_LIMIT) {
                queue.add(timestamp); return true;
            }
            return false;
        }
    }
    public HashMap<String, HitCounter> clientTimeStampMap = new HashMap<>();
    public boolean isAllow(String clientId) {
        long currTime = System.currentTimeMillis();
        if (!clientTimeStampMap.containsKey(clientId)) {
            HitCounter h = new HitCounter();
            h.hit(currTime); return true;
        } else {
            HitCounter h = clientTimeStampMap.get(clientId);
            return h.hit(currTime);
        }
    }

}