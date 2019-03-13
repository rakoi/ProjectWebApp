package com.rakoi.webapp.classeye.classeye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.naming.ConfigurationException;

@SpringBootApplication
public class ClasseyeApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ClasseyeApplication.class, args);
        System.out.println("READY");
    }


}
