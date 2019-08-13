package com.lds.springbootdemo.service;

import java.util.Map;
import java.util.Set;


/**
 * redis通用操作Service
 */
public interface RedisCacheService {

    /**
     * 设置MAP的Key
     * @param Key
     */
    void setHK(String Key);

    /**
     * 根据key得到value，没查到就返回null
     * @param key
     * @return
     */
    String get(String key);


    /**
     * 有就修改没有就新增
     * @param key
     * @param value
     */
   void put(String key, String value);


    /**
     * 根据key删除
     * @param key
     * @return
     */
    Long deleteByKey(String key);

    /**
     * 判断是否有此key
     * @param key
     * @return
     */
   Boolean hasKey(String key);


    /**
     * 获取map
     * @return
     */
   Map<Object,Object> getMap();


    /**
     * 获取keys
     * @param key
     * @return
     */
    Set<Object> getKeySet(String key);


    /**
     * 获取hash的size
     * @param key
     * @return
     */
   long getSize(String key);


    /**
     * put map
     * @param map
     */
   void putMap(Map<String, Object> map);


}
