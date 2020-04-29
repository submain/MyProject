package threadtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 并行计算  查找出20万以内的质数
 * @author Administrator
 *
 */
public class ParallelComputingTest {
	public static void main(String [] args) throws InterruptedException, ExecutionException {
		List<Integer> list = new ArrayList<>();
		long start = System.currentTimeMillis();
		list = SearchParme(0,200000);
		long end = System.currentTimeMillis();
		System.out.println("所用时间："+(end-start));		
		start = System.currentTimeMillis();
		ExecutorService executorService  = Executors.newFixedThreadPool(5);
		MyTask myTask1 = new MyTask(0, 100000);
		MyTask myTask2 = new MyTask(100000, 150000);
		MyTask myTask3 = new MyTask(150000, 180000);
		MyTask myTask4 = new MyTask(180000, 200000);
		Future<List<Integer>> list1=executorService.submit(myTask1);
		Future<List<Integer>> list2=executorService.submit(myTask2);
		Future<List<Integer>> list3=executorService.submit(myTask3);
		Future<List<Integer>> list4=executorService.submit(myTask4);
		list1.get();
		list2.get();
		list3.get();
		list4.get();
		
		end = System.currentTimeMillis();
		System.out.println("并发所用时间："+(end-start));		
		
		
	}
	
	static  class MyTask implements Callable<List<Integer>> {
		public int start ;
		public int end;
		public  MyTask(int start,int end) {
			this.start=start;
			this.end=end;
		}
		@Override
		public List<Integer> call() throws Exception {
			// TODO Auto-generated method stub
			return SearchParme(start,end);
		}
		
	}
	
	public static List<Integer> SearchParme(int start,int end) {
		List<Integer> list = new ArrayList<>();
		for(int i=start;i<end;i++) {
			if(isPrame(i)) {
				list.add(i);
			}
		}
		return list;
	}
	
	public static boolean isPrame(int a) {
		for(int i=2;i<a/2;i++) {
			if(a%i==0) {
				return false;
			}
			
		}
		return true;
	}
}
