package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import domain.Persion;

//配置類==配置文件

@Configuration  //告訴spring這是一个配置类
@ComponentScan(value="com.supmain",excludeFilters= {
		@Filter(type=FilterType.ANNOTATION,value=Controller.class)
})
public class MainConfig {
   
	
   //给容器注册一个bean；类型为返回值的类型，id默认方法名作为id	
   @Bean(name="persion01")	
   public Persion persion() {
	   return new Persion("tang","myheart");
   }
}
