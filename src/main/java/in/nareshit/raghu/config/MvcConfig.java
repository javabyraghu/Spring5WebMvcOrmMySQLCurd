package in.nareshit.raghu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

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
		v.setOrder(2);
		return v;
	}
	
	@Bean
	public XmlViewResolver xvr() {
		XmlViewResolver xv = new XmlViewResolver();
		xv.setLocation(new ClassPathResource("myviews.xml"));
		xv.setOrder(1);
		return xv;
	}
}
