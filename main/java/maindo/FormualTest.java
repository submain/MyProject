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
	// deafult新特性
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

		// lambda表达式新特性
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

		// 函数式接口

		// stream

		// filter过滤
		List<String> list2 = new ArrayList<String>();
		list2.add("tang");
		list2.add("xiang");
		list2.add("hong");
		System.out.println("666666-----------------------------333333333333333");
		list2.stream().filter((s) -> (s).contains("a")).forEach(System.out::println);
		System.out.println("666666-----------------------------333333333333333");
		// sorted排序
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(3);
		list3.add(2);
		list3.add(12);
		//list3.stream().sorted().filter((s) -> s < 10).forEach(System.out::println);

		// Map映射
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		stringCollection.stream().map(String::toUpperCase) // 此处识别的是List<String> 处的类型
				.sorted((o1, o2) -> o1.compareTo(o2)) // 此处必须使用o1和o2
				.forEach(System.out::println);
		System.out.println("----------------------------132-------------------------------");
		stringCollection.forEach(System.out::println);
		System.out.println("----------------------------132-------------------------------");
		// match
		// anymatch
		boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
		// System.out.println("是否以a开头："+anyStartsWithA);

		// allmatch
		boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));

		// System.out.println(allStartsWithA);
		// nonematch
		boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));

		// System.out.println(noneStartsWithZ);

		// count  最终操作
		long startWithX = list2.stream().filter((s) -> s.startsWith("x")).count();
		//System.out.println(startWithX);
		
		//Reduce约束
		Optional<String> reduced = list2.stream().reduce((s1,s2)->s1+"---"+s2);
		//reduced.ifPresent(System.out::println);
		
		//并行Streams
		//Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行
		//数量较小的时候，并行会花费很多时间在线程调度上，因此并行在小数量时会慢于串行
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
//		System.out.println("串行用时为："+millis);
//		int max2 = 10000000;
//		List<String> values2 = new ArrayList<>(max);
//		for(int i=0;i<max2;i++) {
//			String uuid = UUID.randomUUID().toString();
//			values2.add(uuid);
//		//并行parallelStream
//		}
//        long startTime2 = System.nanoTime();
//		
//		long count2 = values2.parallelStream().sorted().count();
//		
//		long endTime2 = System.nanoTime();
//		
//		long millis2 = TimeUnit.NANOSECONDS.toMillis(endTime2-startTime2);
//		
//		System.out.println("并行用时为："+millis2);
		
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
		
		//时钟
		Clock clock = Clock.systemDefaultZone();
		long milliss = clock.millis();

		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);   // legacy java.util.Date
		//Timezones 时区在新API中时区使用ZoneId来表示。时区可以很方便的使用静态方法of来获取到。 时区定义了到UTS时间的时间差，在Instant时间点对象到本地日期对象之间转换的时候是极其重要的。
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
