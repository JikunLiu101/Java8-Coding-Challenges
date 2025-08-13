package com.example.challenges.InMemoryCache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryCacheTest {

    private InMemoryCache cache;

    @BeforeEach
    void setUp() {
        cache = new InMemoryCache(null, null, null, null);
        cache.init();
    }

    @Test
    void testAddAndGetForeverTTL() {
        Object added = cache.add("user1", "name", "Alice", null);
        assertTrue(added.toString().contains("Alice"));

        Object retrieved = cache.get("user1", "name");
        assertTrue(retrieved.toString().contains("Alice"));
    }

    @Test
    void testAddDuplicateReturnsFalse() {
        cache.add("user1", "name", "Alice", null);
        Object result = cache.add("user1", "name", "Alice", null);
        assertEquals(false, result);
    }

    @Test
    void testGetExpiredEntry() throws InterruptedException {
        cache.add("user2", "role", "admin", 200L); // TTL = 200 ms
        Thread.sleep(250); // wait until expired
        Object result = cache.get("user2", "role");
        assertEquals(false, result);
    }

    @Test
    void testUpdateExistingEntry() {
        cache.add("user3", "age", "25", null);
        Object updated = cache.update("user3", "age", "26", 1000L);
        assertTrue(updated.toString().contains("26"));

        Object retrieved = cache.get("user3", "age");
        assertTrue(retrieved.toString().contains("26"));
    }

    @Test
    void testUpdateNonExistentReturnsFalse() {
        Object result = cache.update("noUser", "noField", "val", 1000L);
        assertEquals(false, result);
    }

    @Test
    void testRemoveExistingEntry() {
        cache.add("user4", "status", "active", null);
        Object removed = cache.remove("user4", "status");
        System.out.println(removed.toString());
        assertTrue(removed.toString().contains("active"));

        Object retrieved = cache.get("user4", "status");
        assertEquals(false, retrieved);
    }

    @Test
    void testRemoveNonExistentReturnsFalse() {
        Object result = cache.remove("noUser", "noField");
        assertEquals(false, result);
    }

    @Test
    void testInitClearsCache() {
        cache.add("user5", "lang", "Java", null);
        cache.init();
        assertEquals(false, cache.get("user5", "lang"));
    }
}
