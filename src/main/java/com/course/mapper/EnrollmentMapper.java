package com.course.mapper;

import com.course.dto.EnrollmentDto;
import com.course.entites.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "course.id",target = "courseId")
    EnrollmentDto toDto(Enrollment enrollment);
}
