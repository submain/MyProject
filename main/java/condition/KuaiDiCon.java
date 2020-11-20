package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class KuaiDiCon {
	
	public final static  String SITE="anyang";
	private int km;
	private String site;
	private ReentrantLock lock = new ReentrantLock();
	private Condition kmcon = lock.newCondition();
	private Condition sitecon = lock.newCondition();
	
	 public KuaiDiCon(int km, String site) {
	        this.km = km;
	        this.site = site;
	    }
	public void changeSite(String site) {
		lock.lock();
		try {
			this.site = site;
			sitecon.signal();
		}
		finally {
			lock.unlock();
		}
		
	}
	
	public void changekm(int km) {
		lock.lock();
		try {
			this.km = km;
			kmcon.signal();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void waitKm() {
		
		lock.lock();
		try {
			while(km<=80) {
				System.out.println("waitKm wait");
				kmcon.await();
				System.out.println(Thread.currentThread().getName() + " is notifed");
			}
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
		System.out.println("the km has been over out");
	}
	
	public void waitSite() {
		lock.lock();
		try {
			while(SITE.equals(site)) {
				System.out.println("waitSite wait");
				sitecon.await();
				System.out.println(Thread.currentThread().getName() + " is notifed");
			}
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
		System.out.println("the good has been arrived");
	}

}
