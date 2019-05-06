package com.gdn.afrizal.playground.spring.client;

import com.gdn.afrizal.playground.spring.mvc.dto.StudentEnrollment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name="student",
        fallback = StudentClientFallback.class
)
public interface StudentClient {
    @RequestMapping(value = "/student/{studentId}/enrollment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<StudentEnrollment> getEnrollments(@PathVariable("studentId") Long studentId, @RequestParam("username") String username);
}
