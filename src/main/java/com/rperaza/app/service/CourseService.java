package com.rperaza.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rperaza.app.model.Course;

public interface CourseService {

	public Iterable<Course> findAll();

	public Page<Course> findAll(Pageable pageable);

	public Optional<Course> findById(Long id);

	public Course save(Course course);

	public void deleteById(Long id);
}
