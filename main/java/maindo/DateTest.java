package maindo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void  main(String []args) {
		Date date  = new Date();
		System.out.println(date.getDate());
		System.out.println(date.getMonth());
		date.setDate(1);
		date.setMonth(12);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String s  = simpleDateFormat.format(date);
		System.out.println(s);
	}
}
