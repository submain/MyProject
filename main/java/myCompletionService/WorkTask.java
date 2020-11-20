package myCompletionService;

import java.util.Random;
import java.util.concurrent.Callable;

public class WorkTask implements Callable<Integer>{
	private String name;
	@Override
	public Integer call() throws Exception {
		 int sleepTime = new Random().nextInt(1000);
		try {
			System.out.println("Ïß³Ì" + name + " sleep " + sleepTime + " ms ");
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			e.printStackTrace();
		}		return sleepTime;
	}
	
	public WorkTask(String name) {
		this.name = name;
	}

}
