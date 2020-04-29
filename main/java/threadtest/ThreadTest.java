package threadtest;

import org.junit.Test;

public class ThreadTest extends Thread implements Runnable{
	
	static Thread thread1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("线程一run....");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程一end...");
		}
	});
	static Thread thread2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("线程二run....");
			try {
				Thread.sleep(2000);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程二end...");
			
		}
	});
	//Junit单元测试不支持多线程  坑爹
	@Test
	public void threadTest() {
		thread1.start();
		thread2.start();
	}
	public static void main(String args[]) {
		//多线程实现三种方式
		/*thread1.start();
		thread2.start();*/
		//new Thread(new ThreadTest(),"t1").start();
		new ThreadTest().start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("runing。。。。。。");
	}
}
