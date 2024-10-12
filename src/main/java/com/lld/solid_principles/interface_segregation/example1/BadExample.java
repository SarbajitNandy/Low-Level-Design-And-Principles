package com.lld.solid_principles.interface_segregation.example1;

/**
 * code should not be forced to depend on methods it doesn't use
 * breaks the large interfaces to smaller and more specific interfaces
 * create task specific interfaces.
 */

interface Store {
    void save();
    void update();
    void delete();
    void fetch();

    // interface needs to be updated with extra operations
    void AddKey();
    void RemoveKey();
    void Evict();
}

class CacheStore implements Store {
    // For cache store, save, update, remove and fetch are not even needed
    // so, this is violating the ISP

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void fetch() {

    }
    // a requirement came to add features for AddKey, RemoveKey and Evict.

    @Override
    public void AddKey() {

    }

    @Override
    public void RemoveKey() {

    }

    @Override
    public void Evict() {

    }


}

public class BadExample {
}
