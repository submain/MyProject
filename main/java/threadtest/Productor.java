package threadtest;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class Productor {
	BlockingQueue<String> queue ;
	 public String name;
	  public Productor(BlockingQueue<String> q,String name) {
		  this.queue = q;
		  this.name = name;
	  }
	  public void produc () {
		  while(true) {
			  synchronized (queue) {
				 while(queue.size()<=10) {		
						 String productId = UUID.randomUUID().toString();
						 System.out.println(name+"生产产品"+productId);
						 queue.add(productId);
					 try {
						queue.notifyAll();
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
			 
		 }
	  }
	  }
}
