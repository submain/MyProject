package maindo;


import domain.DoSomeThing;
import domain.Persion;
import interfaces.Converter;
import interfaces.PersionFactory;

public class ConverterTest {
	
	public static void  main(String []args) {
		int num = 9;
		//���ǿ���ֱ����lambda���ʽ�з������ľֲ����������Ǻ���������ͬ���ǣ�����ı���num���Բ�������Ϊfinal���ô���ͬ����ȷ
		Converter< String, Integer> converter = (form) -> Integer.valueOf(form+num);
		Integer a = converter.convert("232");
		System.out.println(a);
		//�����num���벻�ɱ�����Ĵ����޸ģ������Եľ���final�����壩����������ľ��޷����룻��lambda���ʽ����ͼ�޸�numͬ���ǲ������
		//num=10;
		
		//ͨ����̬��������
		Converter< String, Integer> converter2 = Integer::valueOf;
		Integer b = converter2.convert("345");
		System.out.println(b);
		
		//���ö��󷽷�
		Converter< String, Integer> converter3 = DoSomeThing::sqrt;
		Integer c = converter3.convert("456");
		System.out.println(c);
		//::֮�๹�캯��
		PersionFactory<Persion> persionFactory = Persion :: new;
		Persion persion = persionFactory.createPersion("txh", "myheart");
		
		System.out.println(persion);
		
		
		//stream
		
		
		
	}

}
