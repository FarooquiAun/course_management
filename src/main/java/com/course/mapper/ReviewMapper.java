package com.course.mapper;

import com.course.dto.ReviewCreateDto;
import com.course.dto.ReviewDto;
import com.course.entites.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ReviewMapper{

//   @Mapping(source = "user.id",target = "userId")
//   @Mapping(source = "course.id",target = "courseId")
//    @Mapping(target = "userId", expression = "java(review.getUser() != null ? review.getUser().getId() : 0L)")
//    @Mapping(target = "courseId", expression = "java(review.getCourse() != null ? review.getCourse().getId() : 0L)")
@Mappings({
        @Mapping(source = "user.id", target = "userId"),
        @Mapping(source = "course.id", target = "courseId")
})

ReviewDto toDto(Review review);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "course", ignore = true)
    Review toEntity(ReviewCreateDto createDto);
}
