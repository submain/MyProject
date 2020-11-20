package maindo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.MainConfig;

import domain.Persion;
import domain.Son;
import domain.TimeT;
public class MainTest {
	public static void  main(String []args) {
//	 ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
//	 Persion persion = (Persion) applicationContext.getBean("persion");
//	 System.out.println(persion);
		
		AnnotationConfigApplicationContext  annotationConfigApplicationContext =new AnnotationConfigApplicationContext(MainConfig.class);
		Persion persion = (Persion) annotationConfigApplicationContext.getBean("persion01");
		System.out.println(persion);
		String [] beanNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for(String beanName :beanNames) {
			System.out.println(beanName);
		}
	}
	@Test
	public void test01() {
		
	}
	@Test
	public void test3() {
		Date date = new Date();
		date.setHours(date.getHours() + 11);
		System.out.println(date);
	}
	
	@Test
	public void test02 () {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext  annotationConfigApplicationContext =new AnnotationConfigApplicationContext(PropertiesConfig.class);
		printBeans(annotationConfigApplicationContext);
		System.out.println("=============");
		Persion persion = (Persion) annotationConfigApplicationContext.getBean("persion");
		System.out.println(persion);
	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
	
	@Test
	public void test03 () {
	  TimeT t = new TimeT();
	  t.setStartTime(new Date());
	  Date EndTime1 = new Date();
	  EndTime1.setHours(EndTime1.getHours()+4);
	  System.out.println(new Date());
	  System.out.println(EndTime1);
	  t.setEndTime(EndTime1);
	  TimeT t2 = new TimeT();
	  t2.setStartTime(new Date());
	  Date EndTime2 = new Date();
	  EndTime2.setHours(EndTime2.getHours()+5);
	  t2.setEndTime(EndTime2);
	  List<TimeT> list = new ArrayList<>();
	  list.add(t);
	  list.add(t2);
	  System.out.println(list);
	  List<TimeT> listNew = new ArrayList<>();
	  
	  for(TimeT record :list) {
		  Date fileStartTime;
	      Date fileEndTime ;
          fileStartTime = (Date) record.getStartTime().clone();
          Date pdEndTime = (Date) record.getEndTime().clone();
          fileEndTime = (Date) record.getStartTime().clone();
          fileEndTime.setHours(fileEndTime.getHours()+2);
          while(fileEndTime.compareTo(pdEndTime)>0) {
              fileEndTime = (Date) pdEndTime.clone();
          }
          while(fileStartTime.compareTo(pdEndTime)<0) {
        	  TimeT  timeT = new TimeT();
        	  timeT.setStartTime((Date)fileStartTime.clone());
        	  timeT.setEndTime((Date)fileEndTime.clone());
              listNew.add(timeT);
              //时间后移两个小时
              fileStartTime.setHours(fileStartTime.getHours()+2);
              fileEndTime.setHours(fileEndTime.getHours()+2);
              while(fileEndTime.compareTo(pdEndTime)>0) {
                  fileEndTime = (Date) pdEndTime.clone();
              }
          }
      }
	  System.out.println(list);
	  System.out.println(listNew);
	}
}

