package com.cg.threadlocaldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
public class ThreadlocaldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadlocaldemoApplication.class, args);
    }

}
