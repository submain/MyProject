package threadtest;
//ʹ���ڲ���ʵ��
public class MySingleton {
	public MySingleton() {
		System.out.println("����single");
	}
	
	public static class Inner{
		private static MySingleton mySingleton = new MySingleton();
	}
	
	public static MySingleton getInstance() {
		return Inner.mySingleton;
	}
	
	public static void main(String [] args) {
		Thread [] threads = new Thread[200];
		for(int i=0;i<threads.length;i++) {
			new Thread(()->{
				System.out.println(MySingleton.getInstance());
			}).start();
		}
	}
}
