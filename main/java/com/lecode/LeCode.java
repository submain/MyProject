package com.lecode;

import java.util.Arrays;

import org.junit.Test;

public class LeCode {
	@Test
	public void test01() {
		int [] num1 = {1,3,5};
		int [] num2 = {4,76,30,2};
		int []  num = concat(num1,num2);
		System.out.println(Arrays.toString(num));
		for(int i=0;i<num.length-1;i++) {
			for(int j=0;j<num.length-i-1;j++) {		
				if(num[j]<num[j+1]) {
					int count = num[j];
					num[j]=num[j+1];
					num[j+1] = count;
				}
			}
		}
		System.out.println(Arrays.toString(num));
		double middleNum ;
		if(num.length%2==0) {
			middleNum = (num[num.length/2-1]+num[(num.length/2-1)+1])/2.0;
		}else {
			middleNum = num[num.length/2];
		}
		System.out.println(middleNum);
	}
	
	public int[] concat(int [] num1,int [] num2) {
		int[] c= new int[num1.length+num2.length];
		 System.arraycopy(num1, 0, c, 0, num1.length);
		 System.arraycopy(num2, 0, c, num1.length, num2.length);
		 return c;
	}

}
