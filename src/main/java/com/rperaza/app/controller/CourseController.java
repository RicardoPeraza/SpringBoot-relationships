package com.rperaza.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rperaza.app.model.Course;

import com.rperaza.app.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	// create a new user
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Course course) {
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course));
	}

	// Read an user
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long courseId) {
		Optional<Course> oCourse = courseService.findById(courseId);
		if (!oCourse.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oCourse);

	}

	// update an user
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Course courseDetails, @PathVariable(value = "id") Long courseId) {
		Optional<Course> course = courseService.findById(courseId);
		if (!course.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		course.get().setName(courseDetails.getName());
		course.get().setProject(courseDetails.getProject());
		course.get().setThemes(courseDetails.getThemes());

		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course.get()));
	}

	// Delete User
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long courseId) {
		if (!courseService.findById(courseId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		courseService.deleteById(courseId);
		return ResponseEntity.ok().build();
	}

	// Read all Users
	@GetMapping
	public List<Course> readAll() {
		List<Course> courses = StreamSupport.stream(courseService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return courses;
	}

}
