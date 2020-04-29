package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import domain.Persion;

//�����==�����ļ�

@Configuration  //���Vspring�@��һ��������
@ComponentScan(value="com.supmain",excludeFilters= {
		@Filter(type=FilterType.ANNOTATION,value=Controller.class)
})
public class MainConfig {
   
	
   //������ע��һ��bean������Ϊ����ֵ�����ͣ�idĬ�Ϸ�������Ϊid	
   @Bean(name="persion01")	
   public Persion persion() {
	   return new Persion("tang","myheart");
   }
}
