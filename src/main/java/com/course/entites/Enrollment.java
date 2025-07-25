package com.course.entites;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="course_id")
    private Course course;

    private LocalDateTime enrolledAt;

    public Enrollment(Course course, LocalDateTime enrolledAt, Long id, User user) {
        this.course = course;
        this.enrolledAt = enrolledAt;
        this.id = id;
        this.user = user;
    }

    public Enrollment() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
