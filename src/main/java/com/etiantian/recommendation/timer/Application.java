package com.etiantian.recommendation.timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.*;

/**
 * application start
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan
@EnableAutoConfiguration
@ServletComponentScan
public class Application {

    public static ApplicationContext applicationContext;

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(Application.class);
        app.setWebEnvironment(false);
        Set<Object> set = new HashSet<Object>();
        set.add("classpath:applicationContext.xml");
        app.setSources(set);
        applicationContext = app.run(args);

    }
}
