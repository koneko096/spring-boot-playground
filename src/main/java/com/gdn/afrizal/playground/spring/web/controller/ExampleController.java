package com.gdn.afrizal.playground.spring.web.controller;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.core.Authentication;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ExampleController {

    @RequestMapping("/")
    public String index(Authentication authentication) {
        String name = authentication.getName();
        return "Greetings from Spring Boot for " + name;
    }
}
