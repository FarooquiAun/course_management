package com.course.specifications;


import com.course.entites.Course;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class CourseSpecifications {
    public static Specification<Course> hasTitle(String title){
        return (root, query, criteriaBuilder) -> title==null?null:criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),"%" + title.toLowerCase()+"%");
    }
    public static Specification<Course> hasCategory(String category){
        return (root, query, criteriaBuilder) -> category==null? null:criteriaBuilder.like(criteriaBuilder.lower(root.get("category")),"%"+category.toLowerCase()+"%");
    }
    public static Specification<Course> createdAfter(LocalDateTime date){
        return (root, query, criteriaBuilder) -> date==null?null:criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"),date);
    }
    public static Specification<Course> createdBefore(LocalDateTime date){
        return (root, query, criteriaBuilder) -> date==null?null:criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"),date);
    }

}
