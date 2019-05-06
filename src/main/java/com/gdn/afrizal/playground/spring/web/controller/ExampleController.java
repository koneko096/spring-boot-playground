package com.gdn.afrizal.playground.spring.web.controller;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ExampleController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
