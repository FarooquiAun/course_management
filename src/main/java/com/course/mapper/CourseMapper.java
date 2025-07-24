package com.course.mapper;

import com.course.dto.CourseCreateDto;
import com.course.dto.CourseDto;
import com.course.entites.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toDto(Course course);
    Course toEntity(CourseCreateDto createDto);
}
