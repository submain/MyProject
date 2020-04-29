package threadtest;

import org.junit.Test;

public class ThreadTest extends Thread implements Runnable{
	
	static Thread thread1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("�߳�һrun....");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�߳�һend...");
		}
	});
	static Thread thread2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("�̶߳�run....");
			try {
				Thread.sleep(2000);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�̶߳�end...");
			
		}
	});
	//Junit��Ԫ���Բ�֧�ֶ��߳�  �ӵ�
	@Test
	public void threadTest() {
		thread1.start();
		thread2.start();
	}
	public static void main(String args[]) {
		//���߳�ʵ�����ַ�ʽ
		/*thread1.start();
		thread2.start();*/
		//new Thread(new ThreadTest(),"t1").start();
		new ThreadTest().start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("runing������������");
	}
}
