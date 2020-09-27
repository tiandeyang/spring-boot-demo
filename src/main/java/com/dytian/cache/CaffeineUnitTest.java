package com.dytian.cache;

import com.github.benmanes.caffeine.cache.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CaffeineUnitTest {

    @Test
    public void givenCache_whenPopulate_thenValueStored() {


        // 静态变量属于 类;

        Cache<String, DataObject> cache = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).maximumSize(100).build();

        String key = "A";
        DataObject dataObject = cache.getIfPresent(key);

        assertNull(dataObject);

        dataObject = cache.get(key, k -> DataObject.get("Data for A"));


        assertNotNull(dataObject);
        assertEquals("Data for A", dataObject.getData());

        cache.put(key, dataObject);
        dataObject = cache.getIfPresent(key);

        // 内存可见性保证
        // 内存可见性保证

        assertNotNull(dataObject);

        cache.invalidate(key);
        dataObject = cache.getIfPresent(key);

        assertNull(dataObject);
    }

    @Test
    public void givenLoadingCache_whenGet_thenValuePopulated() {
        LoadingCache<String, DataObject> cache = Caffeine.newBuilder().maximumSize(100).expireAfterWrite(1, TimeUnit.MINUTES).build(k -> DataObject.get("Data for " + k));
        String key = "A";

        DataObject dataObject = cache.get(key);

        assertNotNull(dataObject);
        assertEquals("Data for " + key, dataObject.getData());

        Map<String, DataObject> dataObjectMap = cache.getAll(Arrays.asList("A", "B", "C"));

        assertEquals(3, dataObjectMap.size());
    }

    @Test
    public void givenAsyncLoadingCache_whenGet_thenValuePopulated() {

        AsyncLoadingCache<String, DataObject> cache = Caffeine.newBuilder().maximumSize(100).expireAfterWrite(1, TimeUnit.MINUTES).buildAsync(k -> DataObject.get("Data for " + k));
        String key = "A";

        cache.get(key).thenAccept(dataObject -> {
            assertNotNull(dataObject);
            assertEquals("Data for " + key, dataObject.getData());
        });

        cache.getAll(Arrays.asList("A", "B", "C")).thenAccept(dataObjectMap -> assertEquals(3, dataObjectMap.size()));
    }

    @Test
    public void givenLoadingCacheWithSmallSize_whenPut_thenSizeIsConstant() {
        LoadingCache<String, DataObject> cache = Caffeine.newBuilder().maximumSize(1).refreshAfterWrite(10, TimeUnit.MINUTES).build(k -> DataObject.get("Data for " + k));

        assertEquals(0, cache.estimatedSize());

        cache.get("A");

        assertEquals(1, cache.estimatedSize());

        cache.get("B");
        cache.cleanUp();

        assertEquals(1, cache.estimatedSize());
    }

    @Test
    public void givenLoadingCacheWithWeigher_whenPut_thenSizeIsConstant() {
        LoadingCache<String, DataObject> cache = Caffeine.newBuilder().maximumWeight(10).weigher((k, v) -> 5).build(k -> DataObject.get("Data for " + k));

        assertEquals(0, cache.estimatedSize());

        cache.get("A");

        assertEquals(1, cache.estimatedSize());

        cache.get("B");

        assertEquals(2, cache.estimatedSize());

        cache.get("C");
        cache.cleanUp();

        assertEquals(2, cache.estimatedSize());
    }

    @Test
    public void givenTimeEvictionCache_whenTimeLeft_thenValueEvicted() {
        LoadingCache<String, DataObject> cache = Caffeine.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build(k -> DataObject.get("Data for " + k));

        cache = Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).weakKeys().weakValues().build(k -> DataObject.get("Data for " + k));

        cache = Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).softValues().build(k -> DataObject.get("Data for " + k));

        cache = Caffeine.newBuilder().expireAfter(new Expiry<String, DataObject>() {
            @Override
            public long expireAfterCreate(String key, DataObject value, long currentTime) {
                return value.getData().length() * 1000;
            }

            @Override
            public long expireAfterUpdate(String key, DataObject value, long currentTime, long currentDuration) {
                return currentDuration;
            }

            @Override
            public long expireAfterRead(String key, DataObject value, long currentTime, long currentDuration) {
                return currentDuration;
            }
        }).build(k -> DataObject.get("Data for " + k));

        cache = Caffeine.newBuilder().refreshAfterWrite(1, TimeUnit.MINUTES).build(k -> DataObject.get("Data for " + k));
    }

    @Test
    public void givenCache_whenStatsEnabled_thenStatsRecorded() {
        LoadingCache<String, DataObject> cache = Caffeine.newBuilder().maximumSize(100).recordStats().build(k -> DataObject.get("Data for " + k));
        cache.get("A");
        cache.get("A");

        assertEquals(1, cache.stats().hitCount());
        assertEquals(1, cache.stats().missCount());
    }

}