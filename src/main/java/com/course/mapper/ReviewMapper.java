package com.course.mapper;

import com.course.dto.ReviewCreateDto;
import com.course.dto.ReviewDto;
import com.course.entites.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper{

    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "course.id",target = "courseId")
    ReviewDto toDto(Review review);

    Review toEntity(ReviewCreateDto createDto);
}
