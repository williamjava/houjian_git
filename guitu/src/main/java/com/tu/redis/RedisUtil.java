package com.tu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	private static Jedis jedis;//����Ƭ�ͻ�������
	private static JedisPool jedisPool;//����Ƭ���ӳ�
	
	/**
	 * ��ʼ������Ƭ��
	 */
	private static void initialPool() {
		//�ػ�������
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
