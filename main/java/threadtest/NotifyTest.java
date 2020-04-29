package threadtest;

public class NotifyTest {
	public synchronized void m1() {
		System.out.println("����m1");
		try {
			this.wait();
			System.out.println("m1����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.notifyAll();
		}
		
	}
	public synchronized void m2() {
		System.out.println("����m2");
		try {
			Thread.sleep(3000);
			System.out.println("m2����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.notifyAll();
		}
		
	
	}
	
	public static void main(String[] args) {
		NotifyTest n = new NotifyTest();
		new Thread(n::m1).start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(n::m2).start();
	}
}
