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
	private Jedis jedis;//����Ƭ�ͻ�������
	private JedisPool jedisPool;//����Ƭ���ӳ�
	private ShardedJedis shardedJedis;//��Ƭ�ͻ�������
	private ShardedJedisPool shardedJedisPool;//��Ƭ���ӳ�
	
	public RedisClient() {
		initialPool(); 
        initialShardedPool(); 
        shardedJedis = shardedJedisPool.getResource(); 
        jedis = jedisPool.getResource(); 
	}
	
	/**
	 * ��ʼ������Ƭ��
	 */
	private void initialPool() {
		//�ػ�������
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(20);
		config.setMaxIdle(5);
		config.setMaxWait(20001);
		config.setTestOnBorrow(false);
		
		jedisPool = new JedisPool(config, "192.168.142.154", 6379);
	}
	
	/**
	 * ��ʼ����Ƭ��
	 */
	private void initialShardedPool() {
		// �ػ������� 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxActive(20); 
        config.setMaxIdle(5); 
        config.setMaxWait(2000l); 
        config.setTestOnBorrow(false); 
        // slave���� 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo("192.168.142.154", 6379, "master")); 

        // ����� 
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
		System.out.println("��տ����������ݣ�" + jedis.flushDB());
		//���key
		jedis.set("myname", "WuHoujian");
		jedis.set("myage", "25");
		jedis.set("mysex", "boy");
		jedis.set("myjob", "Software Engineer");
		System.out.println("ϵͳ�����м����£�");
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
