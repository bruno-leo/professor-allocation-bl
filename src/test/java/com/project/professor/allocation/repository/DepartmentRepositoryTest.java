package com.project.professor.allocation.repository;

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
}
