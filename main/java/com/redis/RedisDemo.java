package com.redis;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisDemo {
	@Test
	public void test01() {
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		System.out.println("服务正在运行：" + jedis.ping());
		// set 添加键值对
		jedis.set("爱情", "残酷又美好");
		// get 查询对应键值
		String key = jedis.get("爱情");
		System.out.println(key);
		// append 将给定的 追加到原值的末尾
		jedis.append("爱情", "，你遇到过吗");
		key = jedis.get("爱情");
		System.out.println(key);
		// strlen 获得值的长度
		long length = jedis.strlen("爱情");
		System.out.println(length);
		// setnx 只有在 key 不存在时设置 key 的值
		jedis.setnx("爱情", "dadada");
		key = jedis.get("爱情");
		System.out.println(key);
		// 设置键值的同时，设置过期时间，单位秒。
		// jedis.setex("测试过期", 20, "测试过期。。。。");
		key = jedis.get("测试过期");
		System.out.println(key);
		// 从左边/右边插入一个或多个值。
//		jedis.lpush("第一个列表", "虚空的原子");
//		jedis.lpush("第一个列表", "破碎的梦幻");
//		jedis.lpush("第一个列表", "虚虚实实在");
//		jedis.lpush("第一个列表", "空空如也空");
		List<String> list = jedis.lrange("第一个列表", 0, jedis.llen("第一个列表"));
		/*
		 * for(String str:list) { System.out.println(str); }
		 */

		// 从左边/右边吐出一个值。
		jedis.lpop("第一个列表");
		// list.stream().forEach(System.out::println);
		// 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。
		// jedis.sadd("第一个set列表", "dada","dad");
		Set<String> listSet = jedis.smembers("第一个set列表");
		//listSet.stream().forEach(System.out::println);
		// 随机从该集合中取出n个值。
		List<String> ke = jedis.srandmember("第一个set列表", 2);
		ke.stream().forEach(System.out::println);

	}
}
