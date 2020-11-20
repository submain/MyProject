package tranfer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserAccount {
	private String name;
	private double money;
	private final Lock lock = new ReentrantLock();
	public UserAccount(String name, double money) {
		super();
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	//转入资金
    public void addMoney(int amount){
        money = money + amount;
    }

    //转出资金
    public void flyMoney(int amount){
        money = money - amount;
    }
	public Lock getLock() {
		return lock;
	}
	
	
}
