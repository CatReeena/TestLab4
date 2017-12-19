package dao;

import dao.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * Created by Shera on 19.12.2017.
 */
@Configuration
@ComponentScan
public class AppConfig {

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitName("Local");
        return em;
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