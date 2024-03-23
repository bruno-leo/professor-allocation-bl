package com.project.professor.allocation.service;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private AllocationRepository allocationRepository;
	private ProfessorService professorService;
	private CourseService courseService;
	
	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}
	
	
}
