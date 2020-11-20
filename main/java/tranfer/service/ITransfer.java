package tranfer.service;

import tranfer.UserAccount;

public interface ITransfer {

	void transfer(UserAccount from ,UserAccount to, int amount) throws InterruptedException;
}
