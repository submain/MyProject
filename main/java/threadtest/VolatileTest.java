package threadtest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class VolatileTest {
	volatile static int va ; 
	List<Object> list = new ArrayList<>();
	public void m1() {
		System.out.println("m1��ʼ����");
		while(va==0) {
			list.add(new Object());
			System.out.println("������");
		}
		System.out.println("m1��������");
	}
	public void m2() {
		System.out.println("m2��ʼ����");
			while(true) {
				if(list.size()>5) {
					va = 1;
					break;
				}	
			}					
		System.out.println("m2��������");
	}
	
	public static void main(String[] args) {
		VolatileTest volatileTest = new VolatileTest();
		new Thread(volatileTest::m2).start();
		new Thread(volatileTest::m1).start();
		
		
	}
	
}
