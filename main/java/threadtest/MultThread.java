package threadtest;

public class MultThread {
	public static void main(String[] args) {
		MultThread multThread = new MultThread();
		new Thread(()->{
			multThread.eat();
			
		}).start();
		new Thread(()->{
			multThread.say();
			
		}).start();
	}
	
	public  synchronized void  say() {
		System.out.println("start saying......");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("说完了....");
	}
	
	public synchronized void eat() {
		System.out.println("start eating......");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("吃完了,....");
	}
}
