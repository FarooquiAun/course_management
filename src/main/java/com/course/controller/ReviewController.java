package com.course.controller;

import com.course.dto.ReviewCreateDto;
import com.course.dto.ReviewDto;
import com.course.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping
    public ResponseEntity<ReviewDto> addReview(@Valid @RequestBody ReviewCreateDto dto){
        return ResponseEntity.ok(reviewService.addReview(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<ReviewDto>> getReviewByCourse(@PathVariable Long courseId){
        return ResponseEntity.ok(reviewService.getReviewByCourse(courseId));
    }
}
