package com.gdn.afrizal.playground.spring.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.gdn.afrizal.playground.spring.client")
@EnableResourceServer
public class SpringBootPlayground extends ResourceServerConfigurerAdapter {

    @Value("${security.oauth2.resource.id}")
    private String resourceId;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPlayground.class, args);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**").authorizeRequests().anyRequest().authenticated()
            .anyRequest().permitAll();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer oauthServer) {
        oauthServer.resourceId(resourceId);
    }
}
