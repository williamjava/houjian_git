package com.tu.redis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisClient {
	private Jedis jedis;//非切片客户端连接
	private JedisPool jedisPool;//非切片连接池
	private ShardedJedis shardedJedis;//切片客户端连接
	private ShardedJedisPool shardedJedisPool;//切片连接池
	
	public RedisClient() {
		initialPool(); 
        initialShardedPool(); 
        shardedJedis = shardedJedisPool.getResource(); 
        jedis = jedisPool.getResource(); 
	}
	
	/**
	 * 初始化非切片池
	 */
	private void initialPool() {
		//池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(20);
		config.setMaxIdle(5);
		config.setMaxWait(20001);
		config.setTestOnBorrow(false);
		
		jedisPool = new JedisPool(config, "192.168.142.154", 6379);
	}
	
	/**
	 * 初始化切片池
	 */
	private void initialShardedPool() {
		// 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxActive(20); 
        config.setMaxIdle(5); 
        config.setMaxWait(2000l); 
        config.setTestOnBorrow(false); 
        // slave链接 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo("192.168.142.154", 6379, "master")); 

        // 构造池 
        shardedJedisPool = new ShardedJedisPool(config, shards);
	}
	
	public void show() {
		KeyOperate(); 
        StringOperate(); 
        ListOperate(); 
        SetOperate();
        SortedSetOperate();
        HashOperate(); 
        jedisPool.returnResource(jedis);
        shardedJedisPool.returnResource(shardedJedis);
	}
	
	private void KeyOperate() {
		System.out.println("=====key=====");
		System.out.println("清空库中所有数据：" + jedis.flushDB());
		//添加key
		jedis.set("myname", "WuHoujian");
		jedis.set("myage", "25");
		jedis.set("mysex", "boy");
		jedis.set("myjob", "Software Engineer");
		System.out.println("系统中所有键如下：");
		Set<String> keys = jedis.keys("*");
		Iterator<String> iterator = keys.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println("key:" + key + "===value:" + jedis.get(key));
		}
     }

     private void StringOperate() {
    	 System.out.println("...");
     }

     private void ListOperate() {
    	 System.out.println("...");
     }

     private void SetOperate() {
    	 System.out.println("...");
     }

     private void SortedSetOperate() {
    	 System.out.println("...");
     }
   
     private void HashOperate() {
        System.out.println("...");
     }
}
