package domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Son  {
	@Value("${person.nickName}")
	private String name;
	public static String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getAge() {
		return age;
	}
	public static void setAge(String age) {
		Son.age = age;
	}
	@Override
	public String toString() {
		return "Son [name=" + name + "]";
	}

}
