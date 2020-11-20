package tranfer.service;

import java.util.Random;

import tool.SleepTools;
import tranfer.UserAccount;

public class SafeOperateToo implements ITransfer{

	@Override
	public void transfer(UserAccount from, UserAccount to, int amount) throws InterruptedException {
		Random random = new Random();
		while(true) {
			if(from.getLock().tryLock()) {
				try {
					System.out.println("Thread " + Thread.currentThread().getName() + " get " + from.getName());
					if(to.getLock().tryLock()) {
						try {
							System.out.println("Thread " + Thread.currentThread().getName() + " get " + to.getName());
							//两把锁都拿到了
    	                    from.flyMoney(amount);
    	                    to.addMoney(amount);
    	                    System.out.println("SafeOperateToo success");
    	                    break;
						}
						finally {
							to.getLock().unlock();
						}
					}
				}
				finally {
					from.getLock().unlock();
				}
			}
			SleepTools.ms(random.nextInt(10));	
		}
	}

}
