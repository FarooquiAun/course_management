package com.course.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String category;
    private LocalDateTime createdAt;

     @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
     private List<Review> reviews;

     @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
     private List<Enrollment> enrollments;


}
