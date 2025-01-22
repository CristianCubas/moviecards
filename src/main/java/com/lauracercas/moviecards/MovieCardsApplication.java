package com.lauracercas.moviecards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.lauracercas.moviecards.service"})
@SpringBootApplication
public class MovieCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCardsApplication.class, args);
    }

}
