package in.nareshit.raghu.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = false)
@PropertySource("classpath:orm.properties")
public class OrmConfig {
	
	@Autowired
	private Environment env;

	//1. DataSource
	@Bean
	public DriverManagerDataSource dsObj() {
		DriverManagerDataSource ds = new  DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("my.app.driver"));
		ds.setUrl(env.getProperty("my.app.url"));
		ds.setUsername(env.getProperty("my.app.un"));
		ds.setPassword(env.getProperty("my.app.pwd"));
		return ds;
	}
	
	//2. SessionFactory
	@Bean
	public LocalSessionFactoryBean sfObj() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dsObj());
		sf.setHibernateProperties(props());
		//ORM Model class package name
		sf.setPackagesToScan("in.nareshit.raghu.model");
		return sf;
	}
	
	public Properties props() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getProperty("my.app.dialect"));
		p.put("hibernate.show_sql", env.getProperty("my.app.showsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("my.app.ddlauto"));
		p.put("hibernate.format_sql", env.getProperty("my.app.fmtsql"));
		return p;
	}

	//3. HT
	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht = new HibernateTemplate();
		ht.setSessionFactory(sfObj().getObject());
		return ht;
	}
	
	//4. HTxM
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager htxm = new HibernateTransactionManager();
		htxm.setSessionFactory(sfObj().getObject());
		return htxm;
	}
}
