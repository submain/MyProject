package domain;


import interfaces.Converter;
/**
 * []
 * @author Administrator
 *
 */
public class LambdaDemo {
	
	static int num;
	String name="123";
	/**
	 * [lambda±Ì¥Ô Ω]
	 */
	public void lambdaT() {
		Converter<Integer, String> converter = form->{
			form=1;
			return String.valueOf(form);
		};
		String a = converter.convert(num);
		System.out.println(a);
		Converter<String, Integer> converter2 = form->{
			form="1233";
			return Integer.valueOf(form);
		};
		int b = converter2.convert(name);

		System.out.println(new String (b+""));
		
		
	
	}

}
