package threadtest;

public class SycTest implements Runnable {
	//synchronized�ؼ����Ƕ�����  ������д����ͬ������д��
	public synchronized void test01() throws InterruptedException {
		System.out.println("sssss");
		Thread.sleep(4000);
		System.out.println("eeeee");
	}
	//�������÷���ͬ
	public void test03() throws InterruptedException {
		synchronized(this) {
			System.out.println("sssss");
			Thread.sleep(4000);
			System.out.println("eeeee");
		}
	}
	//��д���൱��סClass����
	public synchronized static void test04() {
		System.out.println("04sssss");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("04eeeee");
	}
	
	public static void test05() {
		synchronized(SycTest.class) {
			test04();
			System.out.println("start....");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("end.....");
			}
	}
	
	public synchronized void test02() {
		
	}
	
	public static void main(String[] args) {
		SycTest sycTest = new SycTest();
		Thread thread1 = new Thread(sycTest);
		Thread thread2 = new Thread(sycTest);
		thread1.start();
		thread2.start();
//		Son son = new Son();
//		Thread thread1 = new Thread(son);
//		Thread thread2 = new Thread(son);
//		thread1.start();
//		thread2.start();
	}

	@Override
	public void run() {
		this.test05();
	}

}
