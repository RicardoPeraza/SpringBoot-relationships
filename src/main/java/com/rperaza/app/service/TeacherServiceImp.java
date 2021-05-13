package com.rperaza.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rperaza.app.model.Teacher;
import com.rperaza.app.repository.TeacherRepository;

@Service
public class TeacherServiceImp implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Transactional(readOnly = true)
	public Iterable<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Teacher> findAll(Pageable pageable) {
		return teacherRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Teacher> findById(Long id) {
		return teacherRepository.findById(id);
	}

	@Override
	@Transactional
	public Teacher save(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		teacherRepository.deleteById(id);

	}

}
