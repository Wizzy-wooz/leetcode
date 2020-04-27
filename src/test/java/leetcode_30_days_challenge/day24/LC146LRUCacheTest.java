package leetcode_30_days_challenge.day24;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC146LRUCacheTest {
    private LC146LRUCache cache;

    public LC146LRUCacheTest() {
        this.cache = new LC146LRUCache(2);
    }

    @Test
    public void testCacheStartsEmpty() {
        assertEquals(cache.get(1), -1);
    }

    @Test
    public void testSetBelowCapacity() {
        cache.put(1, 1);
        assertEquals(cache.get(1), 1);
        assertEquals(cache.get(2), -1);
        cache.put(2, 4);
        assertEquals(cache.get(1), 1);
        assertEquals(cache.get(2), 4);
    }

    @Test
    public void testCapacityReachedOldestRemoved() {
        cache.put(1, 1);
        cache.put(2, 4);
        cache.put(3, 9);
        assertEquals(cache.get(1), -1);
        assertEquals(cache.get(2), 4);
        assertEquals(cache.get(3), 9);
    }

    @Test
    public void testGetRenewsEntry() {
        cache.put(1, 1);
        cache.put(2, 4);
        assertEquals(cache.get(1), 1);
        cache.put(3, 9);
        assertEquals(cache.get(1), 1);
        assertEquals(cache.get(2), -1);
        assertEquals(cache.get(3), 9);
    }
}