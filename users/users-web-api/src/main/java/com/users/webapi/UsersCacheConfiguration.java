package com.users.webapi;

import com.users.webapi.contract.LocationDto;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Musisz włączyć cache w swojej aplikacji. Możesz to zrobić, dodając adnotację @EnableCaching
 */
@Configuration
@EnableCaching
public class UsersCacheConfiguration {


    /**
     * Spring potrzebuje CacheManagera do zarządzania pamięcią podręczną.
     * Możesz użyć domyślnego CacheManagera dostarczonego przez Spring Boot lub skonfigurować własnego.
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("locationCache")));
        return cacheManager;
    }

}
