package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;
	private final ProfessorService professorService;
	private final CourseService courseService;
	
	public AllocationService(AllocationRepository allocationRepository, ProfessorService professorService,
			CourseService courseService) {
		super();
		this.allocationRepository = allocationRepository;
		this.professorService = professorService;
		this.courseService = courseService;
	}
	
	public List<Allocation> findAll() {
		return allocationRepository.findAll();
	}
	
	public Allocation findById(Long id) {
		return allocationRepository.findById(id).orElse(null);
	}
	
	public Allocation create(Allocation allocation) {
		return saveInternal(allocation);
	}
	
	public Allocation update(Allocation allocation) {
		boolean exist = allocationRepository.existsById(allocation.getId());
		if (exist) {
			
		}
		return null;
	}
	
	private Allocation saveInternal(Allocation allocation) {
		if (hasCollision(allocation)) {
			throw new RuntimeException();
		}
		else {
			Allocation alloc = allocationRepository.save(allocation);

			Professor pf = professorService.findById(alloc.getProfessor().getId());
			alloc.setProfessor(pf);

			Course crs = courseService.findById(alloc.getCourse().getId());
			alloc.setCourse(crs);

			return alloc;
		}
	}
	
	private boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
		return !currentAllocation.getId().equals(newAllocation.getId())
				&& currentAllocation.getDay() == newAllocation.getDay()
				&& currentAllocation.getStart().compareTo(newAllocation.getStart()) < 0
				&& currentAllocation.getEnd().compareTo(newAllocation.getEnd()) < 0;
	}
	
	private boolean hasCollision(Allocation newAllocation) {
		boolean hasCollision = false;
		
		List<Allocation> currentAllocations = allocationRepository.findByProfessor(newAllocation.getProfessor());
		for (Allocation currentAllocation : currentAllocations) {
			hasCollision = hasCollision(currentAllocation, newAllocation);
			if (hasCollision) {
				break;
			}
		}
		
		return hasCollision;
	}
}
