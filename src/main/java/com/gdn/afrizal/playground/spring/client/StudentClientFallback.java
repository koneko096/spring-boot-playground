package com.gdn.afrizal.playground.spring.client;

import com.gdn.afrizal.playground.spring.mvc.dto.StudentEnrollment;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Component
public class StudentClientFallback implements StudentClient {
    @Override
    public Mono<List<StudentEnrollment>> getEnrollments(Long studentId) {
        return Mono.fromCallable(Collections::emptyList);
    }
}
