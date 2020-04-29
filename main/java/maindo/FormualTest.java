package maindo;

import java.lang.reflect.Array;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import interfaces.Formual;

public class FormualTest {
	// deafult������
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Formual formual = new Formual() {

			@Override
			public double calculate(int a) {
				// TODO Auto-generated method stub
				return sqrt(a) * 100;
			}
		};
		int a = (int) formual.calculate(121);
		int b = (int) formual.sqrt(121);
		// System.out.println(a);
		// System.out.println(b);

		// lambda���ʽ������
		List list = Arrays.asList("tang", "xiang", "hong", "wang", "cai", "li");
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});

		System.out.println(list);
		Collections.sort(list, (String o1, String o2) -> {
			return o1.compareTo(o2);
		});

		// System.out.println(list);

		// ����ʽ�ӿ�

		// stream

		// filter����
		List<String> list2 = new ArrayList<String>();
		list2.add("tang");
		list2.add("xiang");
		list2.add("hong");
		System.out.println("666666-----------------------------333333333333333");
		list2.stream().filter((s) -> (s).contains("a")).forEach(System.out::println);
		System.out.println("666666-----------------------------333333333333333");
		// sorted����
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(3);
		list3.add(2);
		list3.add(12);
		//list3.stream().sorted().filter((s) -> s < 10).forEach(System.out::println);

		// Mapӳ��
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		stringCollection.stream().map(String::toUpperCase) // �˴�ʶ�����List<String> ��������
				.sorted((o1, o2) -> o1.compareTo(o2)) // �˴�����ʹ��o1��o2
				.forEach(System.out::println);
		System.out.println("----------------------------132-------------------------------");
		stringCollection.forEach(System.out::println);
		System.out.println("----------------------------132-------------------------------");
		// match
		// anymatch
		boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
		// System.out.println("�Ƿ���a��ͷ��"+anyStartsWithA);

		// allmatch
		boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));

		// System.out.println(allStartsWithA);
		// nonematch
		boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));

		// System.out.println(noneStartsWithZ);

		// count  ���ղ���
		long startWithX = list2.stream().filter((s) -> s.startsWith("x")).count();
		//System.out.println(startWithX);
		
		//ReduceԼ��
		Optional<String> reduced = list2.stream().reduce((s1,s2)->s1+"---"+s2);
		//reduced.ifPresent(System.out::println);
		
		//����Streams
		//Stream�д��кͲ������֣�����Stream�ϵĲ�������һ���߳���������ɣ�������Stream�����ڶ���߳���ͬʱִ��
		//������С��ʱ�򣬲��лỨ�Ѻܶ�ʱ�����̵߳����ϣ���˲�����С����ʱ�����ڴ���
//		int max = 10000000;
//		List<String> values = new ArrayList<>(max);
//		for(int i=0;i<max;i++) {
//			String uuid = UUID.randomUUID().toString();
//			values.add(uuid);
//		}
//		long startTime = System.nanoTime();
//		
//		long count = values.stream().sorted().count();
//		
//		long endTime = System.nanoTime();
//		
//		long millis = TimeUnit.NANOSECONDS.toMillis(endTime-startTime);
//		
//		System.out.println("������ʱΪ��"+millis);
//		int max2 = 10000000;
//		List<String> values2 = new ArrayList<>(max);
//		for(int i=0;i<max2;i++) {
//			String uuid = UUID.randomUUID().toString();
//			values2.add(uuid);
//		//����parallelStream
//		}
//        long startTime2 = System.nanoTime();
//		
//		long count2 = values2.parallelStream().sorted().count();
//		
//		long endTime2 = System.nanoTime();
//		
//		long millis2 = TimeUnit.NANOSECONDS.toMillis(endTime2-startTime2);
//		
//		System.out.println("������ʱΪ��"+millis2);
		
		Map<Integer,String> map = new HashMap<>();
		for(int i=0;i<10;i++) {
			map.putIfAbsent(i, "num"+i);
		}
		map.forEach((id,value)->
		System.out.println(value)
		);
		
		map.computeIfPresent(3, (num, val) -> val + num);
		map.get(3);             // val33

		map.computeIfPresent(9, (num, val) -> null);
		map.containsKey(9);     // false

		map.computeIfAbsent(23, num -> "val" + num);
		map.containsKey(23);    // true

		map.computeIfAbsent(3, num -> "bam");
		map.get(3);   
		
		map.remove(3, "val3");
		map.get(3);             // val33

		map.remove(3, "val33");
		map.get(3);    
		map.getOrDefault(42, "not found");  // not found
		
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9

		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		map.get(9);  
		
		//ʱ��
		Clock clock = Clock.systemDefaultZone();
		long milliss = clock.millis();

		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);   // legacy java.util.Date
		//Timezones ʱ������API��ʱ��ʹ��ZoneId����ʾ��ʱ�����Ժܷ����ʹ�þ�̬����of����ȡ���� ʱ�������˵�UTSʱ���ʱ����Instantʱ�����󵽱������ڶ���֮��ת����ʱ���Ǽ�����Ҫ�ġ�
		//System.out.println(legacyDate);
		System.out.println(ZoneId.getAvailableZoneIds());
		// prints all available timezone ids

		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());

		// ZoneRules[currentStandardOffset=+01:00]
		// ZoneRules[currentStandardOffset=-03:00]
		
		
		
		
        	
        
	}

}
