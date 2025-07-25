package com.course.service;

import com.course.dto.ReviewCreateDto;
import com.course.dto.ReviewDto;
import com.course.entites.Course;
import com.course.entites.Review;
import com.course.entites.User;
import com.course.mapper.ReviewMapper;
import com.course.repository.CourseRepository;
import com.course.repository.ReviewRepository;
import com.course.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service

@Transactional
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public ReviewServiceImpl(CourseRepository courseRepository, ReviewMapper reviewMapper, ReviewRepository reviewRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.reviewMapper = reviewMapper;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ReviewDto addReview(ReviewCreateDto createDto) {
        User user=userRepository.findById(createDto.getUserId()).orElseThrow(
                ()->new EntityNotFoundException("User not found")
        );
        Course course=courseRepository.findById(createDto.getCourseId()).orElseThrow(
                ()-> new EntityNotFoundException("course not found exception")
        );
//         Review review=Review.builder()
//                 .rating(createDto.getRating())
//                 .comment(createDto.getComment())
//                 .createdAt(LocalDateTime.now())
//                 .user(user)
//                 .course(course)
//                 .build();
        Review review = new Review();
        review.setRating(createDto.getRating());
        review.setComment(createDto.getComment());
        review.setCreatedAt(LocalDateTime.now());
        review.setUser(user);
        review.setCourse(course);

        return reviewMapper.toDto(reviewRepository.save(review));
    }

    @Override
    public List<ReviewDto> getReviewByCourse(long courseId) {

        return reviewRepository.findByCourseId(courseId)
                .stream().map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }
}
