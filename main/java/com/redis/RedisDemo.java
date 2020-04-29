package com.redis;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisDemo {
	@Test
	public void test01() {
		Jedis jedis = new Jedis("localhost");
		System.out.println("���ӳɹ�");
		System.out.println("�����������У�" + jedis.ping());
		// set ��Ӽ�ֵ��
		jedis.set("����", "�п�������");
		// get ��ѯ��Ӧ��ֵ
		String key = jedis.get("����");
		System.out.println(key);
		// append �������� ׷�ӵ�ԭֵ��ĩβ
		jedis.append("����", "������������");
		key = jedis.get("����");
		System.out.println(key);
		// strlen ���ֵ�ĳ���
		long length = jedis.strlen("����");
		System.out.println(length);
		// setnx ֻ���� key ������ʱ���� key ��ֵ
		jedis.setnx("����", "dadada");
		key = jedis.get("����");
		System.out.println(key);
		// ���ü�ֵ��ͬʱ�����ù���ʱ�䣬��λ�롣
		// jedis.setex("���Թ���", 20, "���Թ��ڡ�������");
		key = jedis.get("���Թ���");
		System.out.println(key);
		// �����/�ұ߲���һ������ֵ��
//		jedis.lpush("��һ���б�", "��յ�ԭ��");
//		jedis.lpush("��һ���б�", "������λ�");
//		jedis.lpush("��һ���б�", "����ʵʵ��");
//		jedis.lpush("��һ���б�", "�տ���Ҳ��");
		List<String> list = jedis.lrange("��һ���б�", 0, jedis.llen("��һ���б�"));
		/*
		 * for(String str:list) { System.out.println(str); }
		 */

		// �����/�ұ��³�һ��ֵ��
		jedis.lpop("��һ���б�");
		// list.stream().forEach(System.out::println);
		// ��һ������ member Ԫ�ؼ��뵽���� key ���У��Ѿ������ڼ��ϵ� member Ԫ�ؽ������ԡ�
		// jedis.sadd("��һ��set�б�", "dada","dad");
		Set<String> listSet = jedis.smembers("��һ��set�б�");
		//listSet.stream().forEach(System.out::println);
		// ����Ӹü�����ȡ��n��ֵ��
		List<String> ke = jedis.srandmember("��һ��set�б�", 2);
		ke.stream().forEach(System.out::println);

	}
}
