package employeemvc.config;



import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"employeemvc"})
public class Config {
    @Bean
	public EntityManager getManager() {
		return Persistence.createEntityManagerFactory("jaya").createEntityManager();
	}
   

}
