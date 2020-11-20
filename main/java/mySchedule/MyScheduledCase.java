package mySchedule;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyScheduledCase {
	
	 public static void main(String[] args) {
		 ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
		 scheduledThreadPoolExecutor.scheduleAtFixedRate(new ScheduleTask(ScheduleTask.HasException), 
				 1000, 3000, TimeUnit.MILLISECONDS);
		 scheduledThreadPoolExecutor.scheduleAtFixedRate(new ScheduleTask(ScheduleTask.NORMAL), 
				 1000, 3000, TimeUnit.MILLISECONDS);
	 }

	 
}
