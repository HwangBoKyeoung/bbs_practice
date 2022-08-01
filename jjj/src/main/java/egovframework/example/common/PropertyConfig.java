package egovframework.example.common;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertyConfig {
	
//	system이라는 이름으로 email.properties파일의 속성값을 가져올 수 있게됨
	@Bean(name="system")
	public PropertiesFactoryBean propertiesFactoryBean() throws Exception {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//		src/main/resources 아래 경로부터 기재하면 됨
		ClassPathResource classPathResource = new ClassPathResource("properties/email.properties");
		
		propertiesFactoryBean.setLocation(classPathResource);
		
		return propertiesFactoryBean;
	}
	
}
