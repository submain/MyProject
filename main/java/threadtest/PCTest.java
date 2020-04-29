package threadtest;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class PCTest {
     public static void main(String [] args) {
    	 BlockingQueue<String> queue = new ArrayBlockingQueue<>(110);
    	 Productor productor = new Productor(queue,"������1");
    	 Productor productor2 = new Productor(queue,"������2");
    	 Consume consume = new Consume(queue,"������1");
    	 Consume consume2 = new Consume(queue,"������2");
    	 Consume consume3 = new Consume(queue,"������3");
    	 new Thread(productor::produc).start();
    	 new Thread(consume::consu).start();
    	 new Thread(productor2::produc).start();
    	 new Thread(consume2::consu).start();
    	 new Thread(consume3::consu).start();
    	
     }
}
