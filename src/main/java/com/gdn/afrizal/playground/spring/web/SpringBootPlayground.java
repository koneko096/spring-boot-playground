package com.gdn.afrizal.playground.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
//@EnableFeignClients(basePackages = "com.gdn.afrizal.playground.spring.client")
@EnableWebFlux
@EnableWebFluxSecurity
public class SpringBootPlayground {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPlayground.class, args);
    }
}
