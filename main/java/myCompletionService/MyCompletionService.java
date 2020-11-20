package myCompletionService;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用CompletionService进行获取线程执行结果
 * @author Administrator
 *
 */
public class MyCompletionService {
	
	private final int POOL_SIZE = Runtime.getRuntime().availableProcessors();
	private final int TOTAL_TASK = Runtime.getRuntime().availableProcessors();

	/**
	 * 自定义
	 * @throws Exception
	 */
	public void testByQueue() throws Exception {
		long start = System.currentTimeMillis();
		AtomicInteger atomicInteger = new AtomicInteger(0);
		ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
		BlockingQueue<Future<Integer>> blockingQueue = new LinkedBlockingDeque<Future<Integer>>();
		for(int i=0;i<TOTAL_TASK;i++) {
			Future<Integer> result = pool.submit(new WorkTask("ExecTask" + i));
			blockingQueue.add(result);
		}
		for(int i=0;i<TOTAL_TASK;i++) {
			int time = blockingQueue.take().get();
			System.out.println(" slept " + time +"ms -------");
			atomicInteger.addAndGet(time);
		}
		//关闭线程池
		pool.shutdown();
		System.out.println("task run " + atomicInteger.get() + " ms and all time is " + (System.currentTimeMillis() - start) + " ms");
	}
	
	public void testByCompletionService() throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		AtomicInteger atomicInteger = new AtomicInteger(0);
		ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(pool);
		for(int i=0;i<TOTAL_TASK;i++) {
			completionService.submit(new WorkTask("ExecTask" + i));
		}
		
		for( int i=0;i<TOTAL_TASK;i++) {
			int time = completionService.take().get();
			System.out.println(" sleep " + time);
			atomicInteger.addAndGet(time);
		}
		
		  // 关闭线程池
        pool.shutdown();
        System.out.println("-------------tasks sleep time "+atomicInteger.get()
			+"ms,and spend time "
			+(System.currentTimeMillis()-start)+" ms");
	}
	
	public static void main (String[] args) throws Exception {
		MyCompletionService myCompletionService = new MyCompletionService();
		myCompletionService.testByQueue();
		myCompletionService.testByCompletionService();
	}
	
	
}
