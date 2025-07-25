package com.course.service;

import com.course.dto.ReviewCreateDto;
import com.course.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto addReview(ReviewCreateDto createDto);
    List<ReviewDto> getReviewByCourse(long courseId);
}
