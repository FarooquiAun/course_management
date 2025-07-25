package com.course.dto;


import javax.validation.constraints.NotBlank;


public class CourseCreateDto {
    @NotBlank(message = "title cannot be empty")
    private String title;
    @NotBlank(message = "description cannot be empty")
    private String description;
    @NotBlank(message = "category cannot be empty")
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
