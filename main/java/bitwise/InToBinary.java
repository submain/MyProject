package bitwise;

import java.io.UnsupportedEncodingException;

public class InToBinary {
public static void main(String[] args) throws UnsupportedEncodingException {
    	
    	int data = 4;
    	System.out.println("the 4 is "+Integer.toBinaryString(data));
    	
    	//λ��  &(1&1=1 1&0=0 0&0=0)
    	System.out.println("the 4 is "+Integer.toBinaryString(4));
    	System.out.println("the 6 is "+Integer.toBinaryString(6));
    	System.out.println("the 4&6 is "+Integer.toBinaryString(4&6));
    	//λ�� | (1|1=1 1|0=1 0|0=0)
    	System.out.println("the 4|6 is "+Integer.toBinaryString(4|6));
    	//λ��~��~1=0  ~0=1��
    	System.out.println("the ~4 is "+Integer.toBinaryString(~4));
    	//λ��� ^ (1^1=0 1^0=1 0^0=0)
    	System.out.println("the 4^6 is "+Integer.toBinaryString(4^6));
    	
    	// <<�з������� >>�з��ŵ�����  >>>�޷�������
    	
    	//ȡģ�Ĳ��� a % (2^n) �ȼ��� a&(2^n-1)
    	System.out.println("the 345 % 16 is "+(345%16)+ " or "+(345&(16-1)));
    	
    } 
}
