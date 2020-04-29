package threadtest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {
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
		try {
			//我会等你5秒钟
		boolean locked = lock1.tryLock(5,TimeUnit.SECONDS);
		System.out.println("我是m2"+locked);
		if(locked) { 		
				System.out.println("我是m2开始...");
				Thread.sleep(5000);
				System.out.println("我是m2结束...");
			} else {
			System.out.println("拿不到我就不执行了呗");
		}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock1.unlock();
		}
	}
		
	
	public static void main(String [] args) {
		TryLockTest l = new TryLockTest();
		new Thread(l::m1).start();
		new Thread(l::m2).start();
		
	}
}
