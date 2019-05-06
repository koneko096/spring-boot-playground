package com.gdn.afrizal.playground.spring.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name="client",
        url="http://localhost:8081"
)
public interface Client {

}
