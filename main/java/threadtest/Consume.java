package threadtest;

import java.util.concurrent.BlockingQueue;

public class Consume {
	public String name;
	BlockingQueue<String> queue;
	public  Consume(BlockingQueue<String> queue,String name) {
		this.queue = queue;
		this.name=name;
	}
	
	public void consu() {
		while(true) {
			synchronized (queue) {
				while(queue.size()>=10) {
					String c = queue.poll();
					try {
						Thread.sleep(2000);
						System.out.println(name+"ฯ๛ทัมห+"+c);
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						queue.notifyAll();
					}					

				}
			
			}
			
		}
	}
}
