package cn.edu.tjut.stud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class LabradorApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(LabradorApplication.class, args);
    }

}
