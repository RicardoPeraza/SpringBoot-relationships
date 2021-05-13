package com.rperaza.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rperaza.app.model.Teacher;

public interface TeacherService {

	public Iterable<Teacher> findAll();

	public Page<Teacher> findAll(Pageable pageable);

	public Optional<Teacher> findById(Long id);

	public Teacher save(Teacher teacher);

	public void deleteById(Long id);
}
