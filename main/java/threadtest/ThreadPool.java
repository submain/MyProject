package threadtest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 6; i++) {
			executorService.execute(( ) -> {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("执行任务：");
				System.out.println("当前线程："+Thread.currentThread().getName());
			});
		}

		System.out.println(executorService);
		executorService.shutdown();
		System.out.println(executorService.isTerminated());
		System.out.println(executorService.isShutdown());
		System.out.println(executorService);

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(executorService.isTerminated());
		System.out.println(executorService.isShutdown());
		System.out.println(executorService);
	}

}
