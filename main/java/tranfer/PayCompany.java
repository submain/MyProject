package tranfer;

import tranfer.service.ITransfer;
import tranfer.service.SafeOperate;
import tranfer.service.SafeOperateToo;

public class PayCompany {
	
	private static class TransferThread extends Thread{
		private String threadName;
		private UserAccount from;
		private UserAccount to;
		private int account;
		private ITransfer iTransfer;
		
		public  TransferThread(String name,UserAccount from,UserAccount to,int account,ITransfer iTransfer) {
			this.threadName = name;
			this.from = from;
			 this.to = to;
	         this.account = account;
	         this.iTransfer = iTransfer;
			
		}
		
		@Override
		public void run() {
			try {
				iTransfer.transfer(from, to, account);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	  public static void main(String[] args) {
		 // ITransfer transfer = new SafeOperateToo();
		  ITransfer transfer = new SafeOperate();
		  UserAccount zhangsan = new UserAccount("zhangsan",20000);
	        UserAccount lisi = new UserAccount("lisi",20000);
		  TransferThread zhangsanToLisi = new TransferThread("zhangsanToLisi"
	                ,zhangsan,lisi,2000,transfer);
		  TransferThread lisiToZhangsan = new TransferThread("lisiToZhangsan"
	                ,lisi,zhangsan,4000,transfer);
		  zhangsanToLisi.start();
		  lisiToZhangsan.start();
	  }

}
