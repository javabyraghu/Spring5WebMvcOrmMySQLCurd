package in.nareshit.raghu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "in.nareshit.raghu")
@PropertySource("classpath:mvc.properties")
public class MvcConfig {
	
	@Autowired
	private Environment env;

	//1. ViewResolver
	@Bean
	public InternalResourceViewResolver irvr() {
		InternalResourceViewResolver v = new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("my.app.prefix"));
		v.setSuffix(env.getProperty("my.app.suffix"));
		return v;
	}
}
