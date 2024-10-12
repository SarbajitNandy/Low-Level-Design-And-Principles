package com.lld.solid_principles.dependency_inversion.example1;

/**
 * high level modules should not depend on low level modules
 * Both should depend on Abstractions
 * Implementation should depend on Abstractions
 *
 */

class CacheStore {
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

class UserProfile {
    public void run() {
        CacheStore cacheStore = new CacheStore();

        cacheStore.addKey("result", "123");
    }
}

/**
 * In the above cases, the UserProfile is tightly dependent on Cache store class.
 * Any change in implementation for caching will force User Profile class to retest its functionality.
 * Hence it's violating the DIP
 */

public class BadExample {
}
