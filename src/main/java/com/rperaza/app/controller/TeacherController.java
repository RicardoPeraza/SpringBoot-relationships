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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rperaza.app.model.Teacher;
import com.rperaza.app.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	// create a new user
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Teacher teacher) {

		return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacher));
	}

	// Read an user
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long teacherId) {
		Optional<Teacher> oTeacher = teacherService.findById(teacherId);
		if (!oTeacher.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oTeacher);

	}

	// update an user
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Teacher teacherDetails, @PathVariable(value = "id") Long teacherId) {
		Optional<Teacher> teacher = teacherService.findById(teacherId);
		if (!teacher.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		teacher.get().setName(teacherDetails.getName());
		teacher.get().setAvatar(teacherDetails.getAvatar());

		return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacher.get()));
	}

	// Delete User
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long teacherId) {
		if (!teacherService.findById(teacherId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		teacherService.deleteById(teacherId);
		return ResponseEntity.ok().build();
	}

	// Read all Users
	@GetMapping
	public List<Teacher> readAll() {
		List<Teacher> teachers = StreamSupport.stream(teacherService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return teachers;
	}

	@RequestMapping(value = "/{id}/socialmedia", method = RequestMethod.GET)
	public ResponseEntity<?> getTeacherSocialMedia(@PathVariable long id) {
		Optional<Teacher> teacher = teacherService.findById(id);

		if (!teacher.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(teacher);
	}

}
