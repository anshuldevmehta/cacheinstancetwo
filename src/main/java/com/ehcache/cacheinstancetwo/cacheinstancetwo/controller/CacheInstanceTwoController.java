package com.ehcache.cacheinstancetwo.cacheinstancetwo.controller;

import com.ehcache.cacheinstancetwo.cacheinstancetwo.service.ClusteredEhCacheCommunicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cluster")
public class CacheInstanceTwoController
{
    @Autowired
    ClusteredEhCacheCommunicator clusteredEhCacheCommunicator;

    @GetMapping("ehcache/{key}")
    public String getValueFromCache(@PathVariable String key)
    {
        return clusteredEhCacheCommunicator.getFromClusteredEhcache(key);
    }

    @GetMapping("ehcache/{key}/{value}")
    public void writeValueToCache(@PathVariable String key,@PathVariable String value)
    {
        clusteredEhCacheCommunicator.writeToClusteredEhCache(key,value);
    }

    @GetMapping("ehcache/remove/{key}")
    public void removeValueFromCache(@PathVariable String key)
    {
        clusteredEhCacheCommunicator.removeFromClusteredCache(key);
    }
}
