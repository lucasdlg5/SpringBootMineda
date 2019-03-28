package com.fatec.fatecSpring.service;

import java.util.List;

import com.fatec.fatecSpring.model.Department;

public interface DepartmentService {
	
	public Department findByObservation(String phrase);
	public Department findByName(String name);
	public List<Department> findByNameList(String name);
	public void truncateDatabaseDepartment();
	
}
