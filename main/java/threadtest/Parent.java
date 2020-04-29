package threadtest;

public class Parent implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		pSay();
	}
	
	public synchronized void pSay() {
		System.out.println("phello....");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("phello....end");
	}

}
