package com.clanner.antichat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Clanner
 */
@SpringBootApplication
@EnableCaching
public class AntiChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntiChatApplication.class, args);
    }

}
