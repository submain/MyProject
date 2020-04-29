package threadtest;

public class Test01 {
	
	public synchronized void m1() {
		System.out.println("我是m1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("我是m1结束...");
	}
	
	public synchronized void m2() {
		System.out.println("我是m2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("我是m2结束...");
	}
	
	public static void main(String[] args) {
		Test01 test01 = new Test01();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				test01.m1();
			}
		});
		t1.start();
		Thread t2 = new Thread(test01::m2);
		t2.start();
	}

}
