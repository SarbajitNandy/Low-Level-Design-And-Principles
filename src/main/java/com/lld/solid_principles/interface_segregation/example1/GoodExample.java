package com.lld.solid_principles.interface_segregation.example1;

// prepare two stores

interface DBStore {
    void save();
    void update();
    void delete();
    void fetch();
}

interface CacheStore2 {
    void AddKey();
    void RemoveKey();
    void Evict();
}

public class GoodExample {
}
