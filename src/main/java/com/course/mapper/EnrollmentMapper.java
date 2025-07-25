package com.course.mapper;

import com.course.dto.EnrollmentDto;
import com.course.entites.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
//    @Mapping(source = "user_id",target = "userId")
//    @Mapping(source = "course_id",target = "courseId")
//@Mapping(target = "userId", expression = "java(review.getUser() != null ? enrollment.getUser().getId() : 0L)")
//@Mapping(target = "courseId", expression = "java(review.getCourse() != null ? enrollment.getCourse().getId() : 0L)")

    @Mappings({
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "course.id", target = "courseId")
    })
    EnrollmentDto toDto(Enrollment enrollment);
}
