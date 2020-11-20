package mySchedule;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleTask implements Runnable{

	public final static  int NORMAL=0;
	public final static  int HasException = -1;
	public final static int ProcessException = 1;
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int type = 1;
	 public ScheduleTask(int type) {
		 this.type = type;
	}
	@Override
	public void run() {
		if(type == HasException) {
			System.out.println(simpleDateFormat.format(new Date())+" Exception made...");
    		throw new RuntimeException("HasException Happen");
		}else if(type == ProcessException){
			try {
				System.out.println(simpleDateFormat.format(new Date())+" Exception made...");
	    		throw new RuntimeException("HasException Happen");
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println(" Normal ...."+simpleDateFormat.format(new Date()));
		}
	}

}
