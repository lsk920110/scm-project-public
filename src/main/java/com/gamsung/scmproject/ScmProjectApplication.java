package com.gamsung.scmproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ScmProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScmProjectApplication.class, args);
    }

}
