package myThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * �Զ����̳߳�
 * @author Administrator
 *
 */
public class MyThreadPool {
	
	private static int WORK_NUM=5;
	private static int TASK_NUM=100;
	
	//�����߳�
	private BlockingQueue<Runnable> taskQueue;
	//�̳߳�
	private WorkThread[] workThreads;
	
    private final int worker_num;//�û��ڹ�������أ�ϣ�����������߳���

	
	//��ʼ���̳߳�
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
			//�˴��������̣߳�����������ִ��
			workThreads[i].start();
			Runtime.getRuntime().availableProcessors();
		}
	}
	
	/**
	 * ִ�����񣬽������������������
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
	 * �����̳߳�
	 */
	public void destory() {
		System.out.println("�����̳߳�....");
		//��ֹ������ÿ���߳�
		for(int i=0;i<worker_num;i++) {
			workThreads[i].stopWorker();
			workThreads[i]=null;
		}
		//���������
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
