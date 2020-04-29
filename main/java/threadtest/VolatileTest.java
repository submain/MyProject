package threadtest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class VolatileTest {
	volatile static int va ; 
	List<Object> list = new ArrayList<>();
	public void m1() {
		System.out.println("m1开始运行");
		while(va==0) {
			list.add(new Object());
			System.out.println("运行中");
		}
		System.out.println("m1结束运行");
	}
	public void m2() {
		System.out.println("m2开始运行");
			while(true) {
				if(list.size()>5) {
					va = 1;
					break;
				}	
			}					
		System.out.println("m2结束运行");
	}
	
	public static void main(String[] args) {
		VolatileTest volatileTest = new VolatileTest();
		new Thread(volatileTest::m2).start();
		new Thread(volatileTest::m1).start();
		
		
	}
	
}
