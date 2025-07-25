package com.course.service;

import com.course.dto.EnrollmentDto;

public interface EnrollmentService {
    EnrollmentDto enroll(long courseId,long userId);
}
