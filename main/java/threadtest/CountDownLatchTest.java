package threadtest;

import java.util.concurrent.CountDownLatch;
//CountDownLatch门栓测试
public class CountDownLatchTest {
	CountDownLatch countDownLatch = new CountDownLatch(1);
	public  void m1() {
		System.out.println("我是m1");
		try {
			countDownLatch.await();
			System.out.println("m1结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public  void m2() {
		System.out.println("我是m2");
		try {
			Thread.sleep(3000);
			System.out.println("m2结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			countDownLatch.countDown();
		}
		
	
	}
	
	public static void main(String[] args) {
		CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
		new Thread(countDownLatchTest::m1).start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(countDownLatchTest::m2).start();
	}
}
