package mySchedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import tool.SleepTools;

public class ScheduleWorkTime implements Runnable{
    public final static int Long_8 = 8;//�����ʱ8��
    public final static int Short_2 = 2;//�����ʱ2��
    public final static int Normal_5 = 5;//�����ʱ5��

    public static SimpleDateFormat formater = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    public static AtomicInteger count = new AtomicInteger(0);
	@Override
	public void run() {
		if(count.get()==0) {
            System.out.println("Long_8....begin:"+formater.format(new Date()));
            SleepTools.second(Long_8);
            System.out.println("Long_8....end:"+formater.format(new Date())); 
            count.incrementAndGet();
    	}else if(count.get()==1) {
    		System.out.println("Short_2 ...begin:"+formater.format(new Date()));
    		SleepTools.second(Short_2);
    		System.out.println("Short_2 ...end:"+formater.format(new Date()));
            count.incrementAndGet();    		
    	}else {
    		System.out.println("Normal_5...begin:"+formater.format(new Date()));
    		SleepTools.second(Normal_5);
    		System.out.println("Normal_5...end:"+formater.format(new Date()));
    		count.incrementAndGet(); 
    	}		
	}
	
	public static void main(String[] args) {
    	ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(1);
    	//������6��
        schedule.scheduleAtFixedRate(new ScheduleWorkTime(),
                0, 6000, TimeUnit.MILLISECONDS);
}

}
