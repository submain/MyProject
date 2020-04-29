package maindo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import domain.Persion;
import domain.Son;
@PropertySource(value= {"classpath:my.properties"})
@Configuration
public class PropertiesConfig {
	
	
	
	@Bean
	public Son son() {
		return new Son();
	}
	
	@Bean
	public Persion persion() {
		return new Persion();
	}
}
