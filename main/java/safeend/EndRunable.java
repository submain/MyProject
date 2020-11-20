package safeend;

public class EndRunable {
	private static class UseRunnable implements Runnable{

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			while(Thread.currentThread().isInterrupted()) {
				System.out.println("Thread " + threadName + " is run!");
			}	
			System.out.println(threadName + " interrupt flag is " + Thread.currentThread().isInterrupted() );
		}
		
		
	}
	
	public static void main(String [] args) throws InterruptedException 
	{
		UseRunnable endRunable = new UseRunnable();
		Thread thread = new Thread(endRunable,"endThread");
		thread.start();
		Thread.sleep(20);
		thread.interrupt();
		
	}
}
