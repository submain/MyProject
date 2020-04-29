package maindo;


import domain.DoSomeThing;
import domain.Persion;
import interfaces.Converter;
import interfaces.PersionFactory;

public class ConverterTest {
	
	public static void  main(String []args) {
		int num = 9;
		//我们可以直接在lambda表达式中访问外层的局部变量，但是和匿名对象不同的是，这里的变量num可以不用声明为final，该代码同样正确
		Converter< String, Integer> converter = (form) -> Integer.valueOf(form+num);
		Integer a = converter.convert("232");
		System.out.println(a);
		//这里的num必须不可被后面的代码修改（即隐性的具有final的语义），例如下面的就无法编译；在lambda表达式中试图修改num同样是不允许的
		//num=10;
		
		//通过静态方法引用
		Converter< String, Integer> converter2 = Integer::valueOf;
		Integer b = converter2.convert("345");
		System.out.println(b);
		
		//引用对象方法
		Converter< String, Integer> converter3 = DoSomeThing::sqrt;
		Integer c = converter3.convert("456");
		System.out.println(c);
		//::之余构造函数
		PersionFactory<Persion> persionFactory = Persion :: new;
		Persion persion = persionFactory.createPersion("txh", "myheart");
		
		System.out.println(persion);
		
		
		//stream
		
		
		
	}

}
