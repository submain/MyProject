package myThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 自定义线程池
 * @author Administrator
 *
 */
public class MyThreadPool {
	
	private static int WORK_NUM=5;
	private static int TASK_NUM=100;
	
	//任务线程
	private BlockingQueue<Runnable> taskQueue;
	//线程池
	private WorkThread[] workThreads;
	
    private final int worker_num;//用户在构造这个池，希望的启动的线程数

	
	//初始化线程池
	public MyThreadPool() {
		this(WORK_NUM,TASK_NUM);
	}
	
	public MyThreadPool(int work_num,int task_num) {
		if(work_num<=0) {
			work_num = WORK_NUM;
		}
		if(task_num<=0) {
			task_num = TASK_NUM;
		}
		this.worker_num = work_num;
		taskQueue = new ArrayBlockingQueue<>(TASK_NUM);
		workThreads = new WorkThread[WORK_NUM];
		for(int i=0;i<work_num;i++) {
			workThreads[i] =  new WorkThread();
			//此处会启动线程，任务在里面执行
			workThreads[i].start();
			Runtime.getRuntime().availableProcessors();
		}
	}
	
	/**
	 * 执行任务，将任务放入阻塞队列中
	 * @param task
	 */
	public void execute(Runnable task) {
		if(task!=null) {
			try {
				taskQueue.put(task);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 销毁线程池
	 */
	public void destory() {
		System.out.println("销毁线程池....");
		//终止启动的每个线程
		for(int i=0;i<worker_num;i++) {
			workThreads[i].stopWorker();
			workThreads[i]=null;
		}
		//将队列清空
		taskQueue.clear();
	}
	
	
	
	private class WorkThread extends Thread{
		@Override
		public void run(){
			Runnable task = null;
			try {
			while(!isInterrupted()) {				
					task = taskQueue.take();
					if(task!=null) {
						System.out.println(getId()+" ready exec :"+task);
						task.run();
					}
			}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
		
		}
		
		public void stopWorker() {
			interrupt();
		}
	}

}
