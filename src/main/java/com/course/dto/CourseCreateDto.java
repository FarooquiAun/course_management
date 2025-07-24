package com.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseCreateDto {
    @NotBlank(message = "title cannot be empty")
    private String title;
    @NotBlank(message = "description cannot be empty")
    private String description;
    @NotBlank(message = "category cannot be empty")
    private String category;
}
