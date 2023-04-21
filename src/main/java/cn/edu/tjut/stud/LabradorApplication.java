package cn.edu.tjut.stud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@EnableTransactionManagement
public class LabradorApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(LabradorApplication.class, args);
    }

}
