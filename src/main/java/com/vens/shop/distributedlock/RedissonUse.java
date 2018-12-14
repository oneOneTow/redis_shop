package com.vens.shop.distributedlock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.connection.balancer.RandomLoadBalancer;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/12/14
 */
public class RedissonUse {
    public static void main(String[] args) {
        Config config=new Config();
        config.useClusterServers()
                .setPassword("7416kobe")
                .addNodeAddress("192.168.1.69","192.168.1.256");
        RedissonClient redissonClient= Redisson.create(config);
        RMap<String,Integer> map=redissonClient.getMap("myMap");
        RLock lock=redissonClient.getLock("myLock");
    }

}
