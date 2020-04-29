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
		// ��ȡ��Ӧ��ƽ����
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());

		//map ��������ӳ��ÿ��Ԫ�ص���Ӧ�Ľ�������´���Ƭ��ʹ�� map �����Ԫ�ض�Ӧ��ƽ������
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
		    	System.out.println("����"+a.getKey());
		    	System.out.println("ֵ��"+a.getValue());
		    }
		   employeesByCity1.entrySet().stream().filter((e)->"dddd".equals(e.getKey())
		    	
		   ).forEach(e->{
			   System.out.println(e.getKey());
		   });
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
		    
		    StringBuffer sb = new StringBuffer();
//		    ����ͨ��"volatile"��"Unsafe�ṩ��CAS����ʵ��"ԭ�Ӳ�����
//		    1.value��volatile���͡��Ᵽ֤�ˣ���ĳ�߳��޸�value��ֵʱ�������߳̿�����valueֵ�������µ�valueֵ�����޸�֮���volatile��ֵ��
//		    2. ͨ��CAS����value���Ᵽ֤�ˣ���ĳ�̳߳�ͨ��CAS����(��compareAndSet����)����valueʱ�����Ĳ�����ԭ�ӵģ����߳��ڲ���valueʱ���ᱻ�жϡ�
	
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
			System.out.println("�½������һ��ֵΪ��"+a[0]);
	}

	private static String fetchGroupKey(Employee d) {
		// TODO Auto-generated method stub
		return d.getCity().toString();
	}
	

	

}
