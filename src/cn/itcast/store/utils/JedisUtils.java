package cn.itcast.store.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	//创建连接池
	private static JedisPoolConfig config;
	private static JedisPool pool;
	
	static{
		config=new JedisPoolConfig();
		config.setMaxTotal(30);
		config.setMaxIdle(2);
		
		pool=new JedisPool(config, "47.107.119.174", 7009);
	}
	
	
	//获取连接的方法
	public static Jedis getJedis(){
		return pool.getResource();
	}
	
	
	//释放连接
	public static void closeJedis(Jedis j){
		j.close();
	}
	public static void main(String[] args) {
		
		Jedis jedis = JedisUtils.getJedis();
		jedis.append("a", "b");
		System.out.println(jedis.get("a"));
		System.out.println("ok");
	}
}
