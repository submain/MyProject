package threadtest;

public class Son extends Parent {

	@Override
	public synchronized void pSay() {
		// TODO Auto-generated method stub
		super.pSay();
		System.out.println("shello....");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("shello....end");
	}
 
}
