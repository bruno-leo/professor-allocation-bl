package com.project.professor.allocation.service;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	
}
