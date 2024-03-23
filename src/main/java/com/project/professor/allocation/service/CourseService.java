package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	public List<Course> findAll(String name) {
		return name == null ? courseRepository.findAll() : courseRepository.findByNameIgnoreCaseContaining(name);
	}
	
	public Course findById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}
	
	public Course create(Course course) {
		return saveInternal(course);
	}
	
	public Course update(Course course) {
		boolean exist = courseRepository.existsById(course.getId());
		if (exist) {
			return saveInternal(course);
		}
		return null;
	}
	
	private Course saveInternal(Course course) {
		return courseRepository.save(course);
	}
	
	public boolean delete(Course course) {
		boolean exist = courseRepository.existsById(course.getId());
		if (exist) {
			courseRepository.delete(course);
		}
		return exist;
	}
	
	public void deleteAll() {
		courseRepository.deleteAllInBatch();
	}
}
