package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository professorRepository;
	private final DepartmentService departmentService;
	
	public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService) {
		super();
		this.professorRepository = professorRepository;
		this.departmentService = departmentService;
	}
	
	public List<Professor> findAll(String name) {
		return name == null ? professorRepository.findAll() : professorRepository.findByNameIgnoreCaseContaining(name);
	}
	
	public Professor findById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}
	
	public Professor create(Professor professor) {
		return saveInternal(professor);
	}
	
	public Professor update(Professor professor) {
		boolean exist = professorRepository.existsById(professor.getId());
		if (exist) {
			return saveInternal(professor);
		}
		return null;
	}
	
	private Professor saveInternal(Professor professor) {
		Professor pf = professorRepository.save(professor);
		Department pfDep = departmentService.findById(pf.getDepartment().getId());
		
		pf.setDepartment(pfDep);
		
		return pf;
	}
	
	public boolean delete(Professor professor) {
		boolean exist = professorRepository.existsById(professor.getId());
		if (exist) {
			professorRepository.delete(professor);
		}
		return exist;
	}
	
	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}
}
