package com.course.controller;

import com.course.dto.CourseCreateDto;
import com.course.dto.CourseDto;
import com.course.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseCreateDto dto){
        return ResponseEntity.ok(courseService.courseCreate(dto));
    }
    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) LocalDateTime createdFrom,
            @RequestParam(required = false) LocalDateTime createdTo) {
        return ResponseEntity.ok(courseService.getCourses(title, category, createdFrom, createdTo));
    }


    @GetMapping("/top")
    public ResponseEntity<List<CourseDto>> getTopCourses(){
        return ResponseEntity.ok(courseService.getTopCourses());
    }
}
