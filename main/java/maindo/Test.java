package maindo;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
        String strs="jbpnbwwd";	
		String strscomto = "";
		String result="";
		int count=0;
		int start=0;
		int max = 0;
        char s ;

        while(start<strs.length()) {
        	 l:for(int i=start;i<strs.length();i++){
             	s=strs.charAt(i); 
             	if(count>0) {
             		for(int j=0;j<strscomto.length();j++) {
             			char n = strscomto.charAt(j);
             			if(n==s) {
             				start+=1;
             				if(count>max) {
             					max=count;
             					
             					result = strscomto;
             					
             				}
	             				count=0;
	             				strscomto="";
             				break l;
             			}
             		}
             	}
             	
             	strscomto+=s;
             	
             	if(i==strs.length()-1) {
             		start+=1;
             		if(count+1>max) {
     					max=count+1;
     					count=0;
     					result = strscomto;
     					strscomto="";
     				}
             	}else {
             		count+=1;
             	}
             }
        }
        System.out.println(max);
       
        
	}
	@org.junit.Test
	public void Test02() {
		int [] a = new int[] {11,12,13,14,15,56,16};
		for(int i=0;i<a.length;i++) {
			if(a[i]==56) {
				continue;
			}
			System.out.println(a[i]);
		}
	}
	@org.junit.Test
	public void test03() {
		String sa = "A0102";
		String v = "A01";
		System.out.println(sa.substring(3,5));
		if(v.equals(sa.substring(0, 2))) {
			System.out.println("111111");
		}else {
			System.out.println("2222222");
		}
		
		List<String> list = new ArrayList<>();
		list.add("231");
		list.add("dada");
		list.add("hgf");
		
		
	}
}
