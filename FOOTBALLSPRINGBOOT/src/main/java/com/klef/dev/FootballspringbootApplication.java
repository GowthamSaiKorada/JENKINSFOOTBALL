package com.klef.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FootballspringbootApplication extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // This tells external Tomcat what the primary Spring Boot source is
        return application.sources(FootballspringbootApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FootballspringbootApplication.class, args);
        System.out.println("Football Player Spring Boot Project is Running ...");
    }
}
