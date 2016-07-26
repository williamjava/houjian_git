package com.tu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	private static Jedis jedis;//非切片客户端连接
	private static JedisPool jedisPool;//非切片连接池
	
	/**
	 * 初始化非切片池
	 */
	private static void initialPool() {
		//池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(20);
		config.setMaxIdle(5);
		config.setMaxWait(100001);
		config.setTestOnBorrow(false);
		
		jedisPool = new JedisPool(config, "192.168.142.156", 6379);
	}
	
	public static Jedis getJedisInstance() {
		if (jedis == null) {
			initialPool();
			return jedisPool.getResource();
		} else {
			return jedis;
		}
	}
}
