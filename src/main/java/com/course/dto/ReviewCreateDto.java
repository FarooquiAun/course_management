package com.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewCreateDto {

    @Min(1)
    @Max(5)
    private Integer rating;
    @NotBlank(message = "Please add a comment ")
    private String comment;
    private Long userId;
    private Long courseId;
}
