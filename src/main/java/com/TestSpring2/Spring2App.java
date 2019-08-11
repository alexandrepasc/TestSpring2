package com.TestSpring2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.Arrays;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class Spring2App {
  
  @Value("${spring.application.name:demoservice}")
  String name;
  
  public static void main(String[] args) {
    SpringApplication.run(Spring2App.class, args);
  }
  
  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println(name);
      System.out.println("Let's inspect the beans provided by Spring Boot:");
      
      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }
  
  //  @Bean
  //  public RestTemplate getRestTemplate() {
  //    return new RestTemplate();
  //  }
}
