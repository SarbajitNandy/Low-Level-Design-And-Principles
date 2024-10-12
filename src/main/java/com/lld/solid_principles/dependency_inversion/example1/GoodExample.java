package com.lld.solid_principles.dependency_inversion.example1;

interface ICacheStore {
    void addKey(String key, String value);
    void removeKey(String key);
    void evict(String key);
}
class CacheStore2 implements ICacheStore {
    public void addKey(String key, String value) {
        //
    }

    public void removeKey(String key) {
        //
    }

    public void evict(String key) {
        //
    }
}

class UserProfile2 {
    public void run() {
        ICacheStore cacheStore = new CacheStore2();

        cacheStore.addKey("result", "123");
    }
}

/**
 * now here, it's depending upon an abstraction.
 * Who ever wants to change the implementation or the caching technology, the just need to ensure the signature interface is followed.
 * No extra testing effort is needed for User Profile Service
 */

public class GoodExample {
}
