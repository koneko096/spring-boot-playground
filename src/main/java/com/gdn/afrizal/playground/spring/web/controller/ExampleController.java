package com.gdn.afrizal.playground.spring.web.controller;

import com.gdn.afrizal.playground.spring.client.StudentClient;
import com.gdn.afrizal.playground.spring.mvc.dto.StudentEnrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ExampleController {

    @Autowired
    StudentClient studentClient;

    @RequestMapping("/enrollment")
    public List<StudentEnrollment> enrollment(Authentication authentication) {
        String name = authentication.getName();
        return studentClient.getEnrollments(1L, name);
    }
}
