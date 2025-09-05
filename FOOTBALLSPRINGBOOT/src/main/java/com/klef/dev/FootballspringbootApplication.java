package com.klef.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FootballspringbootApplication extends SpringBootServletInitializer
{
    public static void main(String[] args) {
        SpringApplication.run(FootballspringbootApplication.class, args);
        System.out.println("Football Player Spring Boot Project is Running ...");
    }
}
