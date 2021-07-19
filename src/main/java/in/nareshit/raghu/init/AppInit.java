package in.nareshit.raghu.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import in.nareshit.raghu.config.MvcConfig;
import in.nareshit.raghu.config.OrmConfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	//NON-MVC (JDBC/ORM/EMAIl/...etc)
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { OrmConfig.class };
	}

	//WEB MVC CONFIG
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MvcConfig.class };
	}

	//URL-Pattern
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}


}
