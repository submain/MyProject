package threadtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class FutureTest {
	@Test
	public void test() throws InterruptedException, ExecutionException {
		FutureTask<Integer> task = new FutureTask<>(() -> {
			TimeUnit.MILLISECONDS.sleep(5000);
			return 1000;
		});
		new Thread(task).start();

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Future<Integer> future = executorService.submit(() -> {
			TimeUnit.MILLISECONDS.sleep(500);
			return 1;
		});
		System.out.println(future.get());
		System.out.println(future.isDone());
		System.out.println(task.get());
	};
}
