package com.rperaza.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rperaza.app.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
