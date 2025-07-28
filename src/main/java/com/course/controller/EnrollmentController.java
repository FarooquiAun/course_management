package com.course.controller;

import com.course.dto.EnrollmentDto;
import com.course.entites.Enrollment;
import com.course.service.EnrollmentService;
import org.hibernate.annotations.processing.Find;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    public ResponseEntity<EnrollmentDto> enroll(@RequestParam Long userId,@RequestParam Long courseId){
        return ResponseEntity.ok(service.enroll(courseId,userId));
    }
}
