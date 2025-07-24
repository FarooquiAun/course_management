package com.course.repository;

import com.course.entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>, JpaSpecificationExecutor<Course> {
    @Query("SELECT c FROM Course c WHERE c.category= :category")
    List<Course> findByCategoryJPQL(@Param("category") String category);
    @Query(value ="SELECT * FROM course c ORDER BY(SELECT COUNT(e.id) FROM enrollment e WHERE e.course_id=c.id) DESC LIMIT 5",nativeQuery = true)
    List<Course> findTopByNative();
}
