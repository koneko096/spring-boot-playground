package com.gdn.afrizal.playground.spring.client;

import com.gdn.afrizal.playground.spring.mvc.dto.StudentEnrollment;
import feign.Param;
import feign.RequestLine;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StudentClient {
    @RequestLine("GET /student/{studentId}/enrollment")
    Mono<List<StudentEnrollment>> getEnrollments(@Param("studentId") Long studentId);
}
