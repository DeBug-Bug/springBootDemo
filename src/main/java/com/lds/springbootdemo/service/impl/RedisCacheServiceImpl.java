package com.lds.springbootdemo.service.impl;

import com.lds.springbootdemo.service.RedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.Map;
import java.util.Set;


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
    public void setHK(String Key){REDIS_MAP_KEY+=Key;};

    @Override
    public String get(String key) {
        return (String) redisTemplate.opsForHash().get(REDIS_MAP_KEY, key);
    }

    @Override
    public void put(String key,String value) {
      redisTemplate.opsForHash().put(REDIS_MAP_KEY, key, value);
    }

    @Override
    public Long deleteByKey(String key) {
        return redisTemplate.opsForHash().delete(REDIS_MAP_KEY, key);
    }

    @Override
    public Boolean hasKey(String key) {
        return redisTemplate.opsForHash().hasKey(REDIS_MAP_KEY, key);
    }

    @Override
    public Map<Object,Object> getMap() {
        return redisTemplate.opsForHash().entries(REDIS_MAP_KEY);
    }

    @Override
    public Set<Object> getKeySet(String key) {
        return redisTemplate.opsForHash().keys(REDIS_MAP_KEY);
    }

    @Override
    public long getSize(String key) {
        return redisTemplate.opsForHash().size(REDIS_MAP_KEY);
    }

    @Override
    public void putMap(Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(REDIS_MAP_KEY,map);
    }

}
