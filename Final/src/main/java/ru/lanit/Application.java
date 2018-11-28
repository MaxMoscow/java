package ru.lanit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class Application
{

    public static void main ( String[] args )
    {
        SpringApplication.run ( Application.class, args );
    }

//  @Override
    public void run ( String[] args ) throws Exception
    {
//      UserDAO     dao         = ctx.getBean ( "UserDAO", UserDAO.class );
//      UserService userService = ctx.getBean ( "userService", UserService.class );
//      UserService userService = new UserService();
//      userService.runTest();
//      userService.checkResults();
    }

}
