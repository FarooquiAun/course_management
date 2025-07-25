package com.course.service;

import com.course.dto.CourseCreateDto;
import com.course.dto.CourseDto;
import com.course.entites.Course;
import com.course.mapper.CourseMapper;
import com.course.repository.CourseRepository;
import com.course.specifications.CourseSpecifications;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service

@Transactional
public class CourseServiceImpl implements CourseService {
     private final CourseRepository courseRepository;
     private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseMapper courseMapper, CourseRepository courseRepository) {
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto courseCreate(CourseCreateDto createDto) {
        Course course=courseMapper.toEntity(createDto);
        course.setCreatedAt(LocalDateTime.now());
        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public List<CourseDto> getTopCourses() {

        return courseRepository.findTopByNative()
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCourses(String title, String category, LocalDateTime createdFrom, LocalDateTime createdTo) {
        Specification<Course> spec=Specification.anyOf(CourseSpecifications.hasTitle(title),
                CourseSpecifications.hasCategory(category),
                CourseSpecifications.createdAfter(createdFrom),
                CourseSpecifications.createdBefore(createdTo)
               );
        return courseRepository.findAll(spec)
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }


}
