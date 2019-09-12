package com.lds.springbootdemo.service.impl;

import com.lds.springbootdemo.service.RedisCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheServiceImplTest {

    @Autowired
    RedisCacheService redisCacheService;

    @Test
    public void test(){
        redisCacheService.put("test","666",500);
        System.out.println(redisCacheService.get("test"));
    }
}