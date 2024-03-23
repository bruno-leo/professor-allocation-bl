package com.project.professor.allocation.service;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private ProfessorRepository professorRepository;
	private DepartmentService departmentService;
	
	public ProfessorService(ProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}
	
	
}
