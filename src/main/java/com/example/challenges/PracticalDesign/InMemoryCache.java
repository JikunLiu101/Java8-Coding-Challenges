package com.example.challenges.PracticalDesign;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache {
    String key;
    String field;
    String value;
    Long ttl;

    InMemoryCache(String key, String field, String value, Long ttl) {
        this.key = key;
        this.field = field;
        this.value = value;
        this.ttl = (ttl == null || ttl <=0) ? Long.MAX_VALUE : System.currentTimeMillis() + ttl;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > ttl;
    }

    @Override
    public String toString() {
        return "CacheEntry{" +
                "key='" + key + '\'' +
                ", field='" + field + '\'' +
                ", value='" + value + '\'' +
                ", ttl=" + ttl +
                '}';
    }

    // Use ConcurrentHashMap for thread-safe operations
    private Map<String, InMemoryCache> cache = new ConcurrentHashMap<>();

    private String compositeKey(String key, String field){
        return key + "::" + field;
    }

    public void init(){
        cache.clear();
    }

    public Object add(String key, String field, String value, Long ttl) {
        if (key == null || field == null || value == null) {
            return "Error: Key, field, and value must not be null";
        }
        String composite = compositeKey(key, field);
        InMemoryCache existing = cache.get(composite);

        if (existing != null && !existing.isExpired()) {
            return false; // already exists and not expired
        }
        InMemoryCache entry = new InMemoryCache(key, field, value, ttl);
        cache.put(composite, entry);
        return entry.toString();
    }

    public Object remove(String key, String field){
        if (key == null || field == null) {
            return "Error: Key and field must not be null";
        }
        String composite = compositeKey(key, field);
        InMemoryCache existing = cache.get(composite);

        if (existing == null || existing.isExpired()) {
            return false;
        }
        cache.remove(composite);
        return existing;
    }

    public Object update(String key, String field, String value, Long ttl){
        if (key == null || field == null || value == null) {
            return "Error: Key, field, and value must not be null";
        }
        String composite = compositeKey(key, field);
        InMemoryCache existing = cache.get(composite);
        if (existing == null || existing.isExpired()) {
            return false;
        }

        existing.value = value;
        existing.ttl = (ttl == null || ttl <=0) ? Long.MAX_VALUE : System.currentTimeMillis() + ttl;
        return existing;
    }

    public Object get(String key, String field) {
        String composite = compositeKey(key, field);
        InMemoryCache existing = cache.get(composite);

        if (existing == null || existing.isExpired()) {
            cache.remove(composite);
            return false;
        }
        return existing;
    }
}
