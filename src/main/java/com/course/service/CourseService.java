package com.course.service;

import com.course.dto.CourseCreateDto;
import com.course.dto.CourseDto;
import com.course.entites.Course;

import java.time.LocalDateTime;
import java.util.List;

public interface CourseService {
    CourseDto courseCreate(CourseCreateDto createDto);
    List<CourseDto> getTopCourses();
    List<CourseDto>  getCourses(String title, String category, LocalDateTime createdFrom,LocalDateTime createdTo);
}
