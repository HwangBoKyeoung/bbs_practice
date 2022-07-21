package egovframework.example.common;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertyConfig {
	
	@Bean(name="system")
	public PropertiesFactoryBean propertiesFactoryBean() throws Exception {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//		src/main/resources 아래 경로부터 기재하면 됨
		ClassPathResource classPathResource = new ClassPathResource("properties/email.properties");
		
		propertiesFactoryBean.setLocation(classPathResource);
		
		return propertiesFactoryBean;
	}
	
}
