package com.rperaza.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rperaza.app.model.Course;
import com.rperaza.app.repository.CourseRepository;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Transactional(readOnly = true)
	public Iterable<Course> findAll() {
		return courseRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Course> findAll(Pageable pageable) {
		return courseRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Course> findById(Long id) {
		return courseRepository.findById(id);
	}

	@Override
	@Transactional
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		courseRepository.deleteById(id);

	}

}
