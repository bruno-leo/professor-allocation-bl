package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	
	public List<Department> findAll(String name) {
		return name == null ? departmentRepository.findAll() : departmentRepository.findByNameIgnoreCaseContaining(name);
	}
	
	public Department findById(Long id) {
		return departmentRepository.findById(id).orElse(null);
	}
	
	public Department create(Department department) {
		return saveInternal(department);
	}
	
	public Department update(Department department) {
		boolean exist = departmentRepository.existsById(department.getId());
		if (exist) {
			return saveInternal(department);
		}
		return null;
	}
	
	private Department saveInternal(Department department) {
		return departmentRepository.save(department);
	}
	
	public boolean delete(Department department) {
		boolean exist = departmentRepository.existsById(department.getId());
		if (exist) {
			departmentRepository.delete(department);
		}
		return exist;
	}
	
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}
}
