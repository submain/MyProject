package threadtest;

import java.util.concurrent.TimeUnit;

public class MyThreadLocal {
	static ThreadLocal<String> threadLocal = new ThreadLocal<>();
	public static void main(String[] args) {
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(threadLocal.get()+"adadadada");
		}).start();
		new Thread(()->{
			threadLocal.set("dadada");
		}).start();
	}
}
