package threadtest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	Lock lock1 = new ReentrantLock();
	public void m1() {
		lock1.lock();
		System.out.println("我是m1");
		try {
			Thread.sleep(5000);
			System.out.println("我是m1结束...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock1.unlock();
		}	
	}
	public void m2() {
		lock1.lock();
		System.out.println("我是m2");
		try {
			Thread.sleep(5000);
			System.out.println("我是m2结束...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock1.unlock();
		}
	}
	
	public static void main(String [] args) {
		LockTest l = new LockTest();
		new Thread(l::m1).start();
		new Thread(l::m2).start();
		
	}
}
