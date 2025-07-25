package com.course.entites;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @JoinColumn(name = "course_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public Review(String comment, Course course, LocalDateTime createdAt, Long id, Integer rating, User user) {
        this.comment = comment;
        this.course = course;
        this.createdAt = createdAt;
        this.id = id;
        this.rating = rating;
        this.user = user;
    }

    public Review() {

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
