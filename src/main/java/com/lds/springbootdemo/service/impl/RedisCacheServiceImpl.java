package com.lds.springbootdemo.service.impl;

import com.lds.springbootdemo.service.RedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * redis通用操作Service
 */
@Service
public class RedisCacheServiceImpl implements RedisCacheService {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * redis存储map的key
     */
    private static String REDIS_MAP_KEY = "SPRINGBOOTDEMO:HASH:";

    @Override
    public void setHK(String Key) {
        REDIS_MAP_KEY += Key;
    }

    ;

    @Override
    public String getForHash(String key) {
        return (String) redisTemplate.opsForHash().get(REDIS_MAP_KEY, key);
    }

    @Override
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void putForHash(String key, String value) {
        redisTemplate.opsForHash().put(REDIS_MAP_KEY, key, value);
    }

    @Override
    public void put(String key, String value, long outTime) {
        redisTemplate.opsForValue().set(key, value, outTime, TimeUnit.SECONDS);
    }

    @Override
    public Long deleteByKeyForHash(String key) {
        return redisTemplate.opsForHash().delete(REDIS_MAP_KEY, key);
    }

    @Override
    public Boolean deleteByKey(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Boolean hasKeyForHash(String key) {
        return redisTemplate.opsForHash().hasKey(REDIS_MAP_KEY, key);
    }

    @Override
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Map<Object, Object> getMapForHash() {
        return redisTemplate.opsForHash().entries(REDIS_MAP_KEY);
    }


    @Override
    public Set<Object> getKeySetForHash(String key) {
        return redisTemplate.opsForHash().keys(REDIS_MAP_KEY);
    }

    @Override
    public long getSizeForHash(String key) {
        return redisTemplate.opsForHash().size(REDIS_MAP_KEY);
    }

    @Override
    public void putMapForHash(Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(REDIS_MAP_KEY, map);
    }

}
