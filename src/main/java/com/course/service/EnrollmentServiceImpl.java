package com.course.service;

import com.course.dto.EnrollmentDto;
import com.course.entites.Course;
import com.course.entites.Enrollment;
import com.course.entites.User;
import com.course.mapper.EnrollmentMapper;
import com.course.repository.CourseRepository;
import com.course.repository.EnrollmentRepository;
import com.course.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public EnrollmentServiceImpl(CourseRepository courseRepository, EnrollmentRepository enrollmentRepository, EnrollmentMapper enrollmentMapper, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.enrollmentMapper = enrollmentMapper;
        this.userRepository = userRepository;
    }

    @Override
    public EnrollmentDto enroll(long courseId, long userId) {
        User user=userRepository.findById(userId).orElseThrow(
                ()-> new EntityNotFoundException("User not found")
        );
        Course course=courseRepository.findById(courseId).orElseThrow(
                ()-> new EntityNotFoundException("Course not found ")
        );
        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setEnrolledAt(LocalDateTime.now());
        return enrollmentMapper.toDto(enrollmentRepository.save(enrollment));
    }
}
