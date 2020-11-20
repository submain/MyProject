package condition;

public class KuaiDiTest {
	private static KuaiDiCon kuaiDiCon = new KuaiDiCon(0,KuaiDiCon.SITE);
	
	private static class KmThread extends Thread{
		   @Override
	        public void run() {
			 kuaiDiCon.waitKm();
	        }
	}
	
	private static class SiteThread extends Thread{
		   @Override
	        public void run() {
			 kuaiDiCon.waitKm();
	        }
	}
	
	public static void main(String [] args) throws InterruptedException {
		for(int i=0;i<3;i++) {
			new KmThread().start();
		}
		for(int i=0;i<3;i++) {
			new SiteThread().start();
		}
		Thread.sleep(5000);
		kuaiDiCon.changekm(100);
	}
	
}
