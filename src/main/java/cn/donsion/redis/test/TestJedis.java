package cn.donsion.redis.test;

import java.util.ResourceBundle;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 测试Redis服务器
 * @author donsi
 *
 */
public class TestJedis {
	
	/*
	 * 在静态代码块中完成初始化
	 */
	private static JedisPool pool;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("redis");
		if (bundle == null) {
			throw new IllegalArgumentException(
					"[redis.properties] is not found!");
		}
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(Integer.valueOf(bundle
				.getString("redis.pool.maxActive")));
		config.setMaxIdle(Integer.valueOf(bundle
				.getString("redis.pool.maxIdle")));
		config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
		config.setTestOnBorrow(Boolean.valueOf(bundle
				.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle
				.getString("redis.pool.testOnReturn")));
		pool = new JedisPool(config, bundle.getString("redis.host"),
				Integer.valueOf(bundle.getString("redis.port")));
		
	
	}
	
	public static void main(String[] args) {
		Jedis jedis = pool.getResource();
		String keys = "name";
		jedis.set(keys, "dongxian");
		String value = jedis.get(keys);
		System.out.println(value);
		pool.returnResource(jedis);
	}
	
	@Test
	public void test1(){
		
		Jedis jedis = pool.getResource();
		String keys = "name";
		jedis.set(keys, "dongxian");
		String value = jedis.get(keys);
		System.out.println(value);
		pool.returnResource(jedis);
	}
	
	@Test
	public void test2(){
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println(jedis);
		pool.returnResource(jedis);
	}
	
	@Test
	public void testRedisClient1(){
		Jedis jedis = RedisClient.getJedis();
		System.out.println(jedis);
	}
	
	@Test
	public void testRedisClient(){
		Jedis jedis = RedisClient.getJedis();
		String keys = "name";
		jedis.set(keys, "dongxian");
		String value = jedis.get(keys);
		System.out.println(value);
		RedisClient.returnJedis(jedis);
	}
	
	@Test
	public void test(){
	}
}
