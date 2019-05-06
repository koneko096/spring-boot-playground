package com.gdn.afrizal.playground.spring.client;

import com.gdn.afrizal.playground.spring.mvc.dto.StudentEnrollment;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class StudentClientFallback implements StudentClient {
    @Override
    public List<StudentEnrollment> getEnrollments(Long studentId, String username) {
        return Collections.emptyList();
    }
}
