package com.project.professor.allocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	List<Professor> findByName(String name);
	
	List<Professor> findByNameLike(String name);
	
	List<Professor> findByNameContaining(String name);
	
	List<Professor> findByNameIgnoreCaseContaining(String name);
	
	List<Professor> findByDepartment(Department department);
	
	Professor findByCpf(String cpf);
	
	List<Professor> findByCpfContaining(String cpf);
}
