package com.course.repository;

import com.course.entites.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

    @Query("SELECT e FROM Enrollment e WHERE e.user.id=:userId")
    List<Enrollment> findUserById(@Param("userId") Long userId);
}
