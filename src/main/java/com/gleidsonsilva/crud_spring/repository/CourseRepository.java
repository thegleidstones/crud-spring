package com.gleidsonsilva.crud_spring.repository;

import com.gleidsonsilva.crud_spring.enums.Status;
import com.gleidsonsilva.crud_spring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByStatus(Status status);
}
