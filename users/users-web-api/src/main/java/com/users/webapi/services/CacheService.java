package com.users.webapi.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheService {

    @CacheEvict(value = "locationCache", allEntries = true)
    public void clearCache() {
        log.info("Cache 'mycache' has been cleared.");
    }

    @CacheEvict(value = "locationCache", key = "#param")
    public void evictSingleCacheValue(String param) {
        log.info("Cache entry with key '" + param + "' has been evicted.");
    }
}
