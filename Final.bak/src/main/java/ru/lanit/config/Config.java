package ru.lanit.config;

import ru.lanit.persist.*;
import ru.lanit.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.hibernate.SessionFactory;
import javax.sql.DataSource;
import java.util.Properties;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Config
{

    @Bean("UserDAO")
    public UserDAO userDAO() {
        HibernateUserDAO userDAO =  new HibernateUserDAO(sessionFactory());
        return userDAO;
    }
    @Bean("DoctorDAO")
    public DoctorDAO doctorDAO() {
        HibernateDoctorDAO doctorDAO =  new HibernateDoctorDAO ( sessionFactory() );
        return doctorDAO;
    }
    @Bean("RxDTO")
    public RxDTO rxDTO() {
        HibernateRxDTO rxDTO =  new HibernateRxDTO ( sessionFactory() );
        return rxDTO;
    }

    @Bean
    public UserService userService() {
        UserServiceImpl service =  new UserServiceImpl();
        service.setDao ( userDAO() );
        return service;
    }
    @Bean
    public DoctorService doctorService() {
        DoctorServiceImpl service =  new DoctorServiceImpl();
        service.setDao ( doctorDAO() );
        return service;
    }
    @Bean
    public RxService rxService() {
        RxServiceImpl service =  new RxServiceImpl();
        service.setDto ( rxDTO() );
        return service;
    }

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder sfb = new LocalSessionFactoryBuilder(dataSource());
        sfb.scanPackages("ru.lanit.persist");
        sfb.addProperties(hibernateProperties());
        return sfb.buildSessionFactory();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/FinalDB");
        dataSource.setUsername("GUEST");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager getManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory());
        return manager;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty ( "hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect" );
//      hibernateProperties.setProperty ( "hibernate.current_session_context_class", "thread" );
        hibernateProperties.setProperty ( "hibernate.show_sql", "true" );
        return hibernateProperties;
    }

    @Bean
    public Docket api() {
        return new Docket ( DocumentationType.SWAGGER_2 )
                  .select ()
                  .apis   ( RequestHandlerSelectors.any() )
                  .paths  ( PathSelectors.any() )
                  .build  ();
    }

}
