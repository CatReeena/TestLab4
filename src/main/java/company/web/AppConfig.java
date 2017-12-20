package company.web;

import company.dao.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Shera on 19.12.2017.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan
public class AppConfig {

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitName("Local");
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactoryBean().getObject() );
        return transactionManager;
    }

    @Bean
    public MovieDAO returnMovieDAO()
    {
        return new MovieDAOHibernate();
    }

    @Bean
    public HallDAO returnHallDAO()
    {
        return new HallDAOHibernate();
    }

    @Bean
    public SessionDAO returnSessionDAO()
    {
        return new SessionDAOHibernate();
    }

}