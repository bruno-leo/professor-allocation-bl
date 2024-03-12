package com.project.professor.allocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {

	@Autowired
	public DepartmentRepository departmentRepository;
	
	@Test
	public void createTest() {
		Department dp = new Department();
		dp.setName("Departamento de Engenharia de Software");
		
		Department dpTest = departmentRepository.save(dp);
		
		System.out.println(dpTest);
	}
	
	@Test
	public void updateTest() {
		Department dp = new Department();
		dp.setId(1L);
		dp.setName("Depto Engenharia de Software");
		
		Department dpTest = departmentRepository.save(dp);
		
		System.out.println(dpTest);
	}
	
	@Test
	public void readTest() {
		List<Department> dp = departmentRepository.findAll();
		
		System.out.println(dp);
	}
	
	@Test
	public void readOneTest() {
		Optional<Department> dp = departmentRepository.findById(2L);
		
		if (!dp.isEmpty()) {
			System.out.println(dp);
		}
		else {
			System.out.println("Department not found");
		}
	}
	
	
	@Test
	public void deleteTest() {
		Optional<Department> dp = departmentRepository.findById(1L);
		
		if (!dp.isEmpty()) {
			departmentRepository.deleteById(dp.get().getId());
			System.out.println("Deleted department");
		}
		else {
			System.out.println("Department not found");
		}
	}
}
