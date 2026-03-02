package com.aluracursos.foro_hub_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.aluracursos.foro_hub_api")
public class ForoHubApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForoHubApiApplication.class, args);
    }
}