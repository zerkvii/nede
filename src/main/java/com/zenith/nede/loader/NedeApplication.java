package com.zenith.nede.loader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.zenith.nede.controller")
public class NedeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NedeApplication.class, args);
    }
}
