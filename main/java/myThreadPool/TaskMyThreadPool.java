package myThreadPool;

import java.util.Random;

public class TaskMyThreadPool {
	
	public  static void main(String[] args) throws InterruptedException {
		MyThreadPool myThreadPool = new MyThreadPool(3,0);
		myThreadPool.execute(new MyTask("task1"));
		myThreadPool.execute(new MyTask("task2"));
		myThreadPool.execute(new MyTask("task3"));
		myThreadPool.execute(new MyTask("task4"));
		System.out.println(myThreadPool);
        Thread.sleep(10000);
        // 所有线程都执行完成才destory
        myThreadPool.destory();
        System.out.println(myThreadPool);
	}
	
	static class MyTask implements Runnable{
		private String name;
        private Random r = new Random();

        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
		@Override
		public void run() {
			try {
                Thread.sleep(r.nextInt(1000)+2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId()+" sleep InterruptedException:"
                        +Thread.currentThread().isInterrupted());
            }
            System.out.println("任务 " + name + " 完成");
		}
		
	}
	}
