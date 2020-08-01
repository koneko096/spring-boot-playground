package com.gdn.afrizal.playground.spring.web.controller;

import com.gdn.afrizal.playground.spring.client.StudentClient;
import com.gdn.afrizal.playground.spring.mvc.dto.StudentEnrollment;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.reactive.ReactorFeign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApiController {

    private StudentClient studentClient;

    @Value("${client.student.endpoint}")
    private String studentEndpoint;

    @PostConstruct
    public void init() {
        this.studentClient = ReactorFeign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(StudentClient.class, studentEndpoint);
    }

    @GetMapping("/enrollment")
    public Mono<List<StudentEnrollment>> enrollment(@NotNull Authentication authentication) {
        return Mono.fromCallable(authentication::getName)
            .flatMap(name -> studentClient.getEnrollments(1L));
    }
}
