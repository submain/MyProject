package maindo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamGroupByTest {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		Employee e1 = new Employee("aaaa", "12",12);
		Employee e2 = new Employee("bbbb", "13",32);
		Employee e3 = new Employee("cccc", "14",23);
		Employee e4 = new Employee("dddd", "15",43);
		Employee e5 = new Employee("dddd", "16",54);
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());

		//map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
		List<Employee>  employees2 = employees.stream().map(s->{
			s.setMonry(1);
			return s;
		}).collect(Collectors.toList());
		 Map<String, List<Employee>> employeesByCity =
		            employees.stream().collect(Collectors.groupingBy(Employee::getCity));
		    System.out.println(employeesByCity.get("dddd"));
		    Map<String, List<Employee>> employeesByCity1 =
		            employees.stream().collect(Collectors.groupingBy(d->fetchGroupKey(d)));
		    System.out.println("dddddddddddddddddddddddddddddddd");
		    System.out.println(employeesByCity.get("dddd").get(0).getCity());
		    System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		    for(Map.Entry<String,  List<Employee>> a:employeesByCity1.entrySet()) {
		    	System.out.println("键是"+a.getKey());
		    	System.out.println("值是"+a.getValue());
		    }
		   employeesByCity1.entrySet().stream().filter((e)->"dddd".equals(e.getKey())
		    	
		   ).forEach(e->{
			   System.out.println(e.getKey());
		   });
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
		    
		    StringBuffer sb = new StringBuffer();
//		    它是通过"volatile"和"Unsafe提供的CAS函数实现"原子操作。
//		    1.value是volatile类型。这保证了：当某线程修改value的值时，其他线程看到的value值都是最新的value值，即修改之后的volatile的值。
//		    2. 通过CAS设置value。这保证了：当某线程池通过CAS函数(如compareAndSet函数)设置value时，它的操作是原子的，即线程在操作value时不会被中断。
	
		    final AtomicInteger c = new AtomicInteger(0);
		    List<Employee> list1 =  employees.stream().filter(s->"dddd".equals(s.getCity())).collect(Collectors.toList());
		    employees.stream().map((a)->{
		    	return a.getCity()+"ssss";
		    } ).forEach(System.out::println);
		    employees.stream().filter(s->"dddd".equals(s.getCity())).forEach(s->{
		    	c.addAndGet(s.getMonry());

		    	sb.append(s.getPeoplecount());
		    });
		    System.out.println(c);
			int a [] = new int[3];
			System.out.println("新建数组第一个值为："+a[0]);
	}

	private static String fetchGroupKey(Employee d) {
		// TODO Auto-generated method stub
		return d.getCity().toString();
	}
	

	

}
